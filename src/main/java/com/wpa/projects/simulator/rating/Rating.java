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
 * Class responsible for rating <code>Fund</code>
 *
 */
public class Rating extends Observable implements Runnable {

	private final Integer ratingInterval;
	private final RatingHelper ratingHandler;
	private final Integer numberOFRepeats;
	private volatile Integer loopCounter = 1;

	Rating(RatingStrategy strategy, Integer ratingInterval) {
		this.ratingInterval = ratingInterval;
		this.ratingHandler = new RatingHelper(strategy);
		this.numberOFRepeats = null;

	}

	Rating(Integer numberOFRepeats, RatingStrategy strategy,
			Integer ratingInterval) {
		this.ratingInterval = ratingInterval;
		this.ratingHandler = new RatingHelper(strategy);
		this.numberOFRepeats = numberOFRepeats;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		try {
			while (isActive()) {
				// Endless loop
				ratingHandler.rate();
				setChanged();
				notifyObservers();
				Thread.sleep(ratingInterval * 1000);
			}

		} catch (InterruptedException e) {
			// Intentionally ignored this exception.
		}

	}

	private synchronized boolean isActive() {

		if (numberOFRepeats == null) {
			return true;
		} else if (loopCounter < numberOFRepeats) {
			loopCounter++;
			return true;
		} else {
			return false;
		}
	}

}
