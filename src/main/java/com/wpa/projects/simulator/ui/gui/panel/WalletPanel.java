/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 9, 2011
 */

package com.wpa.projects.simulator.ui.gui.panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.wpa.projects.simulator.assets.Wallet;
import com.wpa.projects.simulator.investments.Unit;
import com.wpa.projects.simulator.transactions.TransactionService;

/**
 * 
 *
 */
public class WalletPanel extends JPanel implements Observer {

	private final Wallet wallet;
	private JLabel cash = new JLabel();
	private JLabel assets = new JLabel();

	/**
	 * @param wallet
	 * @param transactionService
	 */
	public WalletPanel(Wallet wallet) {
		setLayout(new BorderLayout());
		this.wallet = wallet;
		Font font = new Font("Serif", Font.BOLD, 17);
		cash.setFont(font);
		assets.setFont(font);
		add(cash, BorderLayout.EAST);
		add(assets, BorderLayout.NORTH);
		updateCash();
		updateAssets();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				updateCash();
				updateAssets();
			}
		});

	}

	private void updateCash() {
		cash.setText("Dostępne środki: " + wallet.getAvalilableCash());
	}

	private void updateAssets() {
		String assetsAll = "Bieżąca wycena portfela: ";
		if (!wallet.getTradingRegister().isEmpty()) {
			BigDecimal allUnitValue = new BigDecimal("0.00");
			for (Unit unit : wallet.getTradingRegister()) {
				allUnitValue = allUnitValue.add(unit.getFund().getUnitsPrice());
			}
			assets.setText(assetsAll + allUnitValue);
		} else {
			assets.setText(assetsAll + "0.00");
		}

	}
}
