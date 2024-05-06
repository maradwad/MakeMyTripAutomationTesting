package com.booking.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.utility.BrowserUtility;

public class HotelBookingTests extends BrowserUtility {

	
	@Test
	public static void hotelbooking() throws Exception {
		String city="Ujjain";
		String file=System.getProperty("user.dir")+"\\hotelDeatils.xlsx";
		
		hotel.closeAddFrame();
		hotel.closelogin();
		hotel.clickOnHotelLink();
		hotel.clickonCity(city);
		hotel.chooseDate();
		hotel.clickOnApply();
		hotel.clickOnSearch();
		hotel.setLowsetPrice();

	    List<WebElement> list=hotel.getListOfHotel();
	    for(int i=0;i<list.size();i++)
	    {
			excel.setCellData(file,"Sheet1",i+1,0,list.get(i).getText());

	    }
	    
//		excel.setCellData(file,"Sheet1",1,0,hotel.getHotelName());
	    List<WebElement> list1=hotel.getHotelprice();
	    for(int i=0;i<list.size();i++)
	    {
	    	excel.setCellData(file, "Sheet1",i+1, 1, list1.get(i).getText());
	    }
	}
}
