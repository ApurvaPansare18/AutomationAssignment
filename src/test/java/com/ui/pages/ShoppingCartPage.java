package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility {
	
	private static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("(//a[@title='Proceed to checkout'])[2]");

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ConfirmMyAddressPage procceedToCheckoutFromSummary()
	{
		clickOn(PROCEED_TO_CHECKOUT_BUTTON);
		return new ConfirmMyAddressPage(getDriver());
	}
	
	
	

}
