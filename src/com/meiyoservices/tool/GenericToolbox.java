package com.meiyoservices.tool;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenericToolbox {
	public static String getDate()
	{
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy hh:mm");
		Date td = new Date();
		
		return formater.format(td);
	}
	
	public static String parseUptime(String val)
	{
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		long time = ts.getTime() - Long.parseLong(val);
		int day = 0;
		int hours = 0;
		int min = 0;
		if(time > 1000)
		{
			final int SCD_PER_DAY = 86400;
			final int SCD_PER_HOUR = 3600;
			final int SCD_PER_MIN = 60;
			
			time = time/1000;
			day = (int) Math.floor(time / SCD_PER_DAY);
			time = time % SCD_PER_DAY;
			hours = (int) Math.floor(time / SCD_PER_HOUR);
			time = time % SCD_PER_HOUR;
			min = (int) Math.floor(time / SCD_PER_MIN);
		}
		String uptimeString =  day + "d " + hours + "h " + min + "min";
		
		return uptimeString;
	}
}
