package com.example.qa.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.example.qa.base.Base;





public class ExtentListener extends Base implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configReport() {
   
		htmlReporter= new ExtentSparkReporter("extentReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("Environment","QA");
		reports.setSystemInfo("UserName","Sourabh");
		reports.setSystemInfo("Oprating System", "Windows");
		reports.setSystemInfo("Host","Localhost");
		
		htmlReporter.config().setDocumentTitle("Extent Report");
		htmlReporter.config().setReportName("Extent Report Of Banking Domain");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onStart(ITestContext Result) {
		configReport();
		System.out.println("---------Test Execution Is Started------");
	}

	
	public void onFinish(ITestContext context) {
	    System.out.println("---------Test Execution Is Completed------");
	    reports.flush();
	}
	
	public void onTestStart(ITestResult result) {
       
		System.out.println("Testcase" + result.getName() + "is running");
	}
    
	public void onTestSuccess(ITestResult result) {

		System.out.println("Testcase" + result.getName() + "is Passed");
		test=reports.createTest(result.getName());
		test.log(Status.PASS,MarkupHelper.createLabel("Name of passes Testcase" +result.getName(),ExtentColor.GREEN));
	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("Testcase" + result.getName() + "is Skipped");
		test=reports.createTest(result.getName());
		test.log(Status.PASS,MarkupHelper.createLabel("Name of Skip Testcase" +result.getName(),ExtentColor.YELLOW));
	}
	
	public void onTestFailure(ITestResult result) {

		System.out.println("Testcase" + result.getName() + "is Failure");
		test=reports.createTest(result.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel("Name of fail Testcase" +result.getName(),ExtentColor.RED));
	}

}