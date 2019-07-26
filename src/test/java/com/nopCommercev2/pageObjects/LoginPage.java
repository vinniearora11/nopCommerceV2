package com.nopCommercev2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	 public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
		
	}
	
        @FindBy(id="Email")
        @CacheLookup
        WebElement txtEmail;
        
        @FindBy(id="Password")
        @CacheLookup
        WebElement txtPassword;
        
        @FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input")
        @CacheLookup
        WebElement btnlogin;
        
        
        
        @FindBy(linkText="Logout")
        @CacheLookup
        WebElement btnlogout;
        
         public  void setUsername(String uname) 
         {
            txtEmail.sendKeys(uname);	 
        	 
         }
         public  void setPassword(String pwd) 
         {
            txtPassword.sendKeys(pwd);	 
        	 
         }
         
         public  void clickLogin() 
         {
            btnlogin.click();	 
        	 
         }
         
         public  void clickLogout() 
         {
            btnlogout.click();	 
        	 
         }
        
        
}
