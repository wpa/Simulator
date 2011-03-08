/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 8, 2011
 */

package com.wpa.projects.simulator.rating;

import com.wpa.projects.simulator.rating.strategy.RandomRatingStrategy;

/**
 * 
 *
 */
public class RatingProvider {

	private final Rating rating;

	public RatingProvider(Integer ratingInterval) {

		RatingStrategy strategy = new RandomRatingStrategy();
		rating = new Rating(strategy, ratingInterval);
	}

	public Rating getRating() {
		return rating;
	}
}
