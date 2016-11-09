package com.fmi.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

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

	public void waitForCondition(ExpectedCondition<Boolean> expectedCondition, int pollTime, int timeOut) {
		/*Waits for some time before until the condition is met*/
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).pollingEvery(pollTime, TimeUnit.MILLISECONDS)
				.withTimeout(timeOut, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

		wait.until(expectedCondition);
	}
	
	public WebElement getElemAfterMeetingCondition(ExpectedCondition<WebElement> condition, int pollTime, int timeOut) {
		/*Returns an element after the condition is met*/
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).pollingEvery(pollTime, TimeUnit.MILLISECONDS)
 				.withTimeout(timeOut, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
 
 		return wait.until(condition);
 
 	}
}
