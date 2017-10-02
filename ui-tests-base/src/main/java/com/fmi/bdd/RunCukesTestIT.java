package com.fmi.bdd;

import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.lang.reflect.Field;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber", "json:target/cucumber.json" }
        )
public class RunCukesTestIT {
    @BeforeClass
    public static void before(){
        Assume.assumeTrue(isUITest());
    }

    private static boolean isUITest() {
        if(System.getProperty("apiTest")!=null)
            return false;
        return true;
    }
}