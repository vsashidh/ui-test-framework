package com.fmi.bdd;

import org.openqa.selenium.chrome.ChromeDriver;
//@Component
public class DriverManager {
	//making the class a singleton
	private Driver driver;
	public DriverManager() 
	{
		driver = null;
	};
	
	public DriverManager(String type) 
	{
		driver = new SeleniumDriver<ChromeDriver>();
	};
	
	public Driver getDriver(){
		return driver;
	}
}
