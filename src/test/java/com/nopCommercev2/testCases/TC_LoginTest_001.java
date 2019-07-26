package com.nopCommercev2.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopCommercev2.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	
	
	
	@Test
	public void loginTest() throws InterruptedException, IOException 
	{
		
		driver.get(baseURL);
		logger.info("URL is opened.....");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickLogin();
		logger.info("login is clicked");
		Thread.sleep(3000);
	     	if(driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			 Assert.assertTrue(true);
		lp.clickLogout();
		logger.info("Login passed");  // 
		}
	     	else {
	     		captureScreen(driver,"loginTest");
	     		Assert.assertTrue(false);
	     		logger.info("Login Failed");
	     	}
	}
	
	
}

