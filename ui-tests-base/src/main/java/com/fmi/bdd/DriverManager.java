package com.fmi.bdd;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.fmi.bdd.Driver.DriverType;

//@Component
//@Scope("cucumber-glue")
public class DriverManager {
	// making the class a singleton
	// @Value("browser")
	public enum BrowserType {
		CHROME, SAFARI, IE, EDGE
	};

	private BrowserType brType = BrowserType.CHROME;
	private DriverType drType = DriverType.WEBDRIVER;
	private Driver driver;

	private DriverManager() {
		System.out.println("DriverManager has been instantiated");
	}

	public Driver getProvider() {
		if (driver == null) {
			if (drType == DriverType.WEBDRIVER) {
				switch (brType) {
				case CHROME:
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

	public void setBrType(BrowserType brType) {
		this.brType = brType;
	}

	public void setDrType(DriverType drType) {
		this.drType = drType;
	};

}
