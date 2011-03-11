/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 11, 2011
 */

package com.wpa.projects.simulator.rating;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.wpa.projects.simulator.investments.Fund;

/**
 * 
 *
 */
public class RatingTest {

	private Rating rating;
	private RatingStrategy strategy;

	@Before
	public void setUp() {

	}

	@Test
	public void testRun() {
		strategy = new RatingStrategy() {

			@Override
			public BigDecimal rate(Fund fund) {

				return new BigDecimal("10");
			}
		};
		rating = new Rating(2, strategy, 1);
		rating.run();
		BigDecimal unitPrice = Fund.Equity.getUnitsPrice();
		assertEquals(110, unitPrice.intValue());

	}
}
