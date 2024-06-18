package com.methods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicMethods {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public BasicMethods(WebDriver driver, WebDriverWait wait, JavascriptExecutor js){
		this.driver=driver;
		this.wait=wait;
		this.js=js;
		
	}
	public WebElement element(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public boolean isdisplayed(By locator) throws InterruptedException
	{
		
		Thread.sleep(5000);
		boolean elePresent =driver.findElements(locator).size()>0;
		if(elePresent)
		{
			return true;
		}
		return false;
	}
	public void click(By locator)
	{
		 wait.until(ExpectedConditions.elementToBeClickable(element(locator))).click();
	}	
	public void SwitchtoFrame(By locator)
	{
		driver.switchTo().frame(element(locator));
	}
	public void switchtomainFrame()
	{
		driver.switchTo().defaultContent();
	}
	public void sendkeys(By loactor,String string)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(loactor)).sendKeys(string);
	}
	public void selectFromList(By locator,String string) throws InterruptedException
	{
		Thread.sleep(5000);
		List<WebElement> list=driver.findElements(locator);
		for(WebElement element : list)
		{
			if(element.getText().contains(string))
			{
				element.click();
				break;
			}
		}
	}
	public void scrollBy()
	{
		js.executeScript("window.scrollBy(0,200)");
	}
	public String getdata(By locator)
	{
		return element(locator).getText();
	}
	public String dateUtility(int day)
	{
		Date date=new Date();
		LocalDate ldate=LocalDate.now();
		int daydiff=day-date.getDay();
		if(date.getDay()<=0)
		{
			daydiff=+7;
		}
		ldate=ldate.plusDays(daydiff);
		DateTimeFormatter dateformat=DateTimeFormatter.ofPattern("E MMM dd yyyy");
		String strdate=ldate.format(dateformat);
		return strdate;		
	}
	public List<WebElement> listOfWebelement(By locator) throws Exception
	{
		Thread.sleep(6000);
		List<WebElement> list=driver.findElements(locator);
		return list;		
	}
}
