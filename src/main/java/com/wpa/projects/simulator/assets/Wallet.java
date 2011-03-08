/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 7, 2011
 */

package com.wpa.projects.simulator.assets;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import com.wpa.projects.simulator.investments.Unit;

/**
 * 
 *
 */
public class Wallet implements Salable, Purchaser {

	private Collection<Unit> tradingRegister = new ArrayList<Unit>();
	private volatile BigDecimal cash;

	/**
	 * @param bigDecimal
	 */
	public Wallet(BigDecimal initialCash) {
		this.cash = initialCash;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wpa.projects.simulator.assets.Salable#credit(java.math.BigDecimal)
	 */
	@Override
	synchronized public void credit(BigDecimal amount) {

		cash = cash.add(amount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wpa.projects.simulator.assets.Trader#getTradingRegister()
	 */
	@Override
	public Collection<Unit> getTradingRegister() {

		return tradingRegister;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wpa.projects.simulator.assets.Purchaser#liability(java.math.BigDecimal
	 * )
	 */
	@Override
	synchronized public boolean liability(BigDecimal amount) {

		if (cash.subtract(amount).compareTo(new BigDecimal("0")) > 0) {
			cash = cash.subtract(amount);
			return true;

		} else {
			return false;
		}
	}

	public BigDecimal getAvalilableCash() {
		return cash;
	}
}
