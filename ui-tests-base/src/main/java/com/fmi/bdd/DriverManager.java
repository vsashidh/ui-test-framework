package com.fmi.bdd;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("cucumber-glue")
public class DriverManager {
	// making the class a singleton
//	@Value("browser")
	private String type = "chrome";
	private Driver driver;

	private DriverManager(){
		System.out.println("DriverManager has been instantiated");
	}
	
	public Driver getProvider() {
		if (driver == null) {
			switch (type) {
			case "chrome":
				driver = new SeleniumDriver<ChromeDriver>(new ChromeDriver());
				break;
			default:
				driver = null;
				break;
			}
		}
		return driver;
	};
	

}
