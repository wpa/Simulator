/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 8, 2011
 */

package com.wpa.projects.simulator.transactions;

/**
 * 
 *
 */
public class TransactionServiceProvider {

	private final TransactionService transactionService = new TransactionService();

	private TransactionServiceProvider() {

	}

	public TransactionService getTransactionService() {
		return transactionService;
	}

}
