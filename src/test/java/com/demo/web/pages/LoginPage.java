package com.demo.web.pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
	
	public LoginPage(Page page) {
		super(page);
	}

	public WelcomePage loginAs(String username, String pwd){
		getPage().locator("input[name='username']").highlight();
		getPage().type("input[name='username']", username);
		getPage().locator("input[name='pwd']").highlight();
		getPage().type("input[name='pwd']", pwd);
		getPage().locator("#loginButton").highlight();
		getPage().click("#loginButton");
		/*
		for(int i=0; i<getPage().locator("//a").elementHandles().size(); i++) {
			if (!getPage().locator("//a").nth(i).textContent().trim().isBlank()){
				System.out.print(getPage().locator("//a").nth(i).getAttribute("class")+" ");
				System.out.print(getPage().locator("//a").nth(i).getAttribute("name")+" ");
				System.out.print(getPage().locator("//a").nth(i).getAttribute("id")+" ");
				System.out.print(getPage().locator("//a").nth(i).getAttribute("value")+" \n");
				getPage().locator("//a").nth(i).highlight();
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		*/
		//elements.allTextContents().stream().forEach(o->System.out.println(o));
		return new WelcomePage(getPage());	
	}
}
