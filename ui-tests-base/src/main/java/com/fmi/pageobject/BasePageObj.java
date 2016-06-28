package com.fmi.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.fmi.bdd.Driver;

public abstract class BasePageObj {

	WebDriver driver;
	Boolean inView;

	public BasePageObj(Driver driver) {
		this.driver = driver.getDriver();
		PageFactory.initElements(this.driver, this);
	}

	public final void returnToPreviousPage() {
		driver.navigate().back();
	}

	public abstract void setInView();

	public final boolean isInView() {
		setInView();
		return inView;
	}
}
