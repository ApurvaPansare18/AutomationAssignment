package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {

	ExtentSparkReporter extentSparkReporter; // provide u with the functionality that helps u generate
												// html(look,styling)
	ExtentReports extentReports;// job is to do heavy lifting(data that needs to be dump)
	ExtentTest extentTest;// job is to store info about test

	Logger logger = LoggerUtility.getLogger(this.getClass());

	public void onTestStart(ITestResult result) {

		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
		// extentTest = extentReports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "PASSED");
		// extentReports.loglog(Status.PASS, result.getMethod().getMethodName()+" " +
		// "PASSED");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
		ExtentReporterUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
		
		Object testClass = result.getInstance(); //gives reference of testclass
		BrowserUtility browserUtility = ((TestBase)testClass).getInstance();
		String path = browserUtility.takeScreenshot(result.getMethod().getMethodName());
		
		ExtentReporterUtility.getTest().addScreenCaptureFromPath(path);

	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");

	}

	public void onStart(ITestContext context) {
		logger.info("Test Suited Started");
		// extentSparkReporter = new
		// ExtentSparkReporter(System.getProperty("user.dir")+"/report.html");
		// extentReports = new ExtentReports();
		// extentReports.attachReporter(extentSparkReporter);

		ExtentReporterUtility.setupSparkReporter("report.html");
	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suited Ended");
		ExtentReporterUtility.flushReport();
		// extentReports.flush();//to dump data after finish
	}
}
