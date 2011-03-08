/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

package com.wpa.projects.simulator.investments;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 *
 */
@XmlRootElement
public class UnitB extends Unit {

	public UnitB() {

	}

	/**
	 * @param price
	 */
	UnitB(BigDecimal price, Fund fund) {
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
		// For type B transaction ask is free of commission.
		return price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seecom.wpa.projects.simulator.investments.Unit#bidCommission(java.math.
	 * BigDecimal)
	 */
	@Override
	BigDecimal bidCommission(BigDecimal price) {
		return price.add(percentage(price, PERCENT_OF_COMMISSION));
	}

}
