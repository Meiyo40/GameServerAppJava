package com.meiyoservices.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenericToolbox {
	public static String getDate()
	{
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy hh:mm");
		Date td = new Date();
		
		return formater.format(td);
	}
}
