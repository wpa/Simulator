/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 10, 2011
 */

package com.wpa.projects.simulator.ui.gui.dialog;


import java.awt.Frame;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;

import com.wpa.projects.simulator.assets.Wallet;
import com.wpa.projects.simulator.transactions.TransactionService;

/**
 * 
 *
 */
public abstract class TraderDialog extends JDialog implements ActionListener {

	protected final Wallet wallet;
	protected final TransactionService transactionService;
	protected JPanel panel;

	public TraderDialog(Frame frame, Wallet wallet,
			TransactionService transactionService) {
		this.wallet = wallet;
		this.transactionService = transactionService;
		setLocationRelativeTo(frame);
		setSize(500, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		panel = new JPanel();
		add(panel);
		buildContent();
	}

	protected abstract void buildContent();

}