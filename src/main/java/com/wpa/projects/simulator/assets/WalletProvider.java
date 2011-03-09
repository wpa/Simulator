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
import java.util.Collection;

import javax.naming.spi.ObjectFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.wpa.projects.simulator.investments.Fund;
import com.wpa.projects.simulator.investments.Unit;
import com.wpa.projects.simulator.investments.Unit.UnitType;

/**
 * 
 *
 */
public class WalletProvider {

	private static String FILENAME = "wallet.xml";

	public static Wallet getWallet() {
		Wallet wallet;
		File file = new File(FILENAME);

		if (file.exists()) {
			wallet = unmarshallWallet();
			synchronizeRegisters(wallet);
		} else {
			wallet = new Wallet(new BigDecimal("1000.00"));
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

	private static void synchronizeRegisters(Trader trader) {
		Collection<Unit> marshalledUnits = trader.getTradingRegister();
		System.err.println(marshalledUnits.size());
	for (Object unit : marshalledUnits) {
			
			System.out.println(unit.getClass().getCanonicalName());
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
			wallet = (Wallet) unmarshaller.unmarshal(inputStream);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return wallet;
	}

	@SuppressWarnings("restriction")
	private static JAXBContext getJXBContext() throws JAXBException {
		return JAXBContext.newInstance(Wallet.class, Unit.class, Fund.class,
				UnitType.class);
	}

}
