/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 10, 2011
 */

package com.wpa.projects.simulator.ui.gui.dialog;

import java.awt.Frame;

import javax.swing.JDialog;

import com.wpa.projects.simulator.assets.Wallet;
import com.wpa.projects.simulator.transactions.TransactionService;

/**
 * 
 *
 */
public class BidDialog extends JDialog {

	private static final long serialVersionUID = -6238087085486210775L;
	private final Wallet wallet;
	private final TransactionService transactionService;

	public BidDialog(Frame frame, Wallet wallet,
			TransactionService transactionService) {
		super(frame);
		this.wallet = wallet;
		this.transactionService = transactionService;
	}

}
