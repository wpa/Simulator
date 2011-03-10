/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 10, 2011
 */

package com.wpa.projects.simulator.ui.gui.dialog;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import com.wpa.projects.simulator.assets.Wallet;
import com.wpa.projects.simulator.investments.Fund;
import com.wpa.projects.simulator.transactions.TransactionService;

/**
 * 
 *
 */
public class BidDialog extends TraderDialog {

	private static final long serialVersionUID = -6238087085486210775L;

	public BidDialog(Frame frame, Wallet wallet,
			TransactionService transactionService) {
		super(frame, wallet, transactionService);
		setTitle("Sprzedaj jednostki funduszu");
	}

	@Override
	protected void buildContent() {

	}

	@Override
	public void actionPerformed(ActionEvent event) {

	}

}
