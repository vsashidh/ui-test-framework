package com.fmi.bdd;

import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Created by vsashidharan on 10/1/17.
 */
@RunWith(Karate.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber", "json:target/cucumber.json" }
)
public class RunKarateTestIT {
    @BeforeClass
    public static void before(){
        Assume.assumeTrue(isAPITest());
    }

    private static boolean isAPITest() {
        if(System.getProperty("apiTest")!=null)
            return true;
        return false;
    }
}
