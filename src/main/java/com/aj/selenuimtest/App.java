package com.aj.selenuimtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");

		/*FirefoxOptions options = new FirefoxOptions();
		options.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(options);
		driver.get("http://www.google.com");*/
	}
}
