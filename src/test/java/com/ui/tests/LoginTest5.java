package com.ui.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static com.constants.Browser.CHROME;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pojos.User;
import com.ui.pages.HomePage;

public class LoginTest5 extends TestBase {

	
	@Test(description = "Verifies if valid user is able to login",
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
			dataProvider="LoginCSVDataProvider")
	public void LoginTestUsingCSV(User user) {

		/*
		 * rules 1.test has to be small 2.conditional statements not allowed(for , if ,
		 * try catch) 3.test scripts should only follow test steps 4.reduce use of local
		 * variables 5.You should have atleast one assertion
		 */

		

		AssertJUnit.assertEquals(homePage.goToLogin().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(), "Apurva Arora");

	}

}
