/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

package com.wpa.projects.simulator.rating;

import java.util.Observable;

import com.wpa.projects.simulator.investments.RatingHelper;

/**
 * 
 *
 */
public class Rating  extends Observable implements Runnable {

	private final Integer ratingInterval;
	private final RatingHelper ratingHandler;

	   Rating(RatingStrategy strategy, Integer ratingInterval) {
		this.ratingInterval = ratingInterval;
		this.ratingHandler = new RatingHelper(strategy);

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
				setChanged();
				notifyObservers();
			}

		} catch (InterruptedException e) {
			// Intentionally ignored this exception.
		}

	}

}
