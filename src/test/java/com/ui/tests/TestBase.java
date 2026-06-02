package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;

public class TestBase {

	protected HomePage homePage;
	private boolean isLambdaTest;

//optional is used when we try to run manually instead of testng.xml, it will pick default values which are given in @optional
	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "setup")
	public void setup(@Optional("chrome") String browser, @Optional("false") boolean isLambdaTest,
			@Optional("false") boolean isHeadless, ITestResult result) {
		

		WebDriver lambdaDriver;
		this.isLambdaTest=isLambdaTest;
		if (isLambdaTest) {
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		} else {
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod()
public void tearDown() {
	if (isLambdaTest) {
		LambdaTestUtility.quitSession();
	} else {
			homePage.quit();
		}
	}
}
