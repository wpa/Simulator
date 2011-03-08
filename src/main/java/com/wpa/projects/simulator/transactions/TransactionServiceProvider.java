/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 8, 2011
 */

package com.wpa.projects.simulator.transactions;

import java.util.Observer;

/**
 * 
 *
 */
public class TransactionServiceProvider {

	private final TransactionService transactionService = new TransactionService();

	public TransactionServiceProvider() {

	}

	public TransactionService getTransactionService() {
		return transactionService;
	}

	public void registerListener(Observer observer) {
		transactionService.addObserver(observer);

	}

	public void unregisterListener(Observer observer) {
		transactionService.deleteObserver(observer);

	}

}
