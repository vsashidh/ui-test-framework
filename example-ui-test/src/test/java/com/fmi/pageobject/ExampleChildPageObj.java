package com.fmi.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fmi.bdd.Driver;

public class ExampleChildPageObj {
	
	@FindBy(css = "h3")
	private WebElement pageHeader;
	
	public ExampleChildPageObj(Driver drv){
		PageFactory.initElements((WebDriver)drv.getDriver(), this);
	}
	
	public String getHeader(){
		return pageHeader.getText();
	}

}
