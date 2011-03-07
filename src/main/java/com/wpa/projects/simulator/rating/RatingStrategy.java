/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

package com.wpa.projects.simulator.rating;

import java.math.BigDecimal;

import com.wpa.projects.simulator.investments.Fund;

/**
 * 
 *
 */
public interface RatingStrategy {

	/**
	 * @param fund
	 * @return
	 */
	BigDecimal rate(Fund fund);

}
