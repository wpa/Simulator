/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

package com.wpa.projects.simulator.investments;

import com.wpa.projects.simulator.rating.RatingStrategy;

/**
 * 
 *
 */
public class RatingHandler {

	private final RatingStrategy strategy;

	public RatingHandler(RatingStrategy strategy) {

		this.strategy = strategy;
	}

	public void rate() {

		for (Fund fund : Fund.values()) {

			fund.rateUnits(strategy.rate(fund));
		}

	}
}
