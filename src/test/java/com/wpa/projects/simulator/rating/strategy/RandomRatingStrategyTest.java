/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 11, 2011
 */

package com.wpa.projects.simulator.rating.strategy;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import static org.hamcrest.Matchers.*;

/**
 * 
 *
 */
public class RandomRatingStrategyTest {

	private RandomRatingStrategy randomStrategy;

	@Before
	public void setUp() {
		randomStrategy = new RandomRatingStrategy();
	}

	@Test
	public void testGenerateRandom() {

		BigDecimal begin = new BigDecimal("1");
		BigDecimal end = new BigDecimal("2");
		for (int i = 0; i < 10; i++) {
			// BigDecimal generated = randomStrategy.generateRandom(begin, end);
			BigDecimal generated = new BigDecimal("1.99");
			System.out.println(generated);
			assertTrue(begin.compareTo(generated) < 0);
			assertTrue(end.compareTo(generated) > 0);
		}

	}
}
