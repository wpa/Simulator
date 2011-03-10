/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

package com.wpa.projects.simulator.transactions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;

import com.wpa.projects.simulator.assets.Purchaser;
import com.wpa.projects.simulator.assets.Salable;
import com.wpa.projects.simulator.investments.Fund;
import com.wpa.projects.simulator.investments.Unit;
import com.wpa.projects.simulator.investments.Unit.UnitType;

/**
 * 
 *
 */
public class TransactionService extends Observable {

	TransactionService() {

	}

	public synchronized void bid(Salable seller, Collection<Unit> unitsToSale) {

		BigDecimal amount = new BigDecimal("0.00");
		Transaction transaction = new Transaction();
		transaction.activate();
		for (Unit unit : unitsToSale) {
			amount = amount.add(unit.bidPrice());
			unit.getFund().releaseUnit(unit, transaction);
		}
		seller.getTradingRegister().removeAll(unitsToSale);
		seller.credit(amount);
		transaction.deactivate();
		setChanged();
		notifyObservers();

	}

	public synchronized boolean ask(Purchaser customer, Integer quantity,
			Fund fund, UnitType unitType) {

		BigDecimal price = new BigDecimal("0.00");
		Transaction transaction = new Transaction();
		transaction.activate();
		boolean success = false;
		Collection<Unit> unitsToBuy = new ArrayList<Unit>();
		for (int i = 1; i <= quantity; i++) {
			Unit unit = fund.getUnit(unitType, transaction);
			price = price.add(unit.askPrice());
			unitsToBuy.add(unit);
		}
		if (customer.liability(price)) {

			customer.getTradingRegister().addAll(unitsToBuy);
			success = true;
		} else {
			fund.releaseUnits(unitsToBuy, transaction);
		}
		transaction.deactivate();
		setChanged();
		notifyObservers();

		return success;

	}

	public class Transaction {
		private volatile boolean isActive = false;

		private Transaction() {

		}

		public boolean isTransactionActive() {
			return isActive;
		}

		private synchronized void activate() {
			this.isActive = true;
		}

		private synchronized void deactivate() {
			this.isActive = false;
		}
	};

}
