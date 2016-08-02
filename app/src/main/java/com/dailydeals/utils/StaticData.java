package com.dailydeals.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.provider.Settings.Secure;

// TODO: Auto-generated Javadoc
/**
 * The Class StaticData provides the operations regarding 
 * dimensions .
 */
public class StaticData
{
	
	/** The app context. */
	public static Context appContext;
	
	/** The res. */
	public static Resources res;
	
	/** The pref. */
	public static SharedPreferences pref;
	
	/** The density. */
	public static float density;
	
	/** The width. */
	public static int width;
	
	/** The height. */
	public static int height;
	
	/** The screen size. */
	public static int screenSize;
	
	/** The app version. */
	public static String appVersion;

	/**
	 * Inits the.
	 *
	 * @param ctx the ctx
	 */
	public static void init(Activity ctx)
	{

		if (appContext != null)
			return;

		appContext = ctx.getApplicationContext();
		pref = PreferenceManager.getDefaultSharedPreferences(appContext);
		res = appContext.getResources();

		density = res.getDisplayMetrics().density;
		width = res.getDisplayMetrics().widthPixels;
		height = res.getDisplayMetrics().heightPixels;
		screenSize = res.getConfiguration().screenLayout
				& Configuration.SCREENLAYOUT_SIZE_MASK;
		if (screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE)
			density = 2;
		//if (!DbHelper.isOpen())
			//DbHelper.init(appContext);

		// loadSavedItems();

		try
		{
			appVersion = ctx.getPackageManager().getPackageInfo(
					ctx.getPackageName(), 0).versionName;
		} catch (NameNotFoundException e)
		{
			appVersion = "N/A";
			e.printStackTrace();
		}

	}

	/**
	 * Gets the dip.
	 *
	 * @param val the val
	 * @return the dip
	 */
	public static int getDIP(int val)
	{

		return (int) (val * density);
	}

	/**
	 * Gets the udid.
	 *
	 * @return the udid
	 */
	public static String getUDID()
	{

		/*String udid = pref.getString(GCM.REG_ID, null);
		if (udid != null)
			return udid;*/

		return Secure.getString(appContext.getContentResolver(),
				Secure.ANDROID_ID);
	}


	/**
	 * Clear.
	 */
	public static void clear()
	{

		//DbHelper.close();
		System.exit(0);
	}

	/**
	 * Instantiates a new static data.
	 */
	private StaticData()
	{

	}

}
