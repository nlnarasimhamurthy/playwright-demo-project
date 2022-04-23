package com.demo.tests.config;

import com.microsoft.playwright.Page;

public class WebApp {

	Page page = null;
	public WebApp(Page page) {
		this.page = page;
	}
	
	public Page launchApp() {
		return page;	
	}
}
