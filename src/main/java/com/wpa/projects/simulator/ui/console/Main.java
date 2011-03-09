/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

package com.wpa.projects.simulator.ui.console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Observer;

import com.wpa.projects.simulator.Simulator;
import com.wpa.projects.simulator.assets.Wallet;
import com.wpa.projects.simulator.assets.WalletProvider;
import com.wpa.projects.simulator.investments.Fund;
import com.wpa.projects.simulator.investments.Unit;
import com.wpa.projects.simulator.investments.Unit.UnitType;
import com.wpa.projects.simulator.transactions.TransactionServiceProvider;
import com.wpa.projects.simulator.ui.RatingHandler;
import com.wpa.projects.simulator.ui.TransactionHandler;

/**
 * 
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Simulator simulator = new Simulator();
		RatingHandler ratingHandler = new RatingHandler();
		TransactionHandler transactionHandler = new TransactionHandler();
		Collection<Observer> ratingListeners = new ArrayList<Observer>();
		ratingListeners.add(ratingHandler);
		Collection<Observer> transactionListeners = new ArrayList<Observer>();
		transactionListeners.add(transactionHandler);

		simulator.registerRatingListeners(ratingListeners);
		simulator.registerTransactionListeners(transactionListeners);
		 simulator.startRatings();

		//Wallet wallet = WalletProvider.getWallet();
		//System.out.println(wallet.getAvalilableCash());
		//System.out.println(wallet.getTradingRegister().size());
		// WalletProvider.marshallWallet(wallet);
		//
		// simulator.getTransactionService().ask(wallet, 2, Fund.Balanced,
		// UnitType.B);
		//		
		// simulator.getTransactionService().ask(wallet, 3, Fund.Equity,
		// UnitType.A);
		//		
		// System.out.println(wallet.getTradingRegister());
		// System.out.println(wallet.getAvalilableCash());

		// Runtime.getRuntime().addShutdownHook(new Thread() {
		// public void run() { System.out.println("Shoutdown");; }
		// });

		//WalletProvider.marshallWallet(wallet);

	}

}
