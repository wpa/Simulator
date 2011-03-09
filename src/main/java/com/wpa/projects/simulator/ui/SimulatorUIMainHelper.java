/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 9, 2011
 */

package com.wpa.projects.simulator.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import com.wpa.projects.simulator.Simulator;
import com.wpa.projects.simulator.assets.Wallet;
import com.wpa.projects.simulator.assets.WalletProvider;
import com.wpa.projects.simulator.transactions.TransactionService;
import com.wpa.projects.simulator.transactions.TransactionServiceProvider;
import com.wpa.projects.simulator.ui.console.SimulatorCLI;
import com.wpa.projects.simulator.ui.gui.main.SimulatorGUI;
import com.wpa.projects.simulator.ui.gui.menu.SimulatorMenu;
import com.wpa.projects.simulator.ui.gui.menu.SimulatorMenuBuilder;
import com.wpa.projects.simulator.ui.gui.panel.RatingPanel;
import com.wpa.projects.simulator.ui.gui.panel.WalletPanel;
import com.wpa.projects.simulator.ui.gui.utils.SimulatorSwing;

public class SimulatorUIMainHelper {

	private final Properties properties;

	public SimulatorUIMainHelper(Properties properties) {
		this.properties = properties;
	}

	public void run() {

		Simulator simulator = new Simulator();
		Wallet wallet = WalletProvider.getWallet();

		if (Boolean.parseBoolean(properties.getProperty(simulator.getClass()
				.getSimpleName()
				+ ".useGui"))) {
			startGUI(simulator, wallet);
		} else {
			startCLI(simulator, wallet);
		}

	}

	private void startGUI(Simulator simulator, Wallet wallet) {

		SimulatorGUI mainFrame = new SimulatorGUI(simulator);

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("asd");

			}
		};
		SimulatorMenu menu = new SimulatorMenu(actionListener);

		SimulatorMenuBuilder menuBuilder = new SimulatorMenuBuilder(menu
				.getMenuList());
		mainFrame.addSimulatorMenuBar(menuBuilder.build());

		RatingPanel ratingPanel = new RatingPanel();
		WalletPanel walletPanel = new WalletPanel(wallet);

		simulator.registerRatingListener(ratingPanel);
		simulator.registerTransactionListener(walletPanel);

		mainFrame.add(ratingPanel, BorderLayout.EAST);
		mainFrame.add(walletPanel, BorderLayout.CENTER);

		SimulatorSwing.run(mainFrame, -1, -1);
		simulator.startRatings();
	}

	private void startCLI(Simulator simulator, Wallet wallet) {
		SimulatorCLI cli = new SimulatorCLI(simulator);

	}
}
