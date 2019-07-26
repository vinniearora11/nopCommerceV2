package com.nopCommercev2.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

// this is ia config class to read variable from congig.properties file
    
      public class ReadConfig 
      {   
	
	
	    Properties pro;  // pro is property file object
	    public ReadConfig()  // this piece of code will load the config file
	    {
	    	 
	    	File src = new File("./Configuration/config.properties");  // loading of file 
	    	// src represnting location of file
	    	try {
	    		FileInputStream fis= new FileInputStream(src);  // fileinputstream used to read data from file
	    		pro= new Properties();
	    		pro.load(fis);
	    	}  catch (Exception e) {
	    		System.out.println("Exception is" + e.getMessage());
	    	}
	    	
	    }
	
	// try catch block because if file is not present thn it comes in handy
      
	    
	    
	    public String getApplicationURL() {
	    	
	    	 String url =pro.getProperty("baseURL");
	    	 return url;
	    }
	    public String getApplicationusername() {
	    	
	    	 String usern =pro.getProperty("username");
	    	 return usern;
	    }
	    public String getApplicationpassword() {
	    	
	    	 String pwd =pro.getProperty("password");
	    	 return pwd;
	    }
	    public String getchromepath() {
	    	
	    	 String chrpath =pro.getProperty("chromepath");
	    	 return chrpath;
	    }
	    	
	    	
	    	
	    

       }
