package com.dailydeals.utils;

// TODO: Auto-generated Javadoc
/**
 * The Class Log defines the method for displaying the TAGs in 
 * logcat.
 */
public class Log
{
	
	/**
	 * E.
	 *
	 * @param tag the tag
	 * @param msg the msg
	 */
	public static void e(String tag, Object msg)
	{

		android.util.Log.e(tag, "" + msg);
	}
	
	/**
	 * E.
	 *
	 * @param msg the msg
	 */
	public static void e(Object msg)
	{

		e("TAG", "" + msg);
	}

	
	/**
	 * E.
	 *
	 * @param tag the tag
	 * @param msg the msg
	 */
	public static void e(String tag, Object[] msg)
	{

		StringBuffer sb = new StringBuffer();
		for (Object o : msg)
			sb.append(o + "__");

		e(tag, sb);
	}

	/**
	 * E.
	 *
	 * @param msg the msg
	 */
	public static void e(Object[] msg)
	{

		e("TAG", msg);
	}

}
