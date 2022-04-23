import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SecondTest extends BaseTest{
	
	@Test
	public void testPlayWrightActions() {
		page.setViewportSize(1250,720);
		page.navigate("https://demo.actitime.com");
		page.locator("input[name='username']").highlight();
		page.type("input[name='username']", "trainee");
		page.locator("input[name='pwd']").highlight();
		page.type("input[name='pwd']", "trainee");
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
					Thread.sleep(3000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//elements.allTextContents().stream().forEach(o->System.out.println(o));
		page.click("a[id='logoutLink']");
		System.out.println(page.title());
	}
}
