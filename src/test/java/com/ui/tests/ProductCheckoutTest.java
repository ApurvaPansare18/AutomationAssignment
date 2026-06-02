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

import com.constants.Size;
import com.pojos.AddressPOJO;
import com.pojos.User;
import com.ui.pages.HomePage;
import com.ui.pages.MyAccountPage;
import com.utility.FakeAddressUtility;
import com.utility.LoggerUtility;


@Listeners(com.ui.listeners.TestListener.class)
public class ProductCheckoutTest extends TestBase{
	
	private static final String EMAIL_ADDRESS = "wolidi9525@gzeos.com" ;
	private static final String PASSWORD = "Test@123" ;
    private MyAccountPage accountPage;
    private static final String SEARCH_TERM = "Printed Summer Dress";
    
    private AddressPOJO address ;
	
	@BeforeMethod
	public void setup()
	{
		accountPage = homePage.goToLogin().doLoginWith(EMAIL_ADDRESS, PASSWORD);
		address = FakeAddressUtility.getFakeAddress();
	}
	
	@Test(description = "Verifies if address gets added succesfully")
	public void addProductToCart() {

		
		accountPage.searchProduct(SEARCH_TERM).clickOnProduct(0).selectSize(Size.L).addProductToCart().proceedToCheckoutFromDetailsPage().procceedToCheckoutFromSummary().confirmMyAddress().chooseShippingOption();
	

}
	
	
	

}
