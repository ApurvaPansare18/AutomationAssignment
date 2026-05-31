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
public class LoginTest6 extends TestBase{

	
	@Test(description = "Verifies if valid user is able to login",
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
			dataProvider="LoginExcelDataProvider",
			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void LoginTestUsingExcel(User user) {

		/*
		 * rules 1.test has to be small 2.conditional statements not allowed(for , if ,
		 * try catch) 3.test scripts should only follow test steps 4.reduce use of local
		 * variables 5.You should have atleast one assertion
		 */

		
//Logger logger = LoggerUtility.getLogger(this.getClass());
//logger.info("Started login test using excel");
		AssertJUnit.assertEquals(homePage.goToLogin().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Apurva Arora");
		//logger.info("login test using excel completed");
	}

}
