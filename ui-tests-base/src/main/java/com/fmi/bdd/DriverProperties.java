package com.fmi.bdd;

import org.springframework.beans.factory.annotation.Value;

import com.fmi.bdd.Driver.DriverType;
import com.fmi.bdd.DriverManager.BrowserType;

/**
 * This class will contain all the values pertaining to the Driver extracted
 * from application.properties file
 * 
 * @author vsashidharan
 *
 */
public final class DriverProperties {
	private BrowserType brType = BrowserType.CHROME;
	private DriverType drType = DriverType.WEBDRIVER;

	// WebDriver paths
	@Value("${webdriver.chrome.driver}")
	private String chromeDriverPath;
	@Value("${webdriver.ie.driver}")
	private String ieDriverPath;
	@Value("${webdriver.remote.url}")
	private String hubUrl;
	@Value("${webdriver.timeout}")
	private String timeout;

	// url
	@Value("${test.url}")
	private String testUrl;
	
	@Value("${okta.user}")
	private String oktaUser;
	
	@Value("${okta.password}")
	private String oktaPass;

	public void setBrowserType(BrowserType brType) {
		this.brType = brType;
	}

	public void setDriverType(DriverType drType) {
		this.drType = drType;
	}

	public BrowserType getBrowserType() {
		return brType;
	}

	public DriverType getDriverType() {
		return drType;
	}

	public String getChromeDriverPath() {
		chromeDriverPath = chromeDriverPath.replaceFirst("^~", System.getProperty("user.home"));
		return chromeDriverPath;
	}

	public String getIeDriverPath() {
		return ieDriverPath;
	}

	public String getURL() {
		return testUrl;
	};

	public String getHubURL() {
		return hubUrl;
	};

	public long getTimeOutInSec() {
		return Long.valueOf(timeout);
	}

	public String getOktaUser() {
		return oktaUser;
	}
	
	public String getOktaPass() {
		return oktaPass;
	}
}
