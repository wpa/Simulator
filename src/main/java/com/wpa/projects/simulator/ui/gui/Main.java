/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

package com.wpa.projects.simulator.ui.gui;

import com.wpa.projects.simulator.Simulator;
import com.wpa.projects.simulator.ui.gui.main.SimulatorFrame;
import com.wpa.projects.simulator.ui.gui.utils.SimulatorSwing;

/**
 * 
 *
 */
public class Main {


	public static void main(String[] args) {
		Simulator simulator = new Simulator();
		SimulatorFrame mainFrame = new SimulatorFrame(simulator);
		SimulatorSwing.run(mainFrame, 400, 400);

	}

}
