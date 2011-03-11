/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 11, 2011
 */

package com.wpa.projects.simulator.rating.strategy;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 *
 */
public class RandomRatingStrategyTest {

	private RandomRatingStrategy randomStrategy;
	private Collection<Map<BigDecimal, BigDecimal>> numberList = new ArrayList<Map<BigDecimal, BigDecimal>>();

	@Before
	public void setUp() {
		randomStrategy = new RandomRatingStrategy();
		Map<BigDecimal, BigDecimal> Money_Market = new HashMap<BigDecimal, BigDecimal>();
		Money_Market.put(new BigDecimal("-0.05"), new BigDecimal("0.40"));
		Map<BigDecimal, BigDecimal> Bond = new HashMap<BigDecimal, BigDecimal>();
		Bond.put(new BigDecimal("-0.15"), new BigDecimal("0.60"));
		Map<BigDecimal, BigDecimal> Balanced = new HashMap<BigDecimal, BigDecimal>();
		Balanced.put(new BigDecimal("-0.80"), new BigDecimal("0.96"));
		Map<BigDecimal, BigDecimal> Stable_Growth = new HashMap<BigDecimal, BigDecimal>();
		Stable_Growth.put(new BigDecimal("-0.65"), new BigDecimal("0.85"));
		Map<BigDecimal, BigDecimal> Equity = new HashMap<BigDecimal, BigDecimal>();
		Equity.put(new BigDecimal("-1.00"), new BigDecimal("1.10"));
		numberList.add(Money_Market);
		numberList.add(Balanced);
		numberList.add(Bond);
		numberList.add(Balanced);
		numberList.add(Equity);
	}

	@Test
	public void testGenerateRandom() {

		for (Map<BigDecimal, BigDecimal> fundRateChanges : numberList) {

			for (Entry<BigDecimal, BigDecimal> entry : fundRateChanges
					.entrySet()) {

				testRandom(entry.getKey(), entry.getValue());
			}
		}
	}

	private void testRandom(BigDecimal begin, BigDecimal end) {
		for (int i = 0; i < 200; i++) {
			BigDecimal generated = randomStrategy.generateRandom(begin, end);
			System.out.println(generated);
			assertTrue(begin.compareTo(generated) < 0);
			assertTrue(end.compareTo(generated) > 0);
		}
	}
}
