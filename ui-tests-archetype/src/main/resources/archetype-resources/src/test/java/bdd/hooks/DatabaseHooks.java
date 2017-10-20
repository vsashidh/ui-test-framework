#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.bdd.hooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ${package}.bdd.DBConnector;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DatabaseHooks {

	public ApplicationContext ctx;

	/*@Autowired
	@Qualifier("dbConnectorMr2")
	public DBConnector conn;*/

	/*@Autowired
	@Qualifier("dbConnectorMr3")
	public DBConnector rocket_conn;*/

	@Before
	public void beforeCallingScenario() {
		
		System.out.println("*********** Resetting database");
//		conn.clean();
//      rocket_conn.clean();
		System.out.println("*********** Populating database");
//		conn.populate("seed.sql");
	}

	@After
	public void afterRunningScenario(Scenario scenario) {

		System.out.println("*********** Resetting database");
//		conn.clean();
//      rocket_conn.clean();
		System.out.println("*********** Populating database");
//		conn.populate("seed.sql");
	}

	public void beforeApiTest(){
		ctx = new ClassPathXmlApplicationContext("karate.xml");
//		conn = (DBConnector) ctx.getBean("dbConnectorMr2");
//      rocket_conn = (DBConnector) ctx.getBean("dbConnectorMr3");
		beforeCallingScenario();
	}


}
