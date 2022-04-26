package com.demo.tests.config;

import java.util.HashMap;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserApp {

	public static HashMap<Object, Object> startInstance() {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		HashMap<Object, Object> map = new HashMap<>();
		map.put("playwright", playwright);
		map.put("browser", browser);
		map.put("page", page);		
		return map;
	}
}
