/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 8, 2011
 */

package com.wpa.projects.simulator.assets;

import java.util.Collection;

import com.wpa.projects.simulator.investments.Unit;

/**
 * Base interface for all trading transactions
 * 
 */
public interface Trader {

	/**
	 * 
	 */
	public abstract Collection<Unit> getTradingRegister();

}