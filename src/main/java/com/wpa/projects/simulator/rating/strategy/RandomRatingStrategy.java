/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

package com.wpa.projects.simulator.rating.strategy;

import static java.lang.Math.*;
import java.math.BigDecimal;
import java.util.Random;

import com.wpa.projects.simulator.investments.Fund;
import com.wpa.projects.simulator.rating.RatingStrategy;

/**
 * 
 *
 */
public class RandomRatingStrategy implements RatingStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wpa.projects.simulator.rating.RatingStrategy#rate(com.wpa.projects
	 * .simulator.investments.Fund)
	 */
	@Override
	public BigDecimal rate(Fund fund) {

		switch (fund) {
		case Money_Market:
			return generateRandom(new BigDecimal("-0.05"), new BigDecimal(
					"0.40"));
		case Bond:
			return generateRandom(new BigDecimal("-0.15"), new BigDecimal(
					"0.60"));
		case Balanced:
			return generateRandom(new BigDecimal("-0.80"), new BigDecimal(
					"0.96"));
		case Stable_Growth:
			return generateRandom(new BigDecimal("-0.65"), new BigDecimal(
					"0.85"));
		case Equity:
			return generateRandom(new BigDecimal("-1.00"), new BigDecimal(
					"1.10"));
		default:
			return new BigDecimal(0);
		}
	}

	/**
	 * Simple algorithm to generate random value between two borders
	 * 
	 * @param Min
	 *            value
	 * @param Max
	 *            value
	 * @return <BigDecimal> in specified range
	 */
	BigDecimal generateRandom(BigDecimal begin, BigDecimal end) {
		Double Min = begin.doubleValue();
		Double Max = end.doubleValue();
		Double random = abs(Min) + (Math.random() * ((Max - abs(Min))))
				- abs(Min);

		return new BigDecimal(random).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
