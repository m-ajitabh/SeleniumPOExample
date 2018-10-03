package com.aj.selenuimtest;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import com.aj.selenuimtest.global.CustomProperties;

/**
 * Unit test for simple App.
 */
public class AppTest{
	
	//https://mft-upgrade-dev.symantec.com/cfcc/login/login.jsp
	
	
	protected static WebDriver driver;
	public static String currDirectory = new File(System.getProperty("user.dir")).getAbsolutePath();
	private static String HUB_URL;
	private static String BROWSER;
	
	public static WebDriver getWebDriver(){
		
		return driver;
	}
	
	@BeforeTest
	public static WebDriver launchWebDriver(){
		
		HUB_URL = CustomProperties.getConfigProperty("HUB_URL");
		BROWSER = CustomProperties.getConfigProperty("browser");
		String ss = CustomProperties.getConfigProperty("browser");
		if(CustomProperties.getConfigProperty("browser").equalsIgnoreCase("firefox")){
			
			driver = new FirefoxDriver();
		}else if(CustomProperties.getConfigProperty("browser").equalsIgnoreCase("chrome")){
			File file = new File(currDirectory + File.separator + "chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("test-type");

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			driver = new ChromeDriver(capabilities);
			
		}else if(CustomProperties.getConfigProperty("browser").equalsIgnoreCase("ie")){
			driver = new InternetExplorerDriver();
		}
	
		
		driver.manage().window().maximize();
		return driver;
	}

	
}
