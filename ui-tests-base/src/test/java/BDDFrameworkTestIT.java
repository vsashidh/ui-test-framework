

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.fmi.bdd.DriverManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bdd_config.xml")
public class BDDFrameworkTestIT {
	
	@Autowired
	public DriverManager myDriverMgr;

	@Autowired
	public DriverManager myDriver;

	@Test
	public void testDriverManger(){
		Assert.notNull(myDriverMgr);
	}
	
	@Test
	public void testDriver(){
		Assert.notNull(myDriver);
	}
	
}
