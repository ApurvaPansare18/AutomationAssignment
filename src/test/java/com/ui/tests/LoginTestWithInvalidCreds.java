package com.ui.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.TestNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pojos.User;
import com.ui.pages.HomePage;
import com.utility.LoggerUtility;


@Listeners(com.ui.listeners.TestListener.class)
public class LoginTestWithInvalidCreds extends TestBase{
	
	private static final String EMAIL_ADDRESS = "apurva12@gmail.com" ;
	private static final String PASSWORD = "Test788" ;

	
	@Test(description = "Verifies if proper error message is shown for Invalid credentials")
	public void LoginTestUsingInvalidCredentials() {

		/*
		 * rules 1.test has to be small 2.conditional statements not allowed(for , if ,
		 * try catch) 3.test scripts should only follow test steps 4.reduce use of local
		 * variables 5.You should have atleast one assertion
		 */

		
//Logger logger = LoggerUtility.getLogger(this.getClass());
//logger.info("Started login test using excel");
		Assert.assertEquals(homePage.goToLogin().doLoginWithInvalidCredentials(EMAIL_ADDRESS, PASSWORD).getErrorMessage(),"Authentication failed.");
		//logger.info("login test using excel completed");
	}

}
