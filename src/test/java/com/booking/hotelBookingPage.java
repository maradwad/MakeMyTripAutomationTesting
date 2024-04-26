package com.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.methods.BasicMethods;

public class hotelBookingPage extends BasicMethods{
	
	public hotelBookingPage(WebDriver driver,WebDriverWait wait, JavascriptExecutor js) {
		super(driver,wait,js);
	}
	By closeLoginPage=By.xpath("//div[@class='imageSlideContainer']//span[@class='commonModal__close']");
	By closeadd=By.xpath("//a[@id=\"webklipper-publisher-widget-container-notification-close-div\"]");
	By frame=By.xpath("//iframe[@id=\"webklipper-publisher-widget-container-notification-frame\"]");
	By hotelLink=By.xpath("//li[@class=\"menu_Hotels\"]");
	By selectCity=By.xpath("//div[@class='hsw_inputBox selectHtlCity']");
	By enterCityName=By.xpath("//input[@class=\"react-autosuggest__input react-autosuggest__input--open\"]");
	By choosecity=By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]");
	By checkInDate=By.xpath("//div[@aria-label='Fri Apr 26 2024']");
	By checkoutDate=By.xpath("//div[@aria-label=\"Sat Apr 27 2024\"]");
	By applyButton=By.xpath("//button[@class=\"primaryBtn btnApplyNew pushRight capText\"]");
	
	
	public void closeAddFrame() throws InterruptedException
	{
		if(isdisplayed(frame)) {
		SwitchtoFrame(frame);
		click(closeadd);
		switchtomainFrame();
		}
	}
	public void closelogin() throws InterruptedException
	{
		if(isdisplayed(closeLoginPage))
		{
		click(closeLoginPage);}
	}
	public void clickOnHotelLink()
	{
		click(hotelLink);
	}
	public void clickonCity(String string) throws InterruptedException
	{
		click(selectCity);
		sendkeys(enterCityName, string);
		selectFromList(choosecity, string);
	}
	public void chooseDate()
	{
		click(checkInDate);
		click(checkoutDate);
	}
	public void clickOnApply()
	{
		scrollBy();
		click(applyButton);
	}
}
