package com.fmi.bdd;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumDriver<T extends RemoteWebDriver> extends AbstractDriverImpl {

	private T ActualWebDriver;

	public SeleniumDriver(T actualDriver) {
		ActualWebDriver = actualDriver;
	}

	@Override
	public DriverType getDriverType() {
		return DriverType.WEBDRIVER;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getDriver() {
		return ActualWebDriver;
	}

	@Override
	public void close() {
		try {
			ActualWebDriver.close();
		} catch (NoSuchSessionException snf) {
			// do nothing since the browser associated with the driver is
			// already closed
		}
	}

}
