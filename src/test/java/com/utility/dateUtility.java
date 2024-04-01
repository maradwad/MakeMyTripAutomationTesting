package com.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class dateUtility{
	public static String getFridaydate()
	{
		Date date=new Date();
        LocalDate currentDate = LocalDate.now();
		int todayDay=date.getDay(); //6
		int daydiff=5-todayDay;//5-6 =-1
		if(daydiff<=0)
		{
			daydiff+=7;//-1+7 //6 
		}									
        currentDate=currentDate.plusDays(daydiff);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("E MMM dd yyyy");
        String selectDate=currentDate.format(formatter);
        //System.out.println(selectDate);
        return selectDate;
        
	}
}
