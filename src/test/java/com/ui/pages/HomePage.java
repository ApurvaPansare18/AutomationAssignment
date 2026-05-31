package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.JsonUtility;
import com.utility.PropertiesUtil;

public final class  HomePage extends BrowserUtility{
	public static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	
	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName,isHeadless);
		goToWebsite(JsonUtility.readJson(Env.QA).getUrl());
	}
	public HomePage(WebDriver driver)
	{
		super(driver);
		goToWebsite(JsonUtility.readJson(Env.QA).getUrl());
	}

	public LoginPage goToLogin()
	{
		clickOn(SIGN_IN_LOCATOR );
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	

	

}
