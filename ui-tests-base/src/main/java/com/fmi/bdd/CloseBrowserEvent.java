package com.fmi.bdd;

import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("serial")
public class CloseBrowserEvent extends DriverEvent {

	public CloseBrowserEvent(Object source) {
		super(source);
	}

	@Override
	public void perform(ApplicationContext appContext, Driver driver) {
		System.out.println("<<<<<CLOSING BROWSER>>>>>>>");
		((WebDriver) driver.getDriver()).quit();
		((ClassPathXmlApplicationContext)appContext).close();

	}

}
