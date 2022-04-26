package com.demo.web.tests;
import org.testng.annotations.Test;
import com.demo.tests.config.BaseTest;

public class PlaywrightTest extends BaseTest {
	@Test
	public void testPlayWrightActions() {
		launchApp().loginAs("admin","manager").logout();
	}

	
	@Test
	public void test2() {
		launchApp().loginAs("admin","manager").logout();
	}
	
	
	@Test
	public void test3() {
		launchApp().loginAs("admin","manager").logout();
	}
	
}
