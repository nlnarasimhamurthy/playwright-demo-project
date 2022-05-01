package com.demo.web.tests;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import com.demo.tests.config.BaseTest;

public class PlaywrightTest extends BaseTest {
	@Test
	public void testPlayWrightActions() {
		launchApp().loginAs("admin","manager").logout();
		assertEquals(true, true);
	}

	
	@Test
	public void test2() {
		launchApp().loginAs("admin","manager").logout();
		assertEquals(true, true);
	}
	
	
	@Test
	public void test3() {
		launchApp().loginAs("admin","manager").logout();
		assertEquals(true, false);
	}
	
}
