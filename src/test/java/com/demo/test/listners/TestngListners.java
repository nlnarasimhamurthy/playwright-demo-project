package com.demo.test.listners;
import java.nio.file.Paths;
import java.util.HashMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import com.demo.tests.config.BaseTest;
import com.microsoft.playwright.Page.ScreenshotOptions;

public class TestngListners extends BaseTest implements ITestListener {
    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }
    
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
    	HashMap<String,String> map = new HashMap<>();
		map.put("method", "onStart");
		map.put("name",  String.valueOf(context.getName()));
		map.put("class", String.valueOf(context.getClass()));
		System.out.println("onStart = "+map);
		System.out.println();
        //Log.info("I am in onStart method " + context.getName());
        context.setAttribute("Page", getPage());
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		HashMap<String,String> map = new HashMap<>();
		map.put("method", "onFinish");
		map.put("name", String.valueOf(context.getName()));
		map.put("class", String.valueOf(context.getClass()));
		System.out.println("onFinish = "+map);	
        //Log.info("I am in onFinish method " + context.getName());
        //Do tier down operations for ExtentReports reporting!
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
		HashMap<String,String> map = new HashMap<>();
		map.put("method", "onTestStart");
		map.put("status", String.valueOf(result.getStatus()));
		map.put("name", String.valueOf(result.getName()));
		map.put("testname", String.valueOf(result.getTestName()));
		map.put("instancename", String.valueOf(result.getInstanceName()));
		System.out.println("onTestStart = " +map);
		System.out.println();
        //Log.info(getTestMethodName(result) + " test is starting.");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		HashMap<String,String> map = new HashMap<>();
		map.put("method", "onTestSuccess");
		map.put("status", String.valueOf(result.getStatus()));
		map.put("name", String.valueOf(result.getName()));
		map.put("testname", String.valueOf(result.getTestName()));
		map.put("instancename", String.valueOf(result.getInstanceName()));
		System.out.println("onTestSuccess = "+map);
		System.out.println();
        //Log.info(getTestMethodName(result) + " test is succeed.");
        //ExtentReports log operation for passed tests.

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		HashMap<String,String> map = new HashMap<>();
		map.put("method", "onTestFailure");
		map.put("status", String.valueOf(result.getStatus()));
		map.put("name", String.valueOf(result.getName()));
		map.put("testname", String.valueOf(result.getTestName()));
		map.put("instancename", String.valueOf(result.getInstanceName()));
		System.out.println("onTestFailure = "+map);
		System.out.println();
        //Log.info(getTestMethodName(result) + " test is failed.");
        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = result.getInstance();
        //Take base64Screenshot screenshot for extent reports
        //this.page.screenshot(new ScreenshotOptions().setPath(Paths.get("screenshot.png")).setFullPage(false));
        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		HashMap<String,String> map = new HashMap<>();
		map.put("method", "onTestSuccess");
		map.put("status", String.valueOf(result.getStatus()));
		map.put("name", String.valueOf(result.getName()));
		map.put("testname", String.valueOf(result.getTestName()));
		map.put("instancename", String.valueOf(result.getInstanceName()));
		System.out.println("onTestSkipped = "+map);
		System.out.println();
	    //Log.info(getTestMethodName(result) + " test is skipped.");
        //ExtentReports log operation for skipped tests.
        ///getTest().log(Status.SKIP, "Test Skipped");

		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		HashMap<String,String> map = new HashMap<>();
		map.put("method", "onTestFailedButWithinSuccessPercentage");
		map.put("status", String.valueOf(result.getStatus()));
		map.put("name", String.valueOf(result.getName()));
		map.put("testname", String.valueOf(result.getTestName()));
		map.put("instancename", String.valueOf(result.getInstanceName()));
		System.out.println("onTestFailedButWithinSuccessPercentage = "+map);
		System.out.println();
		
        //Log.info("Test failed but it is in defined success ratio " + getTestMethodName(result));

		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}
}
