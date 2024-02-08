package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class TC001_LoginTest extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.Username(rd.Uname());
		logger.info("entered username");
		lp.Password(rd.Pw());
		logger.info("entered password");
		lp.logIn();
		logger.info("submitted login button");
		Thread.sleep(2000);
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			screenShot(driver,"TC001");	
			Assert.assertTrue(true);
			System.out.println("test case passed");
		}else {
			lp.logOut();
			logger.info("Logged Out");
			System.out.println("test case failed");	
			Assert.assertTrue(false);
		}


	}

}
