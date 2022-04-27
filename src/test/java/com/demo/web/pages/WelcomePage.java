package com.demo.web.pages;

import com.microsoft.playwright.Page;

public class WelcomePage extends BasePage {
	
	public WelcomePage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}

	public LoginPage logout() {
		try {
			getPage().locator("#closeProjectLightBoxBtn").click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		getPage().click("a[id='logoutLink']");
		System.out.println(getPage().title());
		return new LoginPage(getPage());
	}	
}
