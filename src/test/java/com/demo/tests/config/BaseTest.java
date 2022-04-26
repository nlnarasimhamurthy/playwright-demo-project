package com.demo.tests.config;
import java.util.HashMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.demo.web.pages.BasePage;
import com.demo.web.pages.LoginPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest extends AbstractBaseTest {
	ThreadLocal<Page> threadLocal = new ThreadLocal<>();
	protected Page page = null;
	private Playwright playwright = null;
	private Browser browser = null;
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
		HashMap<Object, Object> driver = BrowserApp.startInstance();
		this.playwright = (Playwright) driver.get("playwright");
		this.browser = (Browser) driver.get("browser");
		this.page = (Page) driver.get("page");
		this.page.setDefaultNavigationTimeout(60000L);
		this.setPage(this.page);
		this.page.setViewportSize(1250,720);
		//BrowserApp browserApp = new BrowserApp();
	}
	@AfterClass
	public void afterClass() {
		System.out.println("@BeforeClass ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
		this.threadLocal.remove();
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

	public synchronized void setPage(Page page) {
		this.threadLocal.set(page);
	}
	
	public synchronized Page getPage() {
		return this.threadLocal.get();
	}
	
	public LoginPage launchApp() {
		this.getPage().navigate("https://demo.actitime.com");
		return new LoginPage(this.getPage());
	}
}
