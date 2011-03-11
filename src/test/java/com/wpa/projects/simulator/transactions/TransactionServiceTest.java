/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 11, 2011
 */

package com.wpa.projects.simulator.transactions;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.InstanceOf;
import org.mockito.internal.matchers.Matches;

import com.wpa.projects.simulator.assets.Wallet;
import com.wpa.projects.simulator.assets.WalletProvider;
import com.wpa.projects.simulator.investments.Fund;
import com.wpa.projects.simulator.investments.Unit;
import com.wpa.projects.simulator.investments.UnitA;
import com.wpa.projects.simulator.investments.UnitB;
import com.wpa.projects.simulator.investments.Unit.UnitType;

import static org.hamcrest.Matchers.*;

/**
 * 
 *
 */
public class TransactionServiceTest {

	private Wallet wallet;
	private TransactionService transactionService;

	@Before
	public void setUp() {
		wallet = WalletProvider.getWallet();
		transactionService = new TransactionService();
	}

	@Test
	public void testAsk() {

		BigDecimal cash;
		boolean statusA = transactionService.ask(wallet, 1, Fund.Balanced,
				UnitType.A);
		assertTrue(statusA);

		cash = wallet.getAvalilableCash();
		assertEquals(102, 1000 - cash.intValue());

		boolean statusB = transactionService.ask(wallet, 1, Fund.Balanced,
				UnitType.B);
		assertTrue(statusB);
		assertEquals(2, wallet.getTradingRegister().size());

		Unit unitA = (Unit) wallet.getTradingRegister().toArray()[0];
		Unit unitB = (Unit) wallet.getTradingRegister().toArray()[1];

		assertEquals(Fund.Balanced, unitA.getFund());
		assertEquals(Fund.Balanced, unitB.getFund());

		assertThat(unitA, instanceOf(UnitA.class));
		assertThat(unitB, instanceOf(UnitB.class));

		BigDecimal askPriceA = unitA.askPrice();
		BigDecimal bidPriceA = unitA.bidPrice();

		assertEquals(2, getCommissionValue(askPriceA, bidPriceA).intValue());

		BigDecimal askPriceB = unitB.askPrice();
		BigDecimal bidPriceB = unitB.bidPrice();
		assertEquals(2, getCommissionValue(bidPriceB, askPriceB).intValue());

		cash = wallet.getAvalilableCash();
		BigDecimal theoreticalCostOfUnits = askPriceA.add(askPriceB);
		BigDecimal realCostOfUnits = new BigDecimal("1000").subtract(cash);
		assertEquals(theoreticalCostOfUnits, realCostOfUnits);

	}

	@Test
	public void testBid() {

		BigDecimal cash;
		boolean statusA = transactionService.ask(wallet, 1, Fund.Balanced,
				UnitType.A);
		assertTrue(statusA);
		boolean statusB = transactionService.ask(wallet, 1, Fund.Balanced,
				UnitType.B);
		assertTrue(statusB);
		assertEquals(2, wallet.getTradingRegister().size());
		Unit unitA = (Unit) wallet.getTradingRegister().toArray()[0];
		Unit unitB = (Unit) wallet.getTradingRegister().toArray()[1];

		assertEquals(Fund.Balanced, unitA.getFund());
		assertEquals(Fund.Balanced, unitB.getFund());

		assertThat(unitA, instanceOf(UnitA.class));
		assertThat(unitB, instanceOf(UnitB.class));

		Collection<Unit> unitsToSell = new ArrayList<Unit>();
		unitsToSell.add(unitA);
		cash = wallet.getAvalilableCash();
		transactionService.bid(wallet, unitsToSell);
		assertEquals(1, unitsToSell.size());
		assertEquals(1, wallet.getTradingRegister().size());
		assertEquals(cash.add(unitA.bidPrice()),wallet.getAvalilableCash());
		
		unitsToSell.remove(unitA);
		unitsToSell.add(unitB);
		cash = wallet.getAvalilableCash();
		transactionService.bid(wallet, unitsToSell);		
		assertEquals(1, unitsToSell.size());
		assertEquals(0, wallet.getTradingRegister().size());
		assertEquals(1000, wallet.getAvalilableCash().intValue());


	}

	private BigDecimal getCommissionValue(BigDecimal withCommission,
			BigDecimal withoutCommision) {

		BigDecimal commission = withCommission.divide(withoutCommision)
				.subtract(new BigDecimal("1")).multiply(new BigDecimal("100"));

		return commission;
	}

}
