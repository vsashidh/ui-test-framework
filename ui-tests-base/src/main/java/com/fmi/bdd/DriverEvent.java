package com.fmi.bdd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public abstract class DriverEvent extends ApplicationEvent {

	public DriverEvent(Object source) {
		super(source);
	}

	public abstract void perform(ApplicationContext appContext, Driver driver);
}
