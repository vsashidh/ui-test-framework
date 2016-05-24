package com.fmi.bdd;

import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumDriver<T extends RemoteWebDriver> implements Driver {

	private T ActualWebDriver;

	public SeleniumDriver(T actualDriver) {
		ActualWebDriver = actualDriver;
	}

	@Override
	public DriverType getDriverType() {
		return DriverType.WEBDRIVER;
	}

	public T getDriver() {
		return ActualWebDriver;
	}

}
