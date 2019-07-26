package com.nopCommercev2.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopCommercev2.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig objofreadconfig= new ReadConfig();
	
	 String baseURL= objofreadconfig.getApplicationURL();
	 String username= objofreadconfig.getApplicationusername();
     String password =objofreadconfig.getApplicationpassword();
	 public  static WebDriver driver;
	
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browser")
	public void setup( String bro) 
	{
		logger=Logger.getLogger("nopEcommercev2");  // this is to initiate
		PropertyConfigurator.configure("log4j.properties");
		
				if(bro.equals("chrome")) {
	                  System.setProperty("webdriver.chrome.driver",objofreadconfig.getchromepath());
	                  driver=new ChromeDriver();
				}
              
				else if(bro.equals("firefox")) {
					
					 System.setProperty("webdriver.gecko.driver",objofreadconfig.getchromepath());
	                  driver=new FirefoxDriver();
				}
				}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
	
		
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			File source = ts.getScreenshotAs(OutputType.FILE); // capture the screenshot file
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("screenshot catured");
		}
	}
	
	

	
	


