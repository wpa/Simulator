package com.wpa.projects.simulator.investments;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.wpa.projects.simulator.investments.Unit.UnitType;

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
public enum Fund {

	// TODO add names of funds by properties
	Money_Market("Money_Market"), Bond("Bond"), Stable_Growth("Stable Growth"), Balanced(
			"Balanced"), Equity("Equity");

	private final String name;
	private final List<Unit> unitList = new ArrayList<Unit>();

	Fund(String name) {

		this.name = name;
	}

	public Unit getUnit(UnitType unitType) {

		switch (unitType) {
		case A:
			return getUnitA();
		case B:
			return getUnitB();
		default:
			return null;
		}

	}

	public synchronized void releaseUnit(Unit unit) {

		unitList.remove(unit);
	}

	synchronized void rateUnits(BigDecimal priceChange) {
		for (Unit unit : unitList) {

			unit.rate(priceChange);
		}

	}

	private synchronized Unit getUnitA() {
		Unit unitA = new UnitA();
		unitList.add(unitA);
		return unitA;
	}

	private synchronized Unit getUnitB() {
		Unit unitB = new UnitB();
		unitList.add(unitB);
		return unitB;
	}

}
