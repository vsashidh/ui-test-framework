package com.fmi.bdd;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

	public enum BrowserType {
		CHROME, SAFARI, IE, EDGE, REMOTE, FIREFOX
	};

	private Driver driver;
	DriverNotifier driverNotifier;

	private DriverManager() {
		System.out.println("DriverManager has been instantiated " + this);
	}

	public Driver getProvider(DriverProperties prp) throws MalformedURLException {
		switch (prp.getDriverType()) {
		case WEBDRIVER:
			switch (prp.getBrowserType()) {
			case CHROME:
				System.getProperties().setProperty("webdriver.chrome.driver", prp.getChromeDriverPath());
				driver = new SeleniumDriver<ChromeDriver>(new ChromeDriver(), prp);
				break;
			case SAFARI:
				driver = new SeleniumDriver<SafariDriver>(new SafariDriver(), prp);
				break;
			default:
				driver = null;
				break;
			}
			break;
		case REMOTE_WEBDRIVER:
			switch (prp.getBrowserType()) {
			case CHROME:
				driver = new SeleniumRemoteDriver(new URL(prp.getHubURL()), DesiredCapabilities.chrome(), prp);
				break;
			case FIREFOX:
				driver = new SeleniumRemoteDriver(new URL(prp.getHubURL()), DesiredCapabilities.firefox(), prp);
				break;
			default:
				driver = null;
				break;
			}
			break;
		default:
			driver = null;
			break;
		}
		return driver;
	}

	public void destroyDriver() {
		System.out.println("<<<<< DESTROYING DRIVERMANAGER >>>>>>");
		driver.close();
		driver = null;
		driverNotifier = null;
	}

}
