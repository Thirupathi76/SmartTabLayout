/*
 * Copyright (c) 2016 Techniche E-commerce Solutions Pvt Ltd
 * No.14, 6th Floor,
 * Orchid Techscape, STPI Campus,
 * Cyber Park, Electronics City Phase1,
 * Bangalore-560100.
 *
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Techniche E-commerce
 * Solutions Pvt Ltd. You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with
 * Techniche E-commerce Solutions Pvt Ltd.
 */

package com.marolix.smarttablayout.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Created by techniche on 1/8/16.
 */
public class FileUtils {

    public static final String SELECTED_PRODUCT = "selected_product.json";


    /**
     * @param context
     * @param contents
     * @param fileName
     * @return
     */
    public static boolean saveFile(Context context, String contents,
                                   String fileName) throws IOException {
        FileOutputStream fos = context.openFileOutput(fileName,
                Context.MODE_PRIVATE);
        Writer out = new OutputStreamWriter(fos);
        out.write(contents);
        out.close();
        return true;

    }


    /**
     * @param context
     * @param fileName
     * @return
     */
    public static String load(Context context, String fileName) {
        try {
            FileInputStream fis = context.openFileInput(fileName);
            BufferedReader r = new BufferedReader(new InputStreamReader(fis));
            String line = r.readLine();
            r.close();
            return line;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isFileExists(Context context,String fileName) {
        File file = context.getFileStreamPath(fileName);
        if (file.exists())
            return true;
        else
            return false;
    }

    public static void deleteFile(Context context,String fileName) {
        File file = context.getFileStreamPath(fileName);
        if (file.exists())
            file.delete();

    }

}
