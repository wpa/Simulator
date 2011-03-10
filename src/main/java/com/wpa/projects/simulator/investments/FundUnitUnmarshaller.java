/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 10, 2011
 */

package com.wpa.projects.simulator.investments;

import java.util.HashMap;
import java.util.Map;

import com.wpa.projects.simulator.investments.Unit.UnitType;

/**
 * 
 *
 */
public class FundUnitUnmarshaller {

	private static final Map<String, Fund> fundByName;
	private static final Map<String, UnitType> unitTypeByName;

	private FundUnitUnmarshaller() {

	}

	static {
		fundByName = new HashMap<String, Fund>();
		fundByName.put("Money_Market", Fund.Money_Market);
		fundByName.put("Bond", Fund.Bond);
		fundByName.put("Stable_Growth", Fund.Stable_Growth);
		fundByName.put("Balanced", Fund.Balanced);
		fundByName.put("Equity", Fund.Equity);

		unitTypeByName = new HashMap<String, UnitType>();
		unitTypeByName.put("unitA", UnitType.A);
		unitTypeByName.put("unitB", UnitType.B);

	}

	public static Unit unmarshallUnit(String fundName, String unitTypeName) {

		return fundByName.get(fundName).unmarshallUnit(
				unitTypeByName.get(unitTypeName));
	}
}
