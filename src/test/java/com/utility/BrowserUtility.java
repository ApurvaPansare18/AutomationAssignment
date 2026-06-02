package com.utility;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static WebDriverWait wait;

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30l));
	}

	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30l));

		}

		else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30l));

		}

		else {
			System.err.println("enter valid browser name");
		}
	}

	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30l));

		}

		else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30l));

		}

		else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30l));

		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--windows-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30l));

			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30l));

			}
		}

		else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");

				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30l));

			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30l));

			}

		}

		else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");

				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30l));

			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30l));

			}

		}
	}

	public void goToWebsite(String url) {
		driver.get().get(url);
	}

	public void maximizeWindow() {
		driver.get().manage().window().maximize();

	}

	public void clickOn(By locator) {
		//WebElement element = driver.get().findElement(locator);
		WebElement element = 	wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void clickOn(WebElement element) {
		
		
		element.click();
	}

	public void enterText(By locator, String text) {
		//WebElement element = driver.get().findElement(locator);
		WebElement element = 	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(text);
	}
	
	public void enterSpecialKey(By locator, Keys EnterKey) {
	//	WebElement element = driver.get().findElement(locator);
		WebElement element = 	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		element.sendKeys(EnterKey);
	}
	
	public void selectValuesFromDropdown(By locator,String dropdownText)
	{
		WebElement element = driver.get().findElement(locator);
		clickOn(element);
		Select select = new Select(element);
		select.selectByValue(dropdownText);
	}
	
	public void clearText(By locator)
	{
		//WebElement element = driver.get().findElement(locator);
		WebElement element = 	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		element.clear();
	}
	

	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();

	}
	public String getVisibleText(WebElement element) {
		
		return element.getText();

	}
	
	public List<String> getAllVisibleText(By locator) {
		new WebDriverWait(driver.get(), Duration.ofSeconds(10))
	    .until(ExpectedConditions.numberOfElementsToBeMoreThan(
	            locator, 0));

		List<WebElement> elementList = driver.get().findElements(locator);
		System.out.println("Elements found = " + elementList.size());

		List<String> productNameList = new ArrayList<String>();
		for(WebElement element : elementList)
		{
			System.out.println(getVisibleText(element));
			productNameList.add(getVisibleText(element));
		}
      return productNameList;
	}
	
	public List<WebElement> getAllProductsList(By locator) {
		new WebDriverWait(driver.get(), Duration.ofSeconds(10))
	    .until(ExpectedConditions.numberOfElementsToBeMoreThan(
	            locator, 0));

		List<WebElement> elementList = driver.get().findElements(locator);
		
      return elementList;
	}
	
	
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public void quit()
	{
		driver.get().quit();
	}

	public String takeScreenshot(String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver.get();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		File screenshotData = ts.getScreenshotAs(OutputType.FILE);
		String path = "./screenshots/" + fileName + "-" + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
}
