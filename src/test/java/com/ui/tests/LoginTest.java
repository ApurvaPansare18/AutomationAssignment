package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;

public class LoginTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver(); //launch a browser window
		
             //  BrowserUtility browserUtility = new BrowserUtility(driver);
		BrowserUtility browserUtility = new HomePage(driver);
               
               browserUtility.goToWebsite("https://automationpractice.techwithjatin.com/");
               browserUtility.maximizeWindow();
               
               By signInButtonLocator = By.xpath("//a[contains(text(),'Sign in')]");
               browserUtility.clickOn(signInButtonLocator);
               
               
               
               By emailIdLocator = By.xpath("//input[@id='email']");
               
               browserUtility.enterText(emailIdLocator, "apurva@gmail.com");
               
               
               
               By passwordLocator = By.xpath("//input[@id='passwd']");
               browserUtility.enterText(passwordLocator, "123");
               
               
               
               By loginButtonLocator = By.xpath("//button[@id='SubmitLogin']");
               browserUtility.clickOn(loginButtonLocator);
	}

}
