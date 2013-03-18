package de.codecentric.psd.worblehat.web.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public static String getVersion() throws FileNotFoundException, IOException {
		Properties properties = new Properties();

		properties.load(new FileInputStream(
				"../resources/application.properties"));
		System.out.println("Version = "
				+ properties.getProperty("application.version"));
		return properties.getProperty("application.version");

	}

}
