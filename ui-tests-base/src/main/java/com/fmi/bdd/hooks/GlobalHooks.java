package com.fmi.bdd.hooks;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.fmi.bdd.CloseBrowserEvent;
import com.fmi.bdd.DriverEvent;

import cucumber.api.java.Before;

public class GlobalHooks implements ApplicationEventPublisherAware{
    private static boolean dunit = false;
    private ApplicationEventPublisher publisher;
    
    @Before
    public void beforeAll() {
        if(!dunit) {
        	//Create the afterAll thread
            Runtime.getRuntime().addShutdownHook(new Thread(){

				@Override
				public void run() {
					System.out.println("<<<<< Executing after all >>>>>");
					DriverEvent closeEvent = new CloseBrowserEvent(this);
					publisher.publishEvent(closeEvent);
				}
            	
            });
            // do the beforeAll stuff...
            System.out.println("<<<<< Executing before all >>>>>");
            dunit = true;
        }
    }

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}
}
