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
	private final Fund fund;

	Unit(BigDecimal price, Fund fund) {
		this.price = price;
		this.fund = fund;

	}

	final public BigDecimal askPrice() {
		return askCommission(price);

	}

	final public BigDecimal bidPrice() {
		return bidCommission(price);
	}

	public Fund getFund() {
		return fund;
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
