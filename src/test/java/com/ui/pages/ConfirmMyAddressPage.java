package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ConfirmMyAddressPage extends BrowserUtility {
	
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//p[@class='cart_navigation clearfix']//button[@type='submit']");

	public ConfirmMyAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ShippingPage confirmMyAddress()
	{
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShippingPage(getDriver());
	}

}
