package com.fmi.bdd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumDriver<T extends RemoteWebDriver> extends AbstractDriverImpl {

	private T actualWebDriver;
	private Class<?> actualWebDriverClass;
	private String url;

	public SeleniumDriver(T actualDriver, String url) {
		actualWebDriver = actualDriver;
		actualWebDriverClass = actualDriver.getClass();
		this.url = url;
	}

	@Override
	public DriverType getDriverType() {
		return DriverType.WEBDRIVER;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getDriver() {
		return actualWebDriver;
	}

	@Override
	public void close() {
		try {
			actualWebDriver.quit();
			actualWebDriver = null;
		} catch (NoSuchSessionException snf) {
			// do nothing since the browser associated with the driver is
			// already closed
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void open() {
		if (actualWebDriver == null) {

			try {
				actualWebDriver = (T) actualWebDriverClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		actualWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actualWebDriver.get(url);
	}

}
