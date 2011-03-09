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
 * Interface for rating strategy
 * 
 * 
 */
public interface RatingStrategy {

	/**
	 * Rating of fund
	 * 
	 * @param fund
	 *            <code>Fund</code> type
	 * @return <code>BigDecimal</code> price change NOT CURRENT PRICE.
	 */
	BigDecimal rate(Fund fund);

}
