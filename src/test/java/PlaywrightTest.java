import java.awt.Color;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Locator.GetAttributeOptions;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright.CreateOptions;

public class PlaywrightTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create(); 
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
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
				Thread.sleep(3000L);
			}
		}
		//elements.allTextContents().stream().forEach(o->System.out.println(o));
		page.click("a[id='logoutLink']:right-of(:text('John Doe'))");
		System.out.println(page.title());
		page.close();
		browser.close();
		playwright.close();

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

}
