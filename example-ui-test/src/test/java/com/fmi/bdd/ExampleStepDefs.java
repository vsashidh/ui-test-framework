package com.fmi.bdd;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.fmi.pageobject.BasePageObj;
import com.fmi.pageobject.ExampleChildPageObj;
import com.fmi.pageobject.ExampleMainPageObj;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExampleStepDefs {

	@Autowired
	private ExampleMainPageObj mainPg; // the main page

	@Autowired
	private ExampleChildPageObj childPg; // the child page
	
	@Given("^the page has a link with text '(.*)'$")
	public void the_page_has_a_link_with_text(String text) throws Throwable {
		Assert.assertTrue(mainPg.findElementInList(text));
	}

	@When("^I click on the link with text '(.*)'$")
	public void i_click_on_the_link_with_text(String text) throws Throwable {
		mainPg.clickListElement(text);
	}

	@Then("^I should see a header with '(.*)'$")
	public void i_should_see_a_header_with(String text) throws Throwable {
		String hdrText = null;
		if(childPg != null)
			hdrText = childPg.getHeader();
		else if(mainPg != null)
			hdrText= mainPg.getHeader();
		Assert.assertEquals(text, hdrText);
	}

	@Given("^the page with a header '(.*)'$")
	public void the_page_with_a_header(String text) throws Throwable {
		String hdrText = childPg.getHeader();
		Assert.assertEquals(text, hdrText);
	}

	@When("^I click the browser back button$")
	public void i_click_the_browser_back_button() throws Throwable {
		childPg.returnToPreviousPage();
	}

}
