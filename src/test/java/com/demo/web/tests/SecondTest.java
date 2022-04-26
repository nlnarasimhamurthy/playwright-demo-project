package com.demo.web.tests;
import org.testng.annotations.Test;
import com.demo.tests.config.BaseTest;
import com.demo.web.pages.WelcomePage;

public class SecondTest extends BaseTest{
	WelcomePage welcomePage = null;
	@Test
	public void testPlayWrightActions() {
		welcomePage = launchApp().loginAs("trainee","trainee");
		welcomePage.logout();
	}
}
