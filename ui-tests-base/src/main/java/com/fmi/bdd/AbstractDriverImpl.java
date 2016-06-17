package com.fmi.bdd;

public abstract class AbstractDriverImpl implements Driver {

	private DriverNotifier driverNotifier;

	public void setDriverNotifier(DriverNotifier driverNotifier) {
		this.driverNotifier = driverNotifier;
	}

	public DriverNotifier getDriverNotifier() {
		return driverNotifier;
	}
}
