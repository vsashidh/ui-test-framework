package com.fmi.bdd;

public interface Driver{
	public enum DriverType{
		WEBDRIVER
	}
	public DriverType getDriverType();
}
