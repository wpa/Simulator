/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 9, 2011
 */

package com.wpa.projects.simulator.ui.gui.panel;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import com.wpa.projects.simulator.assets.Wallet;
import com.wpa.projects.simulator.transactions.TransactionService;

/**
 * 
 *
 */
public class WalletPanel extends JPanel implements Observer {

	private final Wallet wallet;

	/**
	 * @param wallet
	 * @param transactionService
	 */
	public WalletPanel(Wallet wallet) {
		this.wallet = wallet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
