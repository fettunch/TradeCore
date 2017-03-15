package com.fafe.core.properties;

import java.util.Iterator;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ConfigLoader {

	private final String env;
	private final PropertiesConfiguration config;

	public ConfigLoader() throws ConfigurationException {

		env = System.getenv("env");
		System.out.println("found env: " + env);
		config = new PropertiesConfiguration(env + "//config.properties");

	}

	public Iterator<String> getKeys() {
		return config.getKeys();
	}

	public Object getProperty(String key) {
		return config.getProperty(key);
	}

	public String getStrProperty(String key) {
		return (String) config.getProperty(key);
	}

	public void setProperties(String key, Object value) throws ConfigurationException {
		config.setProperty(key, value);
		config.save();
	}

	public static void main(String[] args) {
		ConfigLoader cl = null;
		try {
			cl = new ConfigLoader();
			System.out.println("----------------------------");
			System.out.println("Listing composite properties");
			System.out.println("----------------------------");
			Iterator<String> keys = cl.getKeys();
			while (keys.hasNext()) {
				String key = keys.next();
				System.out.println(key + " = " + cl.getProperty(key));
			}
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}

		try {
			cl.setProperties("emailto", "test");
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}

	}
}
