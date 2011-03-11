/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 8, 2011
 */

package com.wpa.projects.simulator.assets;

import java.math.BigDecimal;

/**
 * Interface for trading. Responsible for buying.
 * 
 */
public interface Purchaser extends Trader {

	public boolean liability(BigDecimal amount);

}
