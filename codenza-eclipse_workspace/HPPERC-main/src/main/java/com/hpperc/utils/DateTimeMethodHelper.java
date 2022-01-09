package com.hpperc.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateTimeMethodHelper {
	
	public static Date getCurrentDate() throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String d= dateFormat.format(date);
		return dateFormat.parse(d);
	}
	
	public static Date getCurrentDateAndTime() throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String d= dateFormat.format(date);
		return dateFormat.parse(d);
	}

	public static Date addDaysInDate(Date date, int days) throws ParseException {
		LocalDate localDate=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int day=localDate.getDayOfMonth();		
		date.setDate(day+days);
		return date;
	}

	public static Date minusDaysInDate(Date date, int days) throws ParseException {
		LocalDate localDate=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int day=localDate.getDayOfMonth();		
		date.setDate(day-days);
		return date;
	}
}
