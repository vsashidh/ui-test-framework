package com.fmi.bdd;

import java.util.EventListener;

public interface DriverEventListener extends EventListener {
	public void doAction(DriverEvent e);
}
