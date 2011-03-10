/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 10, 2011
 */

package com.wpa.projects.simulator.ui.gui.dialog;

import java.awt.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.wpa.projects.simulator.assets.Wallet;
import com.wpa.projects.simulator.investments.Unit;
import com.wpa.projects.simulator.transactions.TransactionService;

/**
 * 
 *
 */
public class BidDialog extends TraderDialog {

	private static final long serialVersionUID = -6238087085486210775L;

	private final Collection<Unit> unitsToSale = new ArrayList<Unit>();

	public BidDialog(Frame frame, Wallet wallet,
			TransactionService transactionService) {
		super(frame, wallet, transactionService);
		setTitle("Sprzedaj jednostki funduszu");
	}

	@Override
	protected void buildContent() {

		JLabel bidLabel = new JLabel();
		bidLabel.setText("Sprzedaj wszystkie posiadane jednostki uczestnictwa");
		JButton bidButton = new JButton("Sprzedaj");
		panel.add(bidLabel);
		panel.add(bidButton);

		bidButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// Currently only bid all units is supported
				// if (!unitsToSale.isEmpty())
				// transactionService.bid(wallet, unitsToSale);
				if (!wallet.getTradingRegister().isEmpty())
					transactionService.bid(wallet, wallet.getTradingRegister());
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent event) {

	}

}
