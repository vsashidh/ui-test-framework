package com.fmi.pageobject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.fmi.bdd.Driver;

public class ExampleChildPageObj extends BasePageObj {

	@FindBy(css = "h3")
	private WebElement pageHeader;

	public ExampleChildPageObj(Driver drv) {
		super(drv);
	}

	public String getHeader() {
		return pageHeader.getText();
	}

	@Override
	public void setInView() {
		try {
			inView = (pageHeader.isDisplayed());
		} catch (NoSuchElementException nse) {
			inView = false;
		}
	}

}
