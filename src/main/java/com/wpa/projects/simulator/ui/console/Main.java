/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

package com.wpa.projects.simulator.ui.console;

import com.wpa.projects.simulator.Simulator;
import com.wpa.projects.simulator.investments.Fund;
import com.wpa.projects.simulator.investments.Unit;
import com.wpa.projects.simulator.investments.Unit.UnitType;

/**
 * 
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Unit unit = Fund.Balanced.getUnit(UnitType.B);
		System.out.println(unit.getPrice());
		Simulator simulator = new Simulator();
		simulator.startRatings();

		int i = 0;
		while (i < 4) {
			System.out.println(unit.getPrice().toString());
			try {
				Thread.sleep(11 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}

	}

}
