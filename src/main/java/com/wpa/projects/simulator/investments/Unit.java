/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

package com.wpa.projects.simulator.investments;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * 
 *
 */
@XmlRootElement
@XmlSeeAlso( { UnitA.class, UnitB.class })
public abstract class Unit {

	private volatile BigDecimal price;
	final BigDecimal PERCENT_OF_COMMISSION = new BigDecimal("2");
	@SuppressWarnings("restriction")
	@XmlAttribute
	private final Fund fund;

	public Unit() {

		fund = null;

	}

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

	@XmlEnum
	public enum UnitType {
		A, B;
	}

}
