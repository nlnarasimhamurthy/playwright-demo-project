package com.demo.tests.config;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest extends AbstractBaseTest {
	//protected WebApp webApp = null;
	protected Page page = null;
	Browser browser = null;
	Playwright playwright = null;
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite ###########################################\n");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite  ###########################################\n");
		
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");		
		this.playwright = Playwright.create();
		this.browser = this.playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		this.page = this.browser.newPage();
		//new WebApp(this.page);
	}
	@AfterClass
	public void afterClass() {
		System.out.println("@BeforeClass ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
		this.page.close();
		this.browser.close();
		this.playwright.close();
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod ------------------------------------------------\n\n");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod ------------------------------------------------\n\n");
	}
}
