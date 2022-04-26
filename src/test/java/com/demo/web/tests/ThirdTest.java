package com.demo.web.tests;
import org.testng.annotations.Test;
import com.demo.tests.config.BaseTest;

public class ThirdTest extends BaseTest{
	
	@Test
	public void testPlayWrightActions() {
		launchApp().loginAs("trainee","trainee").logout();
	}
}
