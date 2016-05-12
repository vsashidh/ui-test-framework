package com.fmi.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.util.Assert;

public class ExampleMainPageObj {
	
	@FindBy(css = "div#content")
	private WebElement linksContainer;
	
	private WebDriver driver;

	private List<WebElement> links; // list of links lazily loaded
	
	public ExampleMainPageObj(){
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		PageFactory.initElements(driver, this);
	}

	public String getHeader() {
		WebElement elem = driver.findElement(By.className(contentIdentifier));
		return elem.getText();
	}

	public boolean findElementInList(String text) {
		WebElement elem = findElementInList(linksContainer, text, -1);
		return (elem != null);
	}
	
	public void clickListElement(String text) {
		//WebElement elem = driver.findElement(By.tagName(listIdentifier));
		WebElement elem = findElementInList(linksContainer, text, -1);
		elem.click();
	}

	/**
	 * Finds a list item in an html list
	 * @param list - list WebElement
	 * @param text - inner text to search for. To ignore finding using this parameter use null
	 * @param itemNo - list item number. To ignore finding using this parameter use -1
	 * @return - list item WebElement
	 */
	private WebElement findElementInList(WebElement list,String text,int itemNo){
		Assert.notNull(list);
		if(links == null){
			links = new ArrayList<WebElement>();
			links.addAll(list.findElements(By.tagName("li")));
		}
			
		if(itemNo > -1)
			return links.get(itemNo);
		else {
			for(int i=0; i<links.size(); i++){
				WebElement elem = links.get(i);
				if(elem.getText().equals(text))
					return elem.findElement(By.tagName("a"));
			}
		}
	    throw new NoSuchElementException("Unable to find the requested element in the list");
	}

}
