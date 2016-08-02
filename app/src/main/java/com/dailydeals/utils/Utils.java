package com.dailydeals.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


// TODO: Auto-generated Javadoc
/**
 * The Class Utils is also a utility class provide 
 * the basic operations in the app.
 */
public class Utils
{
	
	/**
	 * Show dialog.
	 *
	 * @param ctx the ctx
	 * @param msg the msg
	 * @param btn1 the btn1
	 * @param btn2 the btn2
	 * @param listener1 the listener1
	 * @param listener2 the listener2
	 * @return the alert dialog
	 */
	public static AlertDialog showDialog(Context ctx, String msg, String btn1,
			String btn2, DialogInterface.OnClickListener listener1,
			DialogInterface.OnClickListener listener2)
	{

		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		// builder.setTitle(R.string.app_name);
		builder.setMessage(msg).setCancelable(false)
				.setPositiveButton(btn1, listener1);
		if (btn2 != null && listener2 != null)
			builder.setNegativeButton(btn2, listener2);

		AlertDialog alert = builder.create();
		alert.show();
		return alert;

	}


	/**
	 * Show dialog.
	 *
	 * @param ctx the ctx
	 * @param msg the msg
	 * @param btn1 the btn1
	 * @param btn2 the btn2
	 * @param listener1 the listener1
	 * @param listener2 the listener2
	 * @return the alert dialog
	 */
	public static AlertDialog showDialog(Context ctx, int msg, int btn1,
			int btn2, DialogInterface.OnClickListener listener1,
			DialogInterface.OnClickListener listener2)
	{

		return showDialog(ctx, ctx.getString(msg), ctx.getString(btn1),
				ctx.getString(btn2), listener1, listener2);

	}

