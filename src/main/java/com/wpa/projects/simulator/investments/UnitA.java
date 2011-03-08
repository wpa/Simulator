/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

package com.wpa.projects.simulator.investments;

import java.math.BigDecimal;

/**
 * 
 *
 */
public class UnitA extends Unit {

	/**
	 * @param price
	 */
	UnitA(BigDecimal price, Fund fund) {
		super(price, fund);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.wpa.projects.simulator.investments.Unit#askCommission(java.math.
	 * BigDecimal)
	 */
	@Override
	BigDecimal askCommission(BigDecimal price) {

		return price.add(percentage(price, PERCENT_OF_COMMISSION));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.wpa.projects.simulator.investments.Unit#bidCommission(java.math.
	 * BigDecimal)
	 */
	@Override
	BigDecimal bidCommission(BigDecimal price) {
		// For type A transaction bid is free of commission.
		return price;
	}

}
