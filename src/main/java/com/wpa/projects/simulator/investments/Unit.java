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
public abstract class Unit {

	private volatile BigDecimal price;
	final BigDecimal PERCENT_OF_COMMISSION = new BigDecimal("2");

	Unit(BigDecimal price) {
		this.price = price;

	}

	final public BigDecimal askPrice() {
		return askCommission(price);

	}

	final public BigDecimal bidPrice() {
		return bidCommission(price);
	}

	final synchronized void rate(BigDecimal priceChange) {

		if (price.add(priceChange).intValue() > 0) {
			price = price.add(priceChange);
		}

	}

	BigDecimal percentage(BigDecimal base, BigDecimal pct) {
		return base.multiply(pct).divide(new BigDecimal(100)).setScale(2,
				BigDecimal.ROUND_HALF_UP);
	}

	abstract BigDecimal askCommission(BigDecimal price);

	abstract BigDecimal bidCommission(BigDecimal price);

	public enum UnitType {
		A, B;
	}

}
