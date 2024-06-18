package com.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.methods.BasicMethods;

public class holidayPackagePage extends BasicMethods{

	By closeLoginPage = By.xpath("//div[@class='imageSlideContainer']//span[@class='commonModal__close']");
	By closeadd = By.xpath("//a[@id=\"webklipper-publisher-widget-container-notification-close-div\"]");
	By frame = By.xpath("//iframe[@id=\"webklipper-publisher-widget-container-notification-frame\"]");
	By packagepage=By.xpath("//li[@class='menu_Holidays removeItemMargin']");
	
	public holidayPackagePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
		// TODO Auto-generated constructor stub
	}
	public void switchtoFrame() throws InterruptedException
	{
		if(isdisplayed(frame))
		{
			SwitchtoFrame(frame);
			click(closeadd);
			switchtomainFrame();
		}
	}
	public void closeloginpage() throws InterruptedException
	{
		if(isdisplayed(closeLoginPage))
		{
			click(closeLoginPage);
		}
	}
	public void clickonHolidayPackage()
	{
		click(packagepage);
	}
	
}
