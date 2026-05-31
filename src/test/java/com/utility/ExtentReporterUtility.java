package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
	
	
	// we are doing this to make the code thread safe so that we can run tests paralley , to achieve this we have used Thread local
	public static ExtentReports extentReports;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public static void setupSparkReporter(String reportName) {
		
		 ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/"+ reportName);
		 extentReports = new ExtentReports();
		 extentReports.attachReporter(extentSparkReporter);
		 }
	
	
	public static void createExtentTest(String testName)
	{
		ExtentTest test = extentReports.createTest(testName);
		extentTest.set(test);
	}
	
	public static ExtentTest getTest()
	{
		return extentTest.get();
	}
	
	public static void flushReport()
	{
		extentReports.flush();
	}

}
