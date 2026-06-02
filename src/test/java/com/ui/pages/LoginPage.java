package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {
    private static final By EMAIL_ID_LOCATOR = By.xpath("//input[@id='email']");
    private static final By PASSWORD_LOCATOR = By.xpath("//input[@id='passwd']");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//button[@id='SubmitLogin']");
    private static final By ERROR_MSG_LOCATOR = By.xpath("//div[contains(@class,\"alert-danger\")]/ol/li");
	
	

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	
	public MyAccountPage doLoginWith(String emailId,String password)
	{
		enterText(EMAIL_ID_LOCATOR,emailId);
		enterText(PASSWORD_LOCATOR,password);
		clickOn(LOGIN_BUTTON_LOCATOR);
		
		MyAccountPage myAcccountPage = new MyAccountPage(getDriver());
		return myAcccountPage;
		
	}
	
	public LoginPage doLoginWithInvalidCredentials(String emailId,String password)
	{
		enterText(EMAIL_ID_LOCATOR,emailId);
		enterText(PASSWORD_LOCATOR,password);
		clickOn(LOGIN_BUTTON_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	public String getErrorMessage()
	{
		return getVisibleText(ERROR_MSG_LOCATOR);
	}
}
