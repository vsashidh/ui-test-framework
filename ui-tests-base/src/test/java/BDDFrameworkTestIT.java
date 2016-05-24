

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.fmi.bdd.Driver;
import com.fmi.bdd.DriverManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bdd_config.xml")
public class BDDFrameworkTestIT {
	
	@Autowired
	public DriverManager myDriverMgr;
	
	@Test
	public void testDriverManger(){
		Assert.notNull(myDriverMgr);
		Assert.notNull(myDriverMgr.getProvider());
		Assert.isTrue(myDriverMgr.getProvider().getDriverType() == Driver.DriverType.WEBDRIVER);
	}
	
	
}
