package com.fmi.bdd.hooks;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.fmi.bdd.CloseBrowserEvent;
import com.fmi.bdd.DriverEvent;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ExampleHooks implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher publisher;

	@Before
	public void beforeCallingScenario() {
		System.out.println("*********** About to start the scenario.");
		/*DriverEvent openEvent = new OpenBrowserEvent(this);
		publisher.publishEvent(openEvent);*/
	}

	@After
	public void afterRunningScenario(Scenario scenario) {
		System.out.println("*********** Just finished running scenario: " + scenario.getStatus());
		DriverEvent closeEvent = new CloseBrowserEvent(this);
		publisher.publishEvent(closeEvent);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}

}
