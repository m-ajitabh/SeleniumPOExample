package com.aj.selenuimtest.po;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aj.selenuimtest.global.CustomWait;
import com.aj.selenuimtest.global.SeleniumBasePage;
import com.aj.selenuimtest.global.TestConstant;

public class CleartripPage extends SeleniumBasePage{
	
	@FindBy(id="RoundTrip")
	public static WebElement roundTrip;
	public void clickRoundTrip() {
		roundTrip.click();
	}
	
	@FindBy(id="FromTag")
	public static WebElement from_city;
	public void setFromCity(String to) {
		from_city.sendKeys(to);
		from_city.sendKeys(Keys.ENTER);
	}
	
	@FindBy(id="ToTag")
	public static WebElement to_city;
	public void setToCity(String to) {
		to_city.sendKeys(to);
		to_city.sendKeys(Keys.ENTER);
	}
	
	@FindBy(id="DepartDate")
	public static WebElement pickdate_popup;
	public void selectDepartDate() {
		pickdate_popup.click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
	}
	
	@FindBy(id="ReturnDate")
	public static WebElement returndate_popup;
	public void selectReturnDate() {
		returndate_popup.click();
		List<WebElement> ele = new ArrayList<WebElement>();
		ele = driver.findElements(By.xpath("//td//a"));
		ele.get(2).click();
	}

	@FindBy(id="Childrens")
	public static WebElement select_child;
	public void selectChild() {
		Select select = new Select(select_child);
		
		select.selectByValue("1");
	}
	
	@FindBy(id="SearchBtn")
	public static WebElement submit;
	public void clickSubmit() {
		submit.click();
	}
	
	@FindBy(xpath="//*[@id='sorterTpl']/ul/li[4]/a")
	public static WebElement lateReturn;
	public void clickLateReturn() {
		CustomWait.waitForWebElementElementToBeVisible(lateReturn).click();
		CustomWait.waitForWebElementElementToBeVisible(lateReturn).click();
		//CustomWait.waitForWebElementElementToBeVisible(bookTicket);
	}
				   //*[@id='flightForm']/section[2]/div[3]/div[3]/button
	@FindBy(xpath="//*[@id='flightForm']/section[2]/div[3]/div[3]/button")
	public static WebElement bookTicket;
	public void clickBookTicket() {
		WebElement ele = driver.findElement(By.xpath("html/body/section[3]/div[2]/section[2]/section/div/form/section[2]/div[3]/div[3]/button"));
		CustomWait.waitForWebElementElementToBeVisible(ele).click();
	}
	
	@FindBy(id="counter")
	public static WebElement flightPrice;
	public float getFlightPrice() {
		
		if(driver.findElement(By.id("priceChangeUpBtn")).isDisplayed()) {
			driver.findElement(By.id("priceChangeUpBtn")).click();
		}
		String price = flightPrice.getText();
		price = price.replace(",", "");
		float fp = Float.valueOf(price);
		return fp;
	}
	

	@FindBy(xpath="//*[@id=\"insurance_confirm\"]")
	public static WebElement insuranceCheckBox;
	public void checkInsuranceCheckbox() {
		insuranceCheckBox.click();
	}
	
	@FindBy(xpath="//*[@id=\"itineraryBtn\"]")
	public static WebElement continueBooking;
	public void clickContinueBooking() {
		continueBooking.click();
	}
	
	@FindBy(xpath="//*[@id=\"LoginContinueBtn_1\"]")
	public static WebElement emailContinue;
	public void clickEmailContinue() {
		emailContinue.click();
	}
	
	public void tavellerDetails(Map<String,String> adultData, Map<String,String> childData) {
		WebElement atitle = driver.findElement(By.id("AdultTitle1"));
		WebElement aFname = driver.findElement(By.id("AdultFname1"));
		WebElement aLname = driver.findElement(By.id("AdultLname1"));
		WebElement aDay = driver.findElement(By.id("AdultDobDay1"));
		WebElement aMonnth = driver.findElement(By.id("AdultDobMonth1"));
		WebElement aYear = driver.findElement(By.id("AdultDobYear1"));
		WebElement aNationality = driver.findElement(By.id("adultNationality1"));
		//Insert Adult data
		selectData(atitle, adultData.get(TestConstant.ATITLE));
		aFname.sendKeys(adultData.get(TestConstant.AFNAME));
		aLname.sendKeys(adultData.get(TestConstant.ALNAME));
		selectData(aDay, adultData.get(TestConstant.ADAY));
		selectData(aMonnth, adultData.get(TestConstant.AMONTH));
		selectData(aYear, adultData.get(TestConstant.AYEAR));
		aNationality.sendKeys(adultData.get(TestConstant.ANATIONALITY));

		// Child Weblelment
		
		WebElement ctitle = driver.findElement(By.id("ChildTitle1"));
		WebElement cFname = driver.findElement(By.id("ChildFname1"));
		WebElement cLname = driver.findElement(By.id("ChildLname1"));
		WebElement cDay = driver.findElement(By.id("ChildDobDay1"));
		WebElement cMonnth = driver.findElement(By.id("ChildDobMonth1"));
		WebElement cYear = driver.findElement(By.id("ChildDobYear1"));
		
		
		// Insert Child Data
		
		selectData(ctitle, childData.get(TestConstant.ATITLE));
		cFname.sendKeys(childData.get(TestConstant.AFNAME));
		cLname.sendKeys(childData.get(TestConstant.ALNAME));
		selectData(cDay, childData.get(TestConstant.ADAY));
		selectData(cMonnth, childData.get(TestConstant.AMONTH));
		selectData(cYear, childData.get(TestConstant.AYEAR)); 
		
		WebElement mobileNumber = driver.findElement(By.id("mobileNumber"));
		WebElement continueButton = driver.findElement(By.id("travellerBtn"));
		mobileNumber.sendKeys(TestConstant.MOBILENUMBER);
		continueButton.click();
		
	}
	
	public void selectData(WebElement ele, String value) {
		Select select = new Select(ele);
		
		select.selectByValue(value);
	}
	
}
