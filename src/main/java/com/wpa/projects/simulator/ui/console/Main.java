/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

package com.wpa.projects.simulator.ui.console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Observer;

import com.wpa.projects.simulator.Simulator;
import com.wpa.projects.simulator.investments.Fund;
import com.wpa.projects.simulator.investments.Unit;
import com.wpa.projects.simulator.investments.Unit.UnitType;
import com.wpa.projects.simulator.ui.RatingHandler;

/**
 * 
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Unit unit = Fund.Balanced.getUnit(UnitType.B);
		Simulator simulator = new Simulator();
		RatingHandler ratingHandler = new RatingHandler();
		Collection<Observer> ratingListeners = new ArrayList<Observer>();
		ratingListeners.add(ratingHandler);
		simulator.registerRatingListeners(ratingListeners);
		simulator.startRatings();

		int i = 0;
		while (i < 4) {
//			System.out.println(unit.askPrice().toString());
//			System.out.println(unit.bidPrice().toString());
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
