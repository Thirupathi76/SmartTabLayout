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

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;

public class AsyncTaskExecutor<Params, Progress, Result> {
    @SuppressLint("NewApi")
    public AsyncTask<Params, Progress, Result> execute(
            final AsyncTask<Params, Progress, Result> asyncTask,
            final Params... params) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
        } else {
            return asyncTask.execute(params);
        }
    }
}