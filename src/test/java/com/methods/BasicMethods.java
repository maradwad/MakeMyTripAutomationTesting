package com.methods;

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
		element(locator).click();
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
		element(loactor).sendKeys(string);
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
		js.executeScript("window.scrollBy(0,100)");
	}
}
