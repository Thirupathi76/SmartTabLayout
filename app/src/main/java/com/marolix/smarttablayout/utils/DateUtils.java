package com.marolix.smarttablayout.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by techniche-v1 on 20/10/16.
 */

public class DateUtils {

    public static String UtcToJavaDateFormat(String myUTC,SimpleDateFormat requiredDateFormat){
        String myDate = null;
        SimpleDateFormat existingUTCFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        try{
            Date getDate = existingUTCFormat.parse(myUTC);
            myDate = requiredDateFormat.format(getDate);
        }
        catch(ParseException ex){
            ex.printStackTrace();
        }
        return myDate;
    }
}
