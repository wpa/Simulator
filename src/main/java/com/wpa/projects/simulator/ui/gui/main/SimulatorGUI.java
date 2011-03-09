/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 9, 2011
 */

package com.wpa.projects.simulator.ui.gui.main;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import com.wpa.projects.simulator.Simulator;

/**
 * 
 *
 */
public class SimulatorGUI extends JFrame {

	private final Container container = getContentPane();
	private final Simulator simulator;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2202858867103395581L;

	/**
	 * @param simulator
	 */
	public SimulatorGUI(Simulator simulator) {

		this.simulator = simulator;
		setLayout(new BorderLayout());
	}

	public void addSimulatorMenuBar(JMenuBar menu) {

		setJMenuBar(menu);
	}

}
