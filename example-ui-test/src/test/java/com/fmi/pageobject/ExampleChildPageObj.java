package com.fmi.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExampleChildPageObj {
	
	@FindBy(css = "h3")
	private WebElement pageHeader;
	
	private WebDriver driver;
	
	public ExampleChildPageObj(){
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
	}
	
	public String getHeader(){
		return pageHeader.getText();
	}

}
