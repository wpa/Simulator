/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 8, 2011
 */

package com.wpa.projects.simulator.ui;

import java.util.Observable;
import java.util.Observer;

import com.wpa.projects.simulator.investments.Fund;

/**
 * 
 *
 */
public class RatingHandler implements Observer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {

		for (Fund fund : Fund.values()) {
			System.out.println(fund.name() + " " + fund.getUnitsPrice());
		}

	}
	
	

}
