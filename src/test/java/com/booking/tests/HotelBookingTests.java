package com.booking.tests;

import org.testng.annotations.Test;

import com.utility.BrowserUtility;

public class HotelBookingTests extends BrowserUtility {

	
	@Test
	public void hotelbooking() throws InterruptedException {
		String city="Ujjain";
		
		hotel.closeAddFrame();
		hotel.closelogin();
		hotel.clickOnHotelLink();
		hotel.clickonCity(city);
		hotel.chooseDate();
		hotel.clickOnApply();
	}
}
