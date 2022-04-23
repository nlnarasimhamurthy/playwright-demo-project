package com.demo.web.tests;
import org.testng.annotations.Test;
import com.demo.tests.config.BaseTest;
import com.demo.tests.config.WebApp;

public class PlaywrightTest extends BaseTest {

	//WebApp webApp = null;
	@Test
	public void testPlayWrightActions() {
		page.setViewportSize(1250,720);
		page.navigate("https://demo.actitime.com");
		page.locator("input[name='username']").highlight();
		page.type("input[name='username']", "admin");
		page.locator("input[name='pwd']").highlight();
		page.type("input[name='pwd']", "manager");
		page.locator("#loginButton").highlight();
		page.click("#loginButton");
		for(int i=0; i<page.locator("//a").elementHandles().size(); i++) {
			if (!page.locator("//a").nth(i).textContent().trim().isBlank()){
				System.out.print(page.locator("//a").nth(i).getAttribute("class")+" ");
				System.out.print(page.locator("//a").nth(i).getAttribute("name")+" ");
				System.out.print(page.locator("//a").nth(i).getAttribute("id")+" ");
				System.out.print(page.locator("//a").nth(i).getAttribute("value")+" \n");
				page.locator("//a").nth(i).highlight();
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//elements.allTextContents().stream().forEach(o->System.out.println(o));
		page.click("a[id='logoutLink']:right-of(:text('John Doe'))");
		System.out.println(page.title());

		/*
		Playwright playwright = Playwright.create();
		//Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Browser browser = playwright.chromium().launch();
		Page page = browser.newPage();
		page.navigate("https://demo.actitime.com");
		page.type("username", "admin");
		page.type("pwd", "manager");
		page.click("#loginButton");*/

	}

	
	@Test
	public void test2() {
		System.out.println("This is test 2");
	}
	
	
	@Test
	public void test3() {
		System.out.println("This is test 3");
	}
}
