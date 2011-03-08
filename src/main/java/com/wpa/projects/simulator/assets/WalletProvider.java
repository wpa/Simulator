/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 8, 2011
 */

package com.wpa.projects.simulator.assets;

import java.math.BigDecimal;
import java.util.Collection;

import com.wpa.projects.simulator.investments.Unit;
import com.wpa.projects.simulator.model.WalletUnmarshaller;

/**
 * 
 *
 */
public class WalletProvider {

	public static Wallet getWallet() {
		Wallet wallet;
		

		if (true) {
			wallet = new Wallet(new BigDecimal("1000.00"));
		} else {
			WalletUnmarshaller walletUnmarshaller = new WalletUnmarshaller();
			wallet = walletUnmarshaller.unmarshallWallet();
			Collection<Unit> marshalledUnits = wallet.getTradingRegister();
			for (Unit unit : marshalledUnits) {
				// XXX implement unmarshall
			}
		}
		
		return wallet;
	}

	public static void marshallWallet(Wallet wallet) {

	}
	
	
}
