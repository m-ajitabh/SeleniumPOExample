package com.aj.selenuimtest.po;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;

import com.aj.selenuimtest.global.CustomWait;
import com.aj.selenuimtest.global.SeleniumBasePage;

public class AmazonPage extends SeleniumBasePage {

	@FindBy(id = "twotabsearchtextbox")
	public static WebElement searchBox;
	public void setSearch(String search) {
		CustomWait.waitForWebElementElementToBeVisible(searchBox).sendKeys(search);
		searchBox.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//h2[@data-attribute='A Brief History of Everyone Who Ever Lived']")
	public static WebElement selectBook;
	public void clickSelectBook() {
		CustomWait.waitForWebElementElementToBeVisible(selectBook).click();
	}

	@FindBy(xpath = "//*[@id='a-autoid-6-announce']/span[2]/span")
	public static WebElement paperPrice;
	public float getPaperPrice() {
		return Float.valueOf(paperPrice.getText());
	}
	
	@FindBy(id = "buy-now-button")
	public static WebElement paperbackBuy;
	public void clickBuy() {
		paperbackBuy.click();
	}
}
