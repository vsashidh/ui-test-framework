package com.fmi.bdd;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumRemoteDriver extends SeleniumDriver<RemoteWebDriver> {

	private URL hubUrl;
	private Capabilities browserCapabilities;

	public SeleniumRemoteDriver(URL hubUrl, Capabilities browserCapabilities, DriverProperties properties) {
		super(new RemoteWebDriver(hubUrl, browserCapabilities), properties);
		this.hubUrl = hubUrl;
		this.browserCapabilities = this.actualWebDriver.getCapabilities();
	}

	@Override
	public DriverType getDriverType() {
		return DriverType.REMOTE_WEBDRIVER;
	}

	@Override
	public void close(boolean shuttingDown) {
		if(shuttingDown) {
			super.close(true);
		}
	}

	@Override
	public void open() {
		if (actualWebDriver == null) {

			try {
				Constructor<?> classConstructor = actualWebDriverClass.getConstructor(URL.class, Capabilities.class);
				actualWebDriver = (RemoteWebDriver) classConstructor.newInstance(hubUrl, browserCapabilities);
			} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
					| IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			actualWebDriver.manage().timeouts().implicitlyWait(props.getTimeOutInSec(), TimeUnit.SECONDS);
		}
		actualWebDriver.get(props.getURL());
	}

}
