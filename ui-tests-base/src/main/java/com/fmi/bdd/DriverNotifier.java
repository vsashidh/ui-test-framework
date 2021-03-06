package com.fmi.bdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;

public class DriverNotifier implements ApplicationListener<DriverEvent> {

	@Autowired
	Driver driver;

	@Autowired
	private ApplicationContext appContext;

	private DriverNotifier() {
		System.out.println("DriverNotifier has been instanitated " + this);
	}

	@Override
	public void onApplicationEvent(DriverEvent event) {
		System.out.println("<<<<<ACK RECEIPT OF DISPATCHED EVENT>>>>>");
		event.perform(appContext, driver);
	}

	public void destroyDriverNotifier() {
		System.out.println("<<<<< DESTROYING DRIVERNOTIFIER >>>>>>");
	}

}
