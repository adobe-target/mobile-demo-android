/*
 * Copyright (C) 2007-2011 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package com.dailydeals.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.dailydeals.Login;

import android.content.Context;
import android.content.Intent;
import android.os.Process;


// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionHandler handles the exceptions for
 * the activities.
 */
public class ExceptionHandler implements
		java.lang.Thread.UncaughtExceptionHandler
{

	/** The my context. */
	private final Context myContext;

	/**
	 * Instantiates a new exception handler.
	 *
	 * @param context the context
	 */
	public ExceptionHandler(Context context)
	{

		myContext = context;
	}

	/** The Constant CRASH_REPORT. */
	public static final String CRASH_REPORT = "crashReport";

	/* (non-Javadoc)
	 * @see java.lang.Thread.UncaughtExceptionHandler#uncaughtException(java.lang.Thread, java.lang.Throwable)
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable exception)
	{

		final StringWriter stackTrace = new StringWriter();
		exception.printStackTrace(new PrintWriter(stackTrace));

		System.err.println(stackTrace);// You can use LogCat too

		Intent intent = new Intent(myContext, Login.class);
		intent.putExtra(CRASH_REPORT, stackTrace.toString());
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		myContext.startActivity(intent);

		Process.killProcess(Process.myPid());
		System.exit(10);
	}

}
