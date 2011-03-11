/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 8, 2011
 */

package com.wpa.projects.simulator.assets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import com.wpa.projects.simulator.investments.Fund;
import com.wpa.projects.simulator.investments.FundUnitUnmarshaller;
import com.wpa.projects.simulator.investments.Unit;
import com.wpa.projects.simulator.investments.Unit.UnitType;

/**
 * 
 *
 */
@SuppressWarnings("restriction")
public class WalletProvider {

	private static String FILENAME = "wallet.xml";
	private static BigDecimal INITIAL_WALLET_CASH = new BigDecimal("1000.00");

	public static Wallet getWallet() {
		Wallet wallet;
		File file = new File(FILENAME);

		if (file.exists()) {
			wallet = unmarshallWallet();
		} else {
			wallet = new Wallet(INITIAL_WALLET_CASH);
		}

		return wallet;
	}

	@SuppressWarnings("restriction")
	public static void marshallWallet(Wallet wallet) {

		JAXBContext context;
		OutputStream outputStream = null;
		try {
			context = getJXBContext();
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty("jaxb.formatted.output", true);
			outputStream = new FileOutputStream(FILENAME);
			marshaller.marshal(wallet, outputStream);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				// Just ignore
			}
		}

	}

	@SuppressWarnings("restriction")
	private static Wallet unmarshallWallet() {
		JAXBContext context;
		InputStream inputStream = null;
		Wallet wallet = null;

		try {
			context = getJXBContext();
			Unmarshaller unmarshaller = context.createUnmarshaller();
			inputStream = new FileInputStream(FILENAME);
			Wallet unmarshalledWallet = (Wallet) unmarshaller
					.unmarshal(inputStream);
			wallet = new Wallet(unmarshalledWallet.getAvalilableCash());

			Collection unmarshalledRegister = unmarshalledWallet
					.getTradingRegister();
			Collection<Unit> unitUnmarshalled = new ArrayList<Unit>();
			for (Object object : unmarshalledRegister) {
				ElementNSImpl elm = (ElementNSImpl) object;

				String fundName = elm.getAttribute("fund");
				String unitType = elm.getLocalName();
				unitUnmarshalled.add(FundUnitUnmarshaller.unmarshallUnit(
						fundName, unitType));
				
			}
			wallet.getTradingRegister().addAll(unitUnmarshalled);

		} catch (Exception e) {
			return new Wallet(INITIAL_WALLET_CASH);
		}

		return wallet;
	}

	@SuppressWarnings("restriction")
	private static JAXBContext getJXBContext() throws JAXBException {
		return JAXBContext.newInstance(Wallet.class, Unit.class, Fund.class,
				UnitType.class);
	}

}
