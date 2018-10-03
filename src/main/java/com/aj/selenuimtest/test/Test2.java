/*package com.aj.selenuimtest.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.aj.selenuimtest.global.CustomWait;
import com.aj.selenuimtest.global.SeleniumBaseTest;
import com.aj.selenuimtest.po.AmazonPage;

public class Test2 extends SeleniumBaseTest{
	
	@BeforeSuite
	void setUrl() {
		getWebDriver();
	}
	
	@Test
	public void test001()  throws InterruptedException{
		
		String bookName = "A Brief History of Everyone Who Ever Lived";
		driver.navigate().to("https://www.amazon.in");
		AmazonPage page = new AmazonPage();
		page.setSearch(bookName);
		page.clickSelectBook();
		//CustomWait.waitForWebElementElementToBeVisible(page.paperPrice);
		Set <String> handles =driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		String parent = it.next();
		String child = it.next();

		driver.switchTo().window(child);
		System.out.println(page.paperPrice.getText());
		page.clickBuy();
		
		Thread.sleep(5000);
	    
	    
		
		
	
	}
	
}
*/