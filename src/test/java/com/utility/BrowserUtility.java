package com.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.booking.hotelBookingPage;

import io.netty.util.Timeout;

public class BrowserUtility {
	public WebDriver driver;
	WebDriverWait wait;
	public hotelBookingPage hotel;
	JavascriptExecutor js;

	@BeforeMethod
	public void chromeSetup()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		wait=new WebDriverWait(driver, 20);
		js=(JavascriptExecutor)driver;
		hotel=new hotelBookingPage(driver, wait,js);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		
	}
}
