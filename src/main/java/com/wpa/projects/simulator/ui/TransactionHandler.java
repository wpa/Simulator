/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 8, 2011
 */

package com.wpa.projects.simulator.ui;

import java.util.Observable;
import java.util.Observer;

/**
 * 
 *
 */
public class TransactionHandler implements Observer {

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {

		System.out.println("Transaction!!!");

	}

}
