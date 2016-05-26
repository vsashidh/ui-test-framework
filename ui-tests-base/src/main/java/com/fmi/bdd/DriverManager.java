package com.fmi.bdd;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.fmi.bdd.Driver.DriverType;

public class DriverManager {

	public enum BrowserType {
		CHROME, SAFARI, IE, EDGE
	};

	private Driver driver;

	private DriverManager() {
		System.out.println("DriverManager has been instantiated");
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
			}
		}
		return driver;
	}

/*	public void setBrType(BrowserType brType) {
		this.brType = brType;
	}

	public void setDrType(DriverType drType) {
		this.drType = drType;
	};*/

}
