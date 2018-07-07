package com.picme.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyTimeUtil {
	public static Timestamp getTime(int year, int month, int date, 
			int hourOfDay, int minute, int second) {
		
		Calendar c= Calendar.getInstance();
		c.set(year, month-1, date, hourOfDay, minute, second);
		Timestamp time = new Timestamp(c.getTimeInMillis());
		
		return time;
	}
	
	public static String getTime(Timestamp time) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSSS");
		String ret = dateFormat.format(time);
		
		return ret;
	}
	
	public static Timestamp getTimeNow() {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		return time;
	}
}
