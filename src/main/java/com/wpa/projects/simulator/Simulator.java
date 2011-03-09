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
import com.wpa.projects.simulator.transactions.TransactionService;
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

	public TransactionService getTransactionService() {
		return transactionsProvider.getTransactionService();
	}

	public void startRatings() {

		Thread ratingThread = new Thread(ratingProvider.getRating());
		ratingThread.start();
	}

	public void registerRatingListener(Observer observer) {

		ratingProvider.getRating().addObserver(observer);
	}

	public void registerTransactionListener(Observer observer) {
		transactionsProvider.getTransactionService().addObserver(observer);
	}

}
