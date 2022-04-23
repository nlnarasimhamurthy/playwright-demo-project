package com.demo.test.listners;
import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		HashMap<String,String> map = new HashMap<>();
		map.put("method", "onTestStart");
		map.put("status", String.valueOf(result.getStatus()));
		map.put("name", String.valueOf(result.getName()));
		map.put("testname", String.valueOf(result.getTestName()));
		map.put("instancename", String.valueOf(result.getInstanceName()));
		System.out.println("onTestStart = " +map);
		System.out.println();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		HashMap<String,String> map = new HashMap<>();
		map.put("method", "onTestSuccess");
		map.put("status", String.valueOf(result.getStatus()));
		map.put("name", String.valueOf(result.getName()));
		map.put("testname", String.valueOf(result.getTestName()));
		map.put("instancename", String.valueOf(result.getInstanceName()));
		System.out.println("onTestSuccess = "+map);
		System.out.println();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		HashMap<String,String> map = new HashMap<>();
		map.put("method", "onTestFailure");
		map.put("status", String.valueOf(result.getStatus()));
		map.put("name", String.valueOf(result.getName()));
		map.put("testname", String.valueOf(result.getTestName()));
		map.put("instancename", String.valueOf(result.getInstanceName()));
		System.out.println("onTestFailure = "+map);
		System.out.println();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		HashMap<String,String> map = new HashMap<>();
		map.put("method", "onTestSuccess");
		map.put("status", String.valueOf(result.getStatus()));
		map.put("name", String.valueOf(result.getName()));
		map.put("testname", String.valueOf(result.getTestName()));
		map.put("instancename", String.valueOf(result.getInstanceName()));
		System.out.println("onTestSkipped = "+map);
		System.out.println();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		HashMap<String,String> map = new HashMap<>();
		map.put("method", "onTestFailedButWithinSuccessPercentage");
		map.put("status", String.valueOf(result.getStatus()));
		map.put("name", String.valueOf(result.getName()));
		map.put("testname", String.valueOf(result.getTestName()));
		map.put("instancename", String.valueOf(result.getInstanceName()));
		System.out.println("onTestFailedButWithinSuccessPercentage = "+map);
		System.out.println();
	}

	@Override
	public void onStart(ITestContext context) {
		HashMap<String,String> map = new HashMap<>();
		map.put("method", "onStart");
		map.put("name", String.valueOf(context.getName()));
		map.put("class", String.valueOf(context.getClass()));
		System.out.println("onStart = "+map);
		System.out.println();
	}

	@Override
	public void onFinish(ITestContext context) {
		HashMap<String,String> map = new HashMap<>();
		map.put("method", "onFinish");
		map.put("name", String.valueOf(context.getName()));
		map.put("class", String.valueOf(context.getClass()));
		System.out.println("onFinish = "+map);	
	}
}
