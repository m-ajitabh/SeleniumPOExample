package com.aj.selenuimtest.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aj.selenuimtest.global.SeleniumBaseTest;
import com.aj.selenuimtest.global.TestConstant;
import com.aj.selenuimtest.po.AmazonPage;
import com.aj.selenuimtest.po.CleartripPage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class Test1 extends SeleniumBaseTest{
	
	Map<String, String> adultData, childData;
	float flightPrice;
	
	void insertData() {
		adultData.put(TestConstant.ATITLE, "Mr");
		adultData.put(TestConstant.AFNAME, "Ravi");
		adultData.put(TestConstant.ALNAME, "Ranjan");
		adultData.put(TestConstant.ADAY, "01");
		adultData.put(TestConstant.AMONTH, "01");
		adultData.put(TestConstant.AYEAR, "1990");
		adultData.put(TestConstant.ANATIONALITY, "India");
		adultData.put(TestConstant.MOBILENUMBER, "9090909090");
		
		
		childData.put(TestConstant.CTITLE, "Mstr");
		childData.put(TestConstant.CFNAME, "Kavi");
		childData.put(TestConstant.CLNAME, "Ranjan");
		childData.put(TestConstant.CDAY, "01");
		childData.put(TestConstant.CMONTH, "01");
		childData.put(TestConstant.CYEAR, "2010");
		childData.put(TestConstant.CNATIONALITY, "India");
	}
	
	
	@Test
	public void test001() throws InterruptedException{
		test = extent.createTest("Verify to buy a book from Amazon and goto payment page");
		driver.get("http://www.cleartrip.com");
		//Thread.sleep(5000);
		CleartripPage page = new CleartripPage();
		page.clickRoundTrip();
		page.setFromCity("Bangalore");
		Thread.sleep(2000);
		page.setToCity("New Delhi");
		Thread.sleep(2000);
		page.selectDepartDate();
		Thread.sleep(2000);
		page.selectReturnDate();
		page.selectChild();
		page.clickSubmit();
		test.log(Status.INFO, MarkupHelper.createLabel("Cities, Dates selected", ExtentColor.BLUE));
		page.clickLateReturn();
		Thread.sleep(3000);
		//System.out.println(driver.getPageSource());
		page.clickBookTicket();
		
		TestConstant.flightPrice = page.getFlightPrice();
		
		System.out.println(TestConstant.flightPrice);
		
		page.checkInsuranceCheckbox();
		
		page.tavellerDetails(adultData, childData);
		
	}
	
	@Test
	public void test002()  throws InterruptedException{
		
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
		System.out.println(page.getPaperPrice());
		TestConstant.bookPrice = page.getPaperPrice();
		page.clickBuy();
		
		Thread.sleep(5000);
	    
	}

	

}
