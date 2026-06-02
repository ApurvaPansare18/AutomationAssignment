package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {
	
	private static final By USERNAME_LOCATOR = By.xpath("//a[@title='View my customer account']");
	private static final By SEARCH_BOX_LOCATOR = By.xpath("//input[@id='search_query_top']");
	private static final By ADD_ADDRESS_BUTTON_LOCATOR = By.xpath("//a[@title='Add my first address']");

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
		
		
		public String getUserName()
		{
			
			return getVisibleText(USERNAME_LOCATOR);
		}
		
		public SearchResultPage searchProduct(String productName)
		{
			enterText(SEARCH_BOX_LOCATOR, productName);
			enterSpecialKey(SEARCH_BOX_LOCATOR, Keys.ENTER);
			
			SearchResultPage  searchResultPage = new SearchResultPage(getDriver());
			return searchResultPage;
			
		}
		
		public AddMyAddressPage addAddress()
		{
			clickOn(ADD_ADDRESS_BUTTON_LOCATOR);
			AddMyAddressPage addMyAddressPage = new AddMyAddressPage(getDriver());
			return addMyAddressPage;
					
		}
	

}
