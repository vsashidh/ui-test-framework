package com.fmi.bdd;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.fmi.pageobject.ExampleChildPageObj;
import com.fmi.pageobject.ExampleMainPageObj;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExampleStepDefs {
	
	@Autowired
	private ExampleMainPageObj mainPg; //the main page
	
	@Autowired
	private ExampleChildPageObj childPg; //the child page
	
	@Given("^the page has a link with text 'A/B Testing'$")
	public void the_page_has_a_link_with_text_A_B_Testing() throws Throwable {
		Assert.assertTrue(mainPg.findElementInList("A/B Testing"));
	}

	@When("^I click on the link with text 'A/B Testing'$")
	public void i_click_on_the_link_with_text_A_B_Testing() throws Throwable {
		Thread.sleep(1000);
		mainPg.clickListElement("A/B Testing");
	}

	@Then("^I should see a header with 'A/B Test Control'$")
	public void i_should_see_a_header_with_A_B_Test_Control() throws Throwable {
		Thread.sleep(1000);
		String hdrText = childPg.getHeader();
		Assert.assertEquals("A/B Test Control", hdrText);
	}
}
