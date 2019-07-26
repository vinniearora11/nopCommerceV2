package com.nopCommercev2.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommercev2.pageObjects.LoginPage;
import com.nopCommercev2.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass



{
@Test(dataProvider="LoginData")

public void loginTest(String user,String pwd) throws InterruptedException

{
	driver.get(baseURL);
	logger.info("URL is opened.....");
	LoginPage lp = new LoginPage(driver);
	lp.setUsername(user);
	logger.info("Username is provided");
	lp.setPassword(pwd);
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
     		//captureScreen(driver,"loginTest");
     		Assert.assertTrue(false);
     		logger.info("Login Failed");
     	}
}




@DataProvider(name="LoginData")
public String[][] getData() throws IOException
{
	
	
	String path = System.getProperty("user.dir")+"/src/test/java/com/nopCommercev2/testData/LoginData.xlsx";
	 int rownum = XLUtils.getRowCount(path, "Sheet1");  // gets num of rows frm excel
	 int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
	String logindata[][]=new String[rownum][colcount];   // created 2d array to store element from excel to array
	 
	 for(int i=1;i<=rownum;i++)  // here i=1 coz we skip header part of excel this i represent excel 
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);// i-1 represent index of array where daat is stored which is row count
			}
		}
		
		return logindata;
}
	
	
	
	
}


