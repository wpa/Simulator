/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 8, 2011
 */

package com.wpa.projects.simulator.assets;

import java.math.BigDecimal;


/**
 * 
 *
 */
public interface Salable extends Trader {

	public void credit(BigDecimal amount);

}
