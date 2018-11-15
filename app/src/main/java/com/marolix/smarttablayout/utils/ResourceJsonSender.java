package com.marolix.smarttablayout.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 * Created by goutam on 21/9/16.
 */
public class ResourceJsonSender {

    public static String getJsonFromResource(Context mContext, int fileId) throws IOException {
        String jsonString = null;
        InputStream is = mContext.getResources().openRawResource(fileId);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
        }

        jsonString = writer.toString();
        return  jsonString;
    }
}
