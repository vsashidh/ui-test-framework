package com.fmi.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleMainPageObj {
	private String contentIdentifier = "heading";
	private String contentHeaderIdentifier = "";
	private String listIdentifier = "ul";

	private WebDriver driver = new ChromeDriver();

	private List<WebElement> links; // list of links lazily loaded

	public String getHeader() {
		WebElement elem = driver.findElement(By.className(contentIdentifier));
		return elem.getText();
	}

	public void clickListElement(String text, int itemNo) {
		WebElement elem = driver.findElement(By.tagName(listIdentifier));
		findElementInList(elem, text, -1).click();
	}

	/**
	 * Finds a list item in an html list
	 * @param list - list WebElement
	 * @param text - inner text to search for. To ignore finding using this parameter use null
	 * @param itemNo - list item number. To ignore finding using this parameter use -1
	 * @return - list item WebElement
	 */
	private WebElement findElementInList(WebElement list,String text,int itemNo){
		if(links == null)
			links.addAll(list.findElements(By.tagName("li")));
		if(itemNo > -1)
			return links.get(itemNo);
		else {
			for(int i=0; i<links.size(); i++){
				WebElement elem = links.get(i);
				if(elem.getText().equals(text))
					return elem;
			}
		}
	    throw new NoSuchElementException("Unable to find the requested element in the list");
	}

}
