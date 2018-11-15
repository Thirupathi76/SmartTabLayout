/*
 * Copyright (c) 2016 Codea Technologies (P) Ltd.
 * 2nd floor , Athulya ,
 * Infopark, Kakkanad, Kochi
 *
 * All rights reserved.
 * This software is the confidential and proprietary information of Codea Technologies (P) Ltd.
 * You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with
 * Codea Technologies (P) Ltd.
 *
 */
package com.marolix.smarttablayout.utils;

import android.util.Log;

/*
 * 
 * TODO
 * 
 * 
 * @author Pranav J.Dev
 *		E-mail	: 	{@link Email pranavj@negociosit.com}
 *      Date	: 	Nov 4, 2014, 2:42:34 PM
 *      Module	:	SecureMessaging
 */
public class Logger {

	public static final String TAG = "Absolute Privacy";
	
	public static final boolean DEBUGGING_BUILD = true;

	public static void debug(final String tag, final Object message) {
		if (DEBUGGING_BUILD) 
			Log.d(tag, message.toString());
	}

	public static void info(final String tag, final String message) {
		if (DEBUGGING_BUILD)
			Log.i(tag, message);
	}

	public static void error(final String tag, final Object message) {
		if (DEBUGGING_BUILD){
			Log.e(tag, ""+message.toString());

		}
	}
	
	public static void error(final String tag, final Object message, final Throwable t) {
		if (DEBUGGING_BUILD){
			Log.e(tag, message.toString(), t);

		}
	}

	public static void error(final String tag, final String message,
							 final Throwable throwable) {
		if (DEBUGGING_BUILD)
			Log.e(tag, message, throwable);
	}

}
