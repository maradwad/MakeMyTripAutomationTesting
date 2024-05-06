package com.booking;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.methods.BasicMethods;

public class hotelBookingPage extends BasicMethods {

	public hotelBookingPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait, js);
	}

	By closeLoginPage = By.xpath("//div[@class='imageSlideContainer']//span[@class='commonModal__close']");
	By closeadd = By.xpath("//a[@id=\"webklipper-publisher-widget-container-notification-close-div\"]");
	By frame = By.xpath("//iframe[@id=\"webklipper-publisher-widget-container-notification-frame\"]");
	By hotelLink = By.xpath("//li[@class=\"menu_Hotels\"]");
	By selectCity = By.xpath("//div[@class='hsw_inputBox selectHtlCity']");
	By enterCityName = By.xpath("//input[@class=\"react-autosuggest__input react-autosuggest__input--open\"]");
	By choosecity = By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]");
	By checkInDate = By.xpath("//div[@aria-label='" + dateUtility(6) + "'][@aria-disabled=\"false\"]");
	By checkoutDate = By.xpath("//div[@aria-label='" + dateUtility(7) + "'][@aria-disabled=\"false\"]");
	By applyButton = By.xpath("//button[@class=\"primaryBtn btnApplyNew pushRight capText\"]");
	By searchButton = By.xpath("//button[@id=\"hsw_search_button\"]");
	By lowestPrice = By.xpath("//ul[@class=\"srtByFltr__list\"]//li[4]");
	By hotelName = By.xpath("//span[@id=\"htl_id_seo_202304211813504587\"]");
	By hotelPrice = By.xpath("//*[@id=\"hlistpg_hotel_shown_price\"]");
	By hotelList = By.xpath("//p[@id=\"hlistpg_hotel_name\"]");

	public void closeAddFrame() throws InterruptedException {
		if (isdisplayed(frame)) {
			SwitchtoFrame(frame);
			click(closeadd);
			switchtomainFrame();
		}
	}

	public void closelogin() throws InterruptedException {
		if (isdisplayed(closeLoginPage)) {
			click(closeLoginPage);
		}
	}

	public void clickOnHotelLink() {
		click(hotelLink);
	}

	public void clickonCity(String string) throws InterruptedException {
		click(selectCity);
		sendkeys(enterCityName, string);
		selectFromList(choosecity, string);
	}

	public void chooseDate() {
		scrollBy();
		click(checkInDate);
		click(checkoutDate);
	}

	public void clickOnApply() {
//		scrollBy();
		click(applyButton);
	}

	public void clickOnSearch() {
		click(searchButton);
	}

	public void setLowsetPrice() {
		click(lowestPrice);
	}

	public String getHotelName() {
		String Name = getdata(hotelList);
		return Name;
	}

	public List<WebElement> getHotelprice() throws Exception {
		List<WebElement> list = listOfWebelement(hotelPrice);
		return list;
	}

	public List<WebElement> getListOfHotel() throws Exception {
		List<WebElement> list = listOfWebelement(hotelList);
		return list;
	}
}
