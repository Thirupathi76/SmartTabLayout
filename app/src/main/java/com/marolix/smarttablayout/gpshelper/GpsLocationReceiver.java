package com.marolix.smarttablayout.gpshelper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by techniche-android on 22/11/16.
 */

public class GpsLocationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().matches("android.location.PROVIDERS_CHANGED")) {
            ObservableObject.getInstance().updateValue(intent);
        }
    }
}
