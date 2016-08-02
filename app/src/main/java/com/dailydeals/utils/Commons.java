package com.dailydeals.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Commons is a utility class which provide the basic functions 
 * used in project.
 */
public class Commons
{

	/**
	 * Checks if is empty.
	 *
	 * @param str the str
	 * @return true, if is empty
	 */
	public static boolean isEmpty(String str)
	{
		return str == null || str.equalsIgnoreCase("null")
				|| str.trim().length() == 0;
	}

	/**
	 * Gets the date time.
	 *
	 * @return the date time
	 */
	public static String getDateTime()
	{

		Date d = new Date(Calendar.getInstance().getTimeInMillis());
		String format = "yyyy-MM-dd kk:mm:ss";
		return new SimpleDateFormat(format).format(d);
	}

	/**
	 * Mills to date.
	 *
	 * @param mills the mills
	 * @return the string
	 */
	public static String millsToDate(long mills)
	{

		Date d = new Date(mills);
		String format = "yyyy-MM-dd";
		return new SimpleDateFormat(format).format(d);
	}

	/**
	 * String to calander.
	 *
	 * @param date the date
	 * @param cal the cal
	 */
	public static void stringToCalander(String date, Calendar cal)
	{

		String[] str = date.split("-");
		if (str.length == 3)
			cal.set(Integer.parseInt(str[0]), Integer.parseInt(str[1]) - 1,
					Integer.parseInt(str[2]));
	}

	/**
	 * Date time to millis.
	 *
	 * @param datetime the datetime
	 * @return the long
	 */
	public static long dateTimeToMillis(String datetime)
	{

		Calendar cal = Calendar.getInstance();
		try
		{
			String[] arr = datetime.split(" ");
			String[] str = arr[0].split("-");
			if (str.length == 3)
				cal.set(Integer.parseInt(str[0]), Integer.parseInt(str[1]) - 1,
						Integer.parseInt(str[2]));
			str = arr[1].split(":");
			if (str.length == 3)
			{
				cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(str[0]));
				cal.set(Calendar.MINUTE, Integer.parseInt(str[1]));
				cal.set(Calendar.SECOND, Integer.parseInt(str[2]));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return cal.getTimeInMillis();
	}

	/**
	 * Date time to millis1.
	 *
	 * @param datetime the datetime
	 * @return the long
	 */
	public static long dateTimeToMillis1(String datetime)
	{

		Calendar cal = Calendar.getInstance();
		try
		{
			String[] arr = datetime.split(" ");
			String[] str = arr[0].split("-");
			if (str.length == 3)
				cal.set(Integer.parseInt(str[2]), Integer.parseInt(str[0]) - 1,
						Integer.parseInt(str[1]));
			str = arr[1].split(":");
			if (str.length == 3)
			{
				cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(str[0]));
				cal.set(Calendar.MINUTE, Integer.parseInt(str[1]));
				cal.set(Calendar.SECOND, Integer.parseInt(str[2]));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return cal.getTimeInMillis();
	}

	/**
	 * Mills to date time.
	 *
	 * @param mills the mills
	 * @return the string
	 */
	public static String millsToDateTime(long mills)
	{

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(mills);

		int d = cal.get(Calendar.DAY_OF_MONTH);
		int m = cal.get(Calendar.MONTH) + 1;
		int y = cal.get(Calendar.YEAR);
		int h = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);

		String date = y + "-" + (m < 10 ? "0" + m : m) + "-"
				+ (d < 10 ? "0" + d : d) + " " + (h < 10 ? "0" + h : h) + ":"
				+ (min < 10 ? "0" + min : min);
		return date;
	}

	/**
	 * Str to double.
	 *
	 * @param str the str
	 * @return the double
	 */
	public static double strToDouble(String str)
	{

		try
		{
			return Double.parseDouble(str);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Str to int.
	 *
	 * @param str the str
	 * @return the int
	 */
	public static int strToInt(String str)
	{

		try
		{
			return (int) strToDouble(str);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Str to long.
	 *
	 * @param str the str
	 * @return the long
	 */
	public static long strToLong(String str)
	{

		return (long) strToDouble(str);
	}

	/**
	 * Checks if is before today.
	 *
	 * @param date the date
	 * @return true, if is before today
	 */
	public static boolean isBeforeToday(String date)
	{

		Calendar today = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		stringToCalander(date, cal);

		return cal.compareTo(today) == -1;
	}

	/**
	 * Checks if is between today.
	 *
	 * @param start the start
	 * @param end the end
	 * @return true, if is between today
	 */
	public static boolean isBetweenToday(String start, String end)
	{

		try
		{
			Calendar today = Calendar.getInstance();
			Calendar calStart = Calendar.getInstance();
			stringToCalander(start, calStart);

			Calendar calEnd = Calendar.getInstance();
			stringToCalander(end, calEnd);

			return calStart.compareTo(today) <= 0
					&& calEnd.compareTo(today) >= 0;
		} catch (Exception e)
		{
			return false;
		}
	}
}
