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
public class AskDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2400378071968168659L;
	private final Wallet wallet;
	private final TransactionService transactionService;

	public AskDialog(Frame frame, Wallet wallet,
			TransactionService transactionService) {
		super(frame);
		this.wallet = wallet;
		this.transactionService = transactionService;
	}

}
