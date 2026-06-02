package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pojos.AddressPOJO;
import com.utility.BrowserUtility;

public class AddMyAddressPage extends BrowserUtility {

	private final static By COMPANY_TEXTBOX_LOCATOR = By.xpath("//input[@id='company']");
	private final static By ADDRESS1_TEXTBOX_LOCATOR = By.xpath("//input[@id='address1']");

	private final static By ADDRESS2_TEXTBOX_LOCATOR = By.xpath("//input[@id='address2']");

	private final static By CITY_TEXTBOX_LOCATOR = By.xpath("//input[@id='city']");

	private final static By ZIPCODE_TEXTBOX_LOCATOR = By.xpath("//input[@id='postcode']");

	private final static By HOME_PHONE_TEXTBOX_LOCATOR = By.xpath("//input[@id='phone']");

	private final static By MOBILE_PHONE_TEXTBOX_LOCATOR = By.xpath("//input[@id='phone_mobile']");

	private final static By ADDRESS_TITLE_TEXTBOX_LOCATOR = By.xpath("//input[@id='alias']");
	private final static By ADDITIONAL_INFO_TEXTBOX_LOCATOR = By.xpath("//textarea[@id='other']");
	private final static By SAVE_ADDRESS_BUTTON_LOCATOR = By.xpath("//button[@id='submitAddress']");
	
	private final static By SAVED_ADDRESS_HEADING_LOCATOR = By.tagName("h3");

	private final static By STATE_DROPDOWN_LOCATOR = By.xpath("//select[@id='id_state']");
	
	private final static By COUNTRY_DROPDOWN_LOCATOR = By.xpath("//select[@id='id_country']");

	public AddMyAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String saveAddress(AddressPOJO address)
	{
		enterText(COMPANY_TEXTBOX_LOCATOR, address.getCompanyName());
		enterText(ADDRESS1_TEXTBOX_LOCATOR, address.getAddressLine1());
		enterText(ADDRESS2_TEXTBOX_LOCATOR, address.getAddressLine2());
		enterText(CITY_TEXTBOX_LOCATOR, address.getCity());
		enterText(ZIPCODE_TEXTBOX_LOCATOR, address.getZipCode());
		
		enterText(MOBILE_PHONE_TEXTBOX_LOCATOR, address.getMobileNumber());
		enterText(HOME_PHONE_TEXTBOX_LOCATOR, address.getHomePhoneNumber());
		clearText(ADDRESS_TITLE_TEXTBOX_LOCATOR);
		enterText(ADDRESS_TITLE_TEXTBOX_LOCATOR, address.getAddressAlias());
		enterText(ADDITIONAL_INFO_TEXTBOX_LOCATOR, address.getAdditionalInfo());
	
		selectValuesFromDropdown(STATE_DROPDOWN_LOCATOR, address.getState());
		clickOn(SAVE_ADDRESS_BUTTON_LOCATOR);
		return getVisibleText(SAVED_ADDRESS_HEADING_LOCATOR);
		
		
	}

}
