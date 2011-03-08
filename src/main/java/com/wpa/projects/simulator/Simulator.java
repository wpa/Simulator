/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

package com.wpa.projects.simulator;

import java.util.Collection;
import java.util.Observer;

import com.wpa.projects.simulator.rating.RatingProvider;
import com.wpa.projects.simulator.transactions.TransactionServiceProvider;

/**
 * 
 *
 */
public class Simulator {

	private final RatingProvider ratingProvider;
	private final TransactionServiceProvider transactionsProvider;

	public Simulator() {

		ratingProvider = new RatingProvider(10);
		transactionsProvider = new TransactionServiceProvider();
	}

	public void startRatings() {

		Thread ratingThread = new Thread(ratingProvider.getRating());
		ratingThread.start();
	}

	public void registerRatingListeners(Collection<Observer> collectionObservers) {

		for (Observer observer : collectionObservers) {
			ratingProvider.getRating().addObserver(observer);
		}

	}

	public void registerTransactionListeners(
			Collection<Observer> collectionObservers) {

		for (Observer observer : collectionObservers) {
			transactionsProvider.getTransactionService().addObserver(observer);
		}

	}

}
