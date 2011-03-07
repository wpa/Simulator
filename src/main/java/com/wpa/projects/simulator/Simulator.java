/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

package com.wpa.projects.simulator;

import com.wpa.projects.simulator.rating.Rating;
import com.wpa.projects.simulator.rating.RatingStrategy;
import com.wpa.projects.simulator.rating.strategy.RandomRatingStrategy;

/**
 * 
 *
 */
public class Simulator {

	public Simulator() {

	}

	public void startRatings() {
		RatingStrategy strategy = new RandomRatingStrategy();
		Thread ratingThread = new Thread(new Rating(strategy, 10));
		ratingThread.start();
	}

}
