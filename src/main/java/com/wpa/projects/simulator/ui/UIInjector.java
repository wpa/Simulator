/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 9, 2011
 */

package com.wpa.projects.simulator.ui;

import java.util.Properties;

public class UIInjector {
	public static SimulatorUIMainHelper injectSimulatorUIMainHelper(
			ApplicationScope applicationScope) {
		return new SimulatorUIMainHelper(injectProperties(applicationScope));
	}

	private static Properties injectProperties(ApplicationScope applicationScope) {

		return applicationScope.getProperties();
	}

}
