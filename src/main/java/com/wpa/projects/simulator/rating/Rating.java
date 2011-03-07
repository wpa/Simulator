/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

package com.wpa.projects.simulator.rating;

import com.wpa.projects.simulator.investments.RatingHandler;

/**
 * 
 *
 */
public class Rating implements Runnable {

	private final Integer ratingInterval;
	private final RatingHandler ratingHandler;

	public Rating(RatingStrategy strategy, Integer ratingInterval) {
		this.ratingInterval = ratingInterval;
		this.ratingHandler = new RatingHandler(strategy);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		try {
			while (true) {
			//Endless loop
				Thread.sleep(ratingInterval * 1000);
				ratingHandler.rate();
			}

		} catch (InterruptedException e) {
			// Intentionally ignored this exception.
		}

	}

}
