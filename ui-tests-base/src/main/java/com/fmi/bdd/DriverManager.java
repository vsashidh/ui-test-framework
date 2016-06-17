package com.fmi.bdd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.fmi.bdd.Driver.DriverType;

public class DriverManager {

	public enum BrowserType {
		CHROME, SAFARI, IE, EDGE
	};

	private Driver driver;
	DriverNotifier driverNotifier;

	private DriverManager() {
		System.out.println("DriverManager has been instantiated " + this);
	}

	public Driver getProvider(DriverProperties prp) {
		if (driver == null) {
			if (prp.getDriverType() == DriverType.WEBDRIVER) {
				switch (prp.getBrowserType()) {
				case CHROME:
					System.getProperties().setProperty("webdriver.chrome.driver", prp.getChromeDriverPath());
					driver = new SeleniumDriver<ChromeDriver>(new ChromeDriver());
					break;
				case SAFARI:
					driver = new SeleniumDriver<SafariDriver>(new SafariDriver());
					break;
				default:
					driver = null;
					break;
				}

				if (driver != null) {
					((WebDriver) driver.getDriver()).manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					((WebDriver) driver.getDriver()).get(prp.getURL());
				}

			}
		}
		System.out.println("Driver has been instantiated " + driver);
		return driver;
	}

	public void destroyDriver() {
		System.out.println("<<<<< DESTROYING DRIVERMANAGER >>>>>>");
		driver = null;
		driverNotifier = null;
	}

}
