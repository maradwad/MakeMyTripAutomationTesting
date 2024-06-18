package com.booking.tests;

import org.testng.annotations.Test;

import com.utility.BrowserUtility;

public class holidayPackageTests extends BrowserUtility {

	@Test
	public void holidayPackageTesting() throws InterruptedException
	{
		holidaypackage.switchtoFrame();
		holidaypackage.closeloginpage();
		holidaypackage.clickonHolidayPackage();
	}
	
	
}
