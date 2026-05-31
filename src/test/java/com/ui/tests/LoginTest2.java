package com.ui.tests;

import static com.constants.Browser.CHROME;

import com.ui.pages.HomePage;

public class LoginTest2 {

	public static void main(String[] args) {

		

		HomePage homePage = new HomePage(CHROME, false);
		
		
		String userName = homePage.goToLogin().doLoginWith("wolidi9525@gzeos.com", "Test@123").getUserName();
		
		System.out.println(userName);
		
		
	}

}
