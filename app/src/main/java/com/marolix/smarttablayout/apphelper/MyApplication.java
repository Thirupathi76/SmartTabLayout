package com.marolix.smarttablayout.apphelper;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

/*
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.eywa.eywasdk.sdk.SDKInitializer;
import com.mopub.common.MoPub;
import com.techniche.test.ActivityHome;
import com.techniche.test.ActivityLocation;
import com.techniche.test.R;
*/

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * Created by techniche-v1 on 12/10/16.
 */

public class MyApplication extends Application {
    public String AF_DEV_KEY = "nzDRRagjXZKKSSNFDiSvrm";
    @Override
    public void onCreate() {
        super.onCreate();
        //Mint.initAndStartSession(getApplicationContext(), "b81db785");

        /*int error = SDKInitializer.getInstance().InitializeSDK(getApplicationContext(), ActivityHome.class, R.drawable.a2b_logo,
                "APK_A2B");
        if (error != 0)
        {
            Toast.makeText(getApplicationContext(), "InitSDK returned " + error, Toast.LENGTH_LONG).show();
        }
        *//**  Set Up Conversion Listener to get attribution data **//*

        AppsFlyerConversionListener conversionListener = new AppsFlyerConversionListener() {

            *//* Returns the attribution data. Note - the same conversion data is returned every time per install *//*
            @Override
            public void onInstallConversionDataLoaded(Map<String, String> conversionData) {
                for (String attrName : conversionData.keySet()) {
                    Log.d(AppsFlyerLib.LOG_TAG, "attribute: " + attrName + " = " + conversionData.get(attrName));
                }
                setInstallData(conversionData);
            }

            @Override
            public void onInstallConversionFailure(String errorMessage) {
                Log.d(AppsFlyerLib.LOG_TAG, "error getting conversion data: " + errorMessage);
            }

            *//* Called only when a Deep Link is opened *//*
            @Override
            public void onAppOpenAttribution(Map<String, String> conversionData) {
                for (String attrName : conversionData.keySet()) {
                    Log.d(AppsFlyerLib.LOG_TAG, "attribute: " + attrName + " = " + conversionData.get(attrName));
                }
            }

            @Override
            public void onAttributionFailure(String errorMessage) {
                Log.d(AppsFlyerLib.LOG_TAG, "error onAttributionFailure : " + errorMessage);
            }
        };


        *//* This API enables AppsFlyer to detect installations, sessions, and updates. *//*

        AppsFlyerLib.getInstance().init(AF_DEV_KEY , conversionListener , getApplicationContext());
        AppsFlyerLib.getInstance().startTracking(this, AF_DEV_KEY);


        *//* Set to true to see the debug logs. Comment out or set to false to stop the function *//*

        AppsFlyerLib.getInstance().setDebugLog(true);*/

    }

    /* IGNORE - USED TO DISPLAY INSTALL DATA */


    public static String InstallConversionData =  "";
    public static int sessionCount = 0;
    public static void setInstallData(Map<String, String> conversionData){
        if(sessionCount == 0){
            final String install_type = "Install Type: " + conversionData.get("af_status") + "\n";
            final String media_source = "Media Source: " + conversionData.get("media_source") + "\n";
            final String install_time = "Install Time(GMT): " + conversionData.get("install_time") + "\n";
            final String click_time = "Click Time(GMT): " + conversionData.get("click_time") + "\n";
            final String is_first_launch = "Is First Launch: " + conversionData.get("is_first_launch") + "\n";
            InstallConversionData += install_type + media_source + install_time + click_time + is_first_launch;
            sessionCount++;
        }

    }


   /* public void onCreate() {
        super.onCreate();
        getResult(this);
    }*/

}
