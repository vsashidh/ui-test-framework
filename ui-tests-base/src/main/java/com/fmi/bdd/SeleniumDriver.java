package com.fmi.bdd;

import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumDriver<T extends RemoteWebDriver> implements Driver{

	@Override
	public DriverType getDriverType() {
		// TODO Auto-generated method stub
		return DriverType.WEBDRIVER;
	}

}
