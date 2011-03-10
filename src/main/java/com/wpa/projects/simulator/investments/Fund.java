package com.wpa.projects.simulator.investments;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;

import com.wpa.projects.simulator.investments.Unit.UnitType;
import com.wpa.projects.simulator.transactions.TransactionService.Transaction;

/**
 * Copyright by 2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

/**
 * 
 *
 */
@SuppressWarnings("restriction")
@XmlRootElement
@XmlEnum
public enum Fund {

	@XmlEnumValue("Money_Market")
	Money_Market("Ryneku pieniężnego"), @XmlEnumValue("Bond")
	Bond("Obligacji"), @XmlEnumValue("Stable_Growth")
	Stable_Growth("Stabilnego wzrostu"), @XmlEnumValue("Balanced")
	Balanced("Zrównoważony"), @XmlEnumValue("Equity")
	Equity("Akcji");

	private final String name;
	private final List<Unit> unitList = new ArrayList<Unit>();
	private volatile BigDecimal price = new BigDecimal("100.00");

	Fund(String name) {

		this.name = name;
	}

	public Unit getUnit(UnitType unitType, Transaction transaction) {

		if (transaction.isTransactionActive()) {
			switch (unitType) {
			case A:
				return getUnitA();
			case B:
				return getUnitB();
			default:
				return null;
			}

		} else {
			throw new IllegalStateException("Transaction is not active");
		}
	}

	public BigDecimal getUnitsPrice() {
		return price;
	}

	public Integer getSelledUnitQuantity() {
		return unitList.size();
	}

	public synchronized void releaseUnits(Collection<Unit> units,
			Transaction transaction) {

		if (transaction.isTransactionActive()) {

			unitList.removeAll(units);
		} else {
			throw new IllegalStateException("Transaction is not active");
		}
	}

	public synchronized void releaseUnit(Unit unit, Transaction transaction) {
		if (transaction.isTransactionActive()) {

			unitList.remove(unit);
		} else {
			throw new IllegalStateException("Transaction is not active");
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}

	Unit unmarshallUnit(UnitType unitType) {

		switch (unitType) {
		case A:
			return getUnitA();
		case B:
			return getUnitB();
		default:
			return null;
		}

	}

	synchronized void rateUnits(BigDecimal priceChange) {
		for (Unit unit : unitList) {

			unit.rate(priceChange);
		}
		price = price.add(priceChange);

	}

	synchronized void unmarshallUnits(Collection<Unit> units) {
		unitList.addAll(units);

	}

	private synchronized Unit getUnitA() {
		Unit unitA = new UnitA(price, this);
		unitList.add(unitA);
		return unitA;
	}

	private synchronized Unit getUnitB() {
		Unit unitB = new UnitB(price, this);
		unitList.add(unitB);
		return unitB;
	}

}
