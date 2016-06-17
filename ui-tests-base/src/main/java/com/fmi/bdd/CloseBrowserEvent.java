package com.fmi.bdd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@SuppressWarnings("serial")
public class CloseBrowserEvent extends DriverEvent {

	public CloseBrowserEvent(Object source) {
		super(source);
	}

	@Override
	public void perform(ApplicationContext appContext, Driver driver) {
		System.out.println("<<<<<CLOSING DRIVER>>>>>>>");
		driver.close();
		((AbstractApplicationContext)appContext).close();
	}

}
