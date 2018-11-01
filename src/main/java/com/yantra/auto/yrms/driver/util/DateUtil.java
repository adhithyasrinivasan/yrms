package com.yantra.auto.yrms.driver.util;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.neovisionaries.i18n.CountryCode;

public class DateUtil 
{
	public static DateFormat dateFormatter;
	public static String getCurrentDateTime(String dateFormat)
	{
		dateFormatter = new SimpleDateFormat(dateFormat);
		Calendar date=Calendar.getInstance();
		return dateFormatter.format(date.getTime());
	}
	public static Long getCurrentMilliTime()
	{
		dateFormatter = new SimpleDateFormat();
		Calendar date=Calendar.getInstance();
		return date.getTimeInMillis();
	}
	public static Long getCurrentMilliTimePart(String src) throws ParseException
	{
		dateFormatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		
		Calendar date=Calendar.getInstance();
		date.setTime(dateFormatter.parse(src));
		return date.getTimeInMillis();
	}
	public static long addDaysToTime(int day)
	{
		Date date=new Date(getCurrentMilliTime());
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DATE, day);
		date = c.getTime();
		return date.getTime();
	
	}
	public static int getNumericCountryCode(String code)
	{
		CountryCode cCode = CountryCode.getByCodeIgnoreCase(code);
		return cCode.getNumeric();
	}
	public static String getCountryCodeAlpha2(int code)
	{
		CountryCode cCode = CountryCode.getByCode(code);
		return cCode.getAlpha2();
	}
	public static String getCountryCodeAlpha2(String code)
	{
		CountryCode cCode = CountryCode.getByCode(code);
		return cCode.getAlpha2();
	}
	public static String getCountryCodeAlpha3(int code)
	{
		CountryCode cCode = CountryCode.getByCode(code);
		return cCode.getAlpha3();
	}
	public static String getCountryCodeAlpha3(String code)
	{
		CountryCode cCode = CountryCode.getByCode(code);
		return cCode.getAlpha3();
	}
	public static void main(String args[])
	{
		System.out.println(addDaysToTime(3));
	}
}
