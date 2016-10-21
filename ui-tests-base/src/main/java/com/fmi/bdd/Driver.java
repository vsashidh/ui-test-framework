package com.fmi.bdd;

public interface Driver {
	public enum DriverType {
		WEBDRIVER, REMOTE_WEBDRIVER
	}

	public DriverType getDriverType();

	public <T> T getDriver();

	public void close();

	public void open();
}