	/**
	 * Show dialog.
	 *
	 * @param ctx the ctx
	 * @param msg the msg
	 * @param btn1 the btn1
	 * @param btn2 the btn2
	 * @param listener the listener
	 * @return the alert dialog
	 */
	public static AlertDialog showDialog(Context ctx, String msg, String btn1,
			String btn2, DialogInterface.OnClickListener listener)
	{

		return showDialog(ctx, msg, btn1, btn2, listener,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id)
					{

						dialog.dismiss();
					}
				});

	}
	
	/**
	 * Show dialog.
	 *
	 * @param ctx the ctx
	 * @param msg the msg
	 * @param btn1 the btn1
	 * @param btn2 the btn2
	 * @param listener the listener
	 * @return the alert dialog
	 */
	public static AlertDialog showDialog(Context ctx, int msg, int btn1,
			int btn2, DialogInterface.OnClickListener listener)
	{

		return showDialog(ctx, ctx.getString(msg), ctx.getString(btn1),
				ctx.getString(btn2), listener);

	}

	/**
	 * Show dialog.
	 *
	 * @param ctx the ctx
	 * @param msg the msg
	 * @param listener the listener
	 * @return the alert dialog
	 */
	public static AlertDialog showDialog(Context ctx, String msg,
			DialogInterface.OnClickListener listener)
	{

		return showDialog(ctx, msg, ctx.getString(android.R.string.ok), null,
				listener, null);
	}

	/**
	 * Show dialog.
	 *
	 * @param ctx the ctx
	 * @param msg the msg
	 * @param listener the listener
	 * @return the alert dialog
	 */
	public static AlertDialog showDialog(Context ctx, int msg,
			DialogInterface.OnClickListener listener)
	{

		return showDialog(ctx, ctx.getString(msg),
				ctx.getString(android.R.string.ok), null, listener, null);
	}

	/**
	 * Show dialog.
	 *
	 * @param ctx the ctx
	 * @param msg the msg
	 * @return the alert dialog
	 */
	public static AlertDialog showDialog(Context ctx, String msg)
	{

		return showDialog(ctx, msg, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int id)
			{

				dialog.dismiss();
			}
		});

	}

	/**
	 * Show dialog.
	 *
	 * @param ctx the ctx
	 * @param msg the msg
	 * @return the alert dialog
	 */
	public static AlertDialog showDialog(Context ctx, int msg)
	{

		return showDialog(ctx, ctx.getString(msg));

	}

	/**
	 * Show dialog.
	 *
	 * @param ctx the ctx
	 * @param title the title
	 * @param msg the msg
	 * @param listener the listener
	 */
	public static void showDialog(Context ctx, int title, int msg,
			DialogInterface.OnClickListener listener)
	{

		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		builder.setMessage(msg).setCancelable(false)
				.setPositiveButton(android.R.string.ok, listener);
		builder.setTitle(title);
		AlertDialog alert = builder.create();
		alert.show();
	}


	/**
	 * Checks if is online.
	 *
	 * @param ctx the ctx
	 * @return true, if is online
	 */
	public static final boolean isOnline(Context ctx)
	{

		ConnectivityManager conMgr = (ConnectivityManager) ctx
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		if (conMgr.getActiveNetworkInfo() != null

		&& conMgr.getActiveNetworkInfo().isAvailable()

		&& conMgr.getActiveNetworkInfo().isConnected())
			return true;
		return false;
	}

	/**
	 * Checks if is valid email.
	 *
	 * @param email the email
	 * @return true, if is valid email
	 */
	public static boolean isValidEmail(String email)
	{

		String emailExp = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,10}$";
		Pattern pattern = Pattern.compile(emailExp, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * Checks if is valid phone number.
	 *
	 * @param number the number
	 * @return true, if is valid phone number
	 */
	public static boolean isValidPhoneNumber(String number)
	{

		String numExp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{2,15})$";
		Pattern pattern = Pattern.compile(numExp, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(number);
		return matcher.matches();
	}

	/**
	 * Checks if is numeric.
	 *
	 * @param number the number
	 * @return true, if is numeric
	 */
	public static boolean isNumeric(String number)
	{

		String numExp = "^[-+]?[0-9]*\\.?[0-9]+$";
		Pattern pattern = Pattern.compile(numExp, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(number);
		return matcher.matches();
	}

	/**
	 * Hide keyboard.
	 *
	 * @param ctx the ctx
	 */
	public static final void hideKeyboard(Activity ctx)
	{

		if (ctx.getCurrentFocus() != null)
		{
			InputMethodManager imm = (InputMethodManager) ctx
					.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(ctx.getCurrentFocus().getWindowToken(),
					0);
		}
	}

	/**
	 * Hide keyboard.
	 *
	 * @param ctx the ctx
	 * @param v the v
	 */
	public static final void hideKeyboard(Activity ctx, View v)
	{

		try
		{
			InputMethodManager imm = (InputMethodManager) ctx
					.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Show keyboard.
	 *
	 * @param ctx the ctx
	 * @param v the v
	 */
	public static final void showKeyboard(Activity ctx, View v)
	{

		try
		{
			v.requestFocus();
			InputMethodManager imm = (InputMethodManager) ctx
					.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT);
			// imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
			// InputMethodManager.SHOW_IMPLICIT);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Make call.
	 *
	 * @param act the act
	 * @param number the number
	 */
	public static final void makeCall(final Activity act, final String number)
	{

		Utils.showDialog(act, "Call " + number.replace(" ", ""), "Ok",
				"Cancel", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which)
					{

						Intent call = new Intent(Intent.ACTION_CALL);
						call.setData(Uri.parse("tel:" + number.trim()));
						act.startActivity(call);
					}
				}).show();
	}

	/**
	 * De serialise obj.
	 *
	 * @param obj the obj
	 * @return the object
	 */
	public static final Object deSerialiseObj(byte[] obj)
	{

		if (obj != null && obj.length > 0)
		{
			try
			{
				ObjectInputStream in = new ObjectInputStream(
						new ByteArrayInputStream(obj));
				Object o = in.readObject();
				in.close();
				return o;
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Serialise obj.
	 *
	 * @param obj the obj
	 * @return the byte[]
	 */
	public static final byte[] serialiseObj(Serializable obj)
	{

		try
		{
			ByteArrayOutputStream bArr = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bArr);
			out.writeObject(obj);
			byte b[] = bArr.toByteArray();
			out.close();
			bArr.close();
			return b;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Copy file.
	 *
	 * @param src the src
	 * @param dst the dst
	 */
	public static void copyFile(File src, File dst)
	{

		try
		{
			if (!dst.exists())
				dst.createNewFile();
			FileInputStream in = new FileInputStream(src);
			FileOutputStream out = new FileOutputStream(dst);

			int size = (int) src.length();
			byte[] buf = new byte[size];
			in.read(buf);
			out.write(buf);
			out.flush();
			out.close();
			in.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Creates the no media file.
	 *
	 * @param dir the dir
	 */
	public static void createNoMediaFile(File dir)
	{

		try
		{
			File f = new File(dir, ".nomedia");
			if (!f.exists())
				f.createNewFile();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Gets the m d5 string.
	 *
	 * @param in the in
	 * @return the m d5 string
	 */
	public static String getMD5String(String in)
	{

		MessageDigest digest;
		try
		{
			digest = MessageDigest.getInstance("MD5");
			digest.reset();
			digest.update(in.getBytes());
			byte[] a = digest.digest();
			int len = a.length;
			StringBuilder sb = new StringBuilder(len << 1);
			for (int i = 0; i < len; i++)
			{
				sb.append(Character.forDigit((a[i] & 0xf0) >> 4, 16));
				sb.append(Character.forDigit(a[i] & 0x0f, 16));
			}
			// Log.e("MD5", in+"--"+sb.toString());
			return sb.toString();
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Change locale.
	 *
	 * @param act the act
	 * @param locale the locale
	 */
	public static void changeLocale(Activity act, Locale locale)
	{

		// Locale locale = new Locale(lang);
		// Locale.setDefault(locale);
		Configuration config = new Configuration();
		config.locale = locale;
		act.getBaseContext()
				.getResources()
				.updateConfiguration(config,
						act.getBaseContext().getResources().getDisplayMetrics());
	}

	/**
	 * Gets the formatted count.
	 *
	 * @param count the count
	 * @return the formatted count
	 */
	public static String getFormattedCount(int count)
	{

		if (count >= 100000)
			return "1M";
		if (count >= 10000)
			return "10K";
		if (count >= 1000)
			return "1K";
		return count + "";
	}

	/**
	 * Gets the base64 image string.
	 *
	 * @param file the file
	 * @return the base64 image string
	 */
	public static String getBase64ImageString(String file)
	{

		if (file == null)
			return null;
		try
		{
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			BufferedInputStream bin = new BufferedInputStream(
					new FileInputStream(file));
			int b;
			while ((b = bin.read()) != -1)
				bout.write(b);
			byte img[] = bout.toByteArray();
			bout.flush();
			bout.close();
			bin.close();
			return Base64.encodeToString(img, Base64.DEFAULT);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/*public static String getStringFromAsset(String path)
	{
		try
		{
			BufferedReader din = new BufferedReader(new InputStreamReader(
					StaticData.appContext.getAssets().open(path)));

			String str = "";
			String s;
			while ((s = din.readLine()) != null)
				str = str + s;
			din.close();
			return str;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static int parseDrawableId(String str)
	{
		return StaticData.res.getIdentifier(str, "drawable",
				StaticData.appContext.getPackageName());
	}*/
	
}
