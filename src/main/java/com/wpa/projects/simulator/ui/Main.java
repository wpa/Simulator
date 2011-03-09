/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 9, 2011
 */

package com.wpa.projects.simulator.ui;

/**
 * 
 *
 */
public class Main {

	public static void main(String[] args) {
		ApplicationScope scope = new ApplicationScope(args);
		SimulatorUIMainHelper helper = UIInjector.injectSimulatorUIMainHelper(scope);
		helper.run();

	}

}
