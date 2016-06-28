package com.fmi.bdd;

import org.springframework.context.ApplicationContext;

@SuppressWarnings("serial")
public class OpenBrowserEvent extends DriverEvent {

	public OpenBrowserEvent(Object source) {
		super(source);
	}

	@Override
	public void perform(ApplicationContext appContext, Driver driver) {
		System.out.println("<<<<<OPENING DRIVER>>>>>>>");
		driver.open();
	}

}
