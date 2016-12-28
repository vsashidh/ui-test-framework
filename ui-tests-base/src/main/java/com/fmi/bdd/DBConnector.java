package com.fmi.bdd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.DB;
import org.javalite.activejdbc.Model;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Used by test projects to connect to a database(or schema) and corresponding tables 
 * 
 * == Example of a spring dbconnector bean ==
 * 
 *  	<bean id="dbConnectorMr2" class="com.fmi.bdd.DBConnector" destroy-method="close"
 *		scope="cucumber-glue">
 *		<constructor-arg index="0" value="default"/>
 *		<constructor-arg index="1" value="oracle.jdbc.OracleDriver"/>
 *		<constructor-arg index="2" value="jdbc:oracle:thin:@localhost:1521:xe"/>
 *		<constructor-arg index="3" value="MR2"/>
 *		<constructor-arg index="4" value="fmi"/>
 *		<constructor-arg index="5">
 *			<list>
 *				<value type="java.lang.Class">com.fmi.support.db.DomainEvent</value>
 *				<value type="java.lang.Class">com.fmi.support.db.Snapshots</value>
 *			</list>
 *		</constructor-arg>
 *	</bean>
 *  
 * @author vsashidharan
 *
 * @param <T> 
 */
public class DBConnector<T extends Model> {

	private List<T> entities;
	private DB conn;

	public DBConnector(String logicalName, String driver, String url, String user, String pwd,
			List<Class<T>> entityClasses) {
		System.setProperty("active_env", "test"); // for activejdbc
		conn = new DB(logicalName);
		conn.open(driver, url, user, pwd);
		try {
			this.entities = new ArrayList<T>();

			for (Class<T> entityClass : entityClasses)
				this.entities.add(entityClass.newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close() {
		conn.close();
	}

	public int populate(String file) {
		conn.openTransaction();
		int count = 0;
		Resource resource = new ClassPathResource(file);
		StringBuilder sql = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.trim().isEmpty()) {
					if (line.endsWith(";")) {
						line = line.replaceAll(";$", "");
						sql.append(line);
						String mama = sql.toString();
						count = conn.exec(mama);
						sql = new StringBuilder();
					} else {
						sql.append(line);
					}

				}
			}
			conn.commitTransaction();
		} catch (IOException e) {
			conn.rollbackTransaction();
			return 0;
		}
		return count;
	}

	public void clean() {
		try {
			for (T entity : entities) {
				entity.getClass().getMethod("deleteAll").invoke(null, new Object[] {});
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
