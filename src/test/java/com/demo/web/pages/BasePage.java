package com.demo.web.pages;

import com.microsoft.playwright.Page;

public class BasePage extends AbstractBasePage {
	private Page page = null;
	public BasePage(Page page) {
		this.page = page;
	}
	public synchronized void setPage(Page page) {
		this.page = page;
	}

	public synchronized Page getPage() {
		return this.page;
	}
}
