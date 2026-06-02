package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippingPage extends BrowserUtility {
	
	private static final By TERMS_CHECKBOX_LOCATOR = By.xpath("//div[@id='uniform-cgv']");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//p[@class='cart_navigation clearfix']//button[@type='submit']");


	public ShippingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public PaymentPage chooseShippingOption()
	{
		clickOn(TERMS_CHECKBOX_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new PaymentPage(getDriver());
	}

}
