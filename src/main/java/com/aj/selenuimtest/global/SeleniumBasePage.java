package com.aj.selenuimtest.global;

import org.openqa.selenium.support.PageFactory;


public class SeleniumBasePage extends SeleniumBaseTest {
	
	public SeleniumBasePage() {
		PageFactory.initElements(super.getWebDriver(), this);
	}

}
