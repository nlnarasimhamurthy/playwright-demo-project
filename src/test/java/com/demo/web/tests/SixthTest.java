package com.demo.web.tests;
import org.testng.annotations.Test;
import com.demo.tests.config.BaseTest;

public class SixthTest extends BaseTest {

	@Test
	public void testPlayWrightActions() {
		launchApp().loginAs("admin","manager").logout();
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
