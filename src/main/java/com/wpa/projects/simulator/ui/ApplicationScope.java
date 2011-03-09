/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 8, 2011
 */

package com.wpa.projects.simulator.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.wpa.projects.simulator.Simulator;

public class ApplicationScope {

	private final static String PROPERTY_FILE_NAME = "Simulator.properties";
	private Properties properties;

	public ApplicationScope(String[] args) {

	}

	/**
	 * @return
	 */
	public Properties getProperties() {
		initialize();
		return properties;
	}

	private void initialize() {
		try {
			File file = new File(PROPERTY_FILE_NAME);
			properties = new Properties();
			if (file.exists()) {
				loadProperties(new FileInputStream(file));
			} else {
				createProperties(new FileOutputStream(file));
			}
		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	private void createProperties(OutputStream outputStream) throws IOException {

		try {
			properties.setProperty(Simulator.class.getSimpleName() + ".useGui",
					"true");
			properties.store(outputStream, "---Initial properties---");
		} finally {

			outputStream.close();
		}

	}

	private void loadProperties(InputStream inputStream) throws IOException {
		try {
			properties.load(inputStream);
		} finally {

			inputStream.close();
		}

	}

}
