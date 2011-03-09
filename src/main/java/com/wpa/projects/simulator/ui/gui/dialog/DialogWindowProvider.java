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

public class DialogWindowProvider {

	private static final String HELP = "O_programie";
	private static final String BID = "Sprzedaj_jednostki";
	private static final String ASK = "Kup_jednostki";

	public static JDialog getDialogWindow(String command, Frame mainFrame,
			Wallet wallet, TransactionService transactionService) {

		if (command.equals(HELP))
			return new HelpDialog(mainFrame);
		else if (command.equals(ASK))
			return new AskDialog(mainFrame,wallet,transactionService);
		else if (command.equals(BID))
			return new BidDialog(mainFrame,wallet,transactionService);
		else
			return null;

	}
}
