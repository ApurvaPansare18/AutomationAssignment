package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailsPage extends BrowserUtility{
	
	private static final By SIZE_DROPDOWN_LOCATOR = By.xpath("//select[@id='group_1']");
	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.xpath("//button[@name='Submit']");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//a[@title='Proceed to checkout']");

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public ProductDetailsPage selectSize(Size size)
	{
		selectValuesFromDropdown(SIZE_DROPDOWN_LOCATOR,size.getValue());
		return new ProductDetailsPage(getDriver());
	}
	
	public ProductDetailsPage addProductToCart()
	{
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailsPage(getDriver());
	}
	
	public ShoppingCartPage proceedToCheckoutFromDetailsPage()
	{
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShoppingCartPage(getDriver());
	}

}
