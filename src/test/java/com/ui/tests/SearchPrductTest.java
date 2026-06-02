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
import com.ui.pages.MyAccountPage;
import com.utility.LoggerUtility;


@Listeners(com.ui.listeners.TestListener.class)
public class SearchPrductTest extends TestBase{
	
	private static final String EMAIL_ADDRESS = "wolidi9525@gzeos.com" ;
	private static final String PASSWORD = "Test@123" ;
    private MyAccountPage accountPage;
    private static final String SEARCH_TERM = "printed summer dress";
	
	@BeforeMethod
	public void setup()
	{
		accountPage = homePage.goToLogin().doLoginWith(EMAIL_ADDRESS, PASSWORD);
	}
	
	@Test(description = "Verifies if products are searched properly")
	public void searchProductTest() {

		
		String product = accountPage.searchProduct(SEARCH_TERM).searchProductTitle();
		System.out.println(product);

}
	@Test(description = "verifies list of products user is searching for")
	public void searchProductResultTest()
	{
		
		boolean actual = accountPage.searchProduct(SEARCH_TERM).isSearchTerPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actual, true);
	}
	

}
