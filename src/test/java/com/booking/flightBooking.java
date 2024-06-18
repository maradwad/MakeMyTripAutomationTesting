package com.booking;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.dateUtility;

public class flightBooking{
	public JavascriptExecutor js;
	WebDriver driver;

	@BeforeTest
	public void chromeSetup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		System.out.println(System.getProperty("user.dir") + "\\target\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
	}

	@Test(dataProvider = "data")
	public void searchFilght(String fromCity, String toCity) throws InterruptedException {
//		 driver switch to iframe
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement frame = driver
				.findElement(By.xpath("//iframe[@id=\"webklipper-publisher-widget-container-notification-frame\"]"));
		driver.switchTo().frame(frame);
		WebElement closeframe = driver
				.findElement(By.xpath("//div[@id=\"webklipper-publisher-widget-container-notification-container\"]/a"));
		closeframe.click();
		driver.switchTo().defaultContent();
	
		driver.findElement(By.xpath("//div[@class=\"imageSlideContainer\"]//span[@class=\"commonModal__close\"]")).click();
		
		
		
		// select city for the flight search
		WebElement fromlabel = driver
				.findElement(By.xpath("//div[@class=\"flt_fsw_inputBox searchCity inactiveWidget \"]/label"));
		fromlabel.click();
		WebElement fromcity = driver.findElement(
				By.xpath("//div[@class='react-autosuggest__container react-autosuggest__container--open']/input"));
		fromcity.sendKeys(fromCity);
		Thread.sleep(3000);
		List<WebElement> list1 = driver
				.findElements(By.xpath("//p[@class=\"searchedResult font14 blackText appendBottom5\"]"));
		for (WebElement element : list1) {
			String city = element.getText();
			if (city.contains("Chennai")) {
				element.click();
				break;
			}
		}

		WebElement toLabel = driver
				.findElement(By.xpath("//div[@class=\"flt_fsw_inputBox searchToCity inactiveWidget \"]/label"));
		toLabel.click();
		WebElement tocity = driver.findElement(
				By.xpath("//div[@class=\"react-autosuggest__container react-autosuggest__container--open\"]/input"));
		tocity.sendKeys(toCity);
		Thread.sleep(3000);
		List<WebElement> list2 = driver
				.findElements(By.xpath("//p[@class='searchedResult font14 blackText appendBottom5']"));
		for (WebElement element : list2) {
			String city = element.getText();
			if (city.contains("Delhi")) {
				element.click();
				break;
			}
		}
		Thread.sleep(3000);

		// Select the departure date
		WebElement departre = driver.findElement(By.xpath("//input[@id=\"departure\"]"));
		Thread.sleep(3000);
		WebElement datepicker = driver
				.findElement(By.xpath("//div[@aria-label='" + dateUtility.getFridaydate() + "']"));

		datepicker.click();

		// Choose fare type
		WebElement fareType = driver.findElement(By.xpath("//div[@class=\"fareCardItem \"][1]"));
		fareType.click();
		

		// click on search button
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		WebElement search = driver.findElement(By.xpath("//p[@class=\"makeFlex vrtlCenter \"]/a"));
		search.click();
		
		//take screenshot and save to file
		TakesScreenshot scrshot=(TakesScreenshot)driver;
		File screenshotFile=scrshot.getScreenshotAs(OutputType.FILE);
		
		//save scrshot to specific location
		try {
			FileUtils.copyFile(screenshotFile, new File("scrn.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@DataProvider(name = "data")
	public Object[][] testdata() {
		return new Object[][] { { "Chennai", "Delhi" } };

	}

	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(11000);
//		driver.close();
	}
}
