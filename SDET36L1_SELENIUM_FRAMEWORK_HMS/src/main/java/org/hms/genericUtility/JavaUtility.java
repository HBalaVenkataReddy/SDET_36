package org.hms.genericUtility;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public final class JavaUtility
{
	public int getRandomNumber(int limit)
	{
		return new Random().nextInt(limit);
	}
	public long convertStringToLong(String stringdata)
	{
		return Long.parseLong(stringdata);
	}
	public int convertMonthStringToInt(String monthName, String strategy)
	{
		return DateTimeFormatter.ofPattern(strategy).withLocale(Locale.ENGLISH).parse(monthName).get(ChronoField.MONTH_OF_YEAR);
	}
	public String convertFromIntegerToString(int number)
	{
		return String.valueOf(number);
	}
	public void splitTime(String time)
	{
		String []s1=time.split(":");
		String s2 = time.substring(0, time.indexOf(":"));
		System.out.println(s1[0]);
	}
	public String getCurrentDate(String strategy)
	{
		return new SimpleDateFormat(strategy).format(new Date());
	}
	public void printStatement(String value)
	{
		System.out.println(value);
	}
}