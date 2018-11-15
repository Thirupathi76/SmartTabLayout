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

package com.marolix.smarttablayout.gpshelper;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * @author Pranav J.Dev E-mail : pranav@techniche.co
 *         Date : ${DATE}
 *         Module : SOWCustomer.
 */
public class LocationAddressLoader {

    public static void getAddressFromLocation(final double latitude, final double longitude,
                                              final Context context, final Handler handler) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                String result = null;
                String city = null;
                String street = null;
                String pinCode = null;
                try {
                    List<Address> addressList = geocoder.getFromLocation(
                            latitude, longitude, 1);
                    if (addressList != null && addressList.size() > 0) {
                        Address address = addressList.get(0);
                        StringBuilder sb = new StringBuilder();


                        if (!TextUtils.isEmpty(address.getSubLocality())) {
                            city = address.getSubLocality();//.append("\n");
                            sb.append(city);
                        }
                         if (!TextUtils.isEmpty(address.getLocality())) {
                             street = address.getLocality();
                             sb.append(street);
                         }if (!TextUtils.isEmpty(address.getPostalCode())) {
                            pinCode = address.getPostalCode();
                            sb.append(pinCode);
                        }
                      /*  for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                            sb.append(address.getAddressLine(i));//.append("\n");
                        }
                        sb.append(address.getLocality()).append("\n");
                        sb.append(address.getPostalCode()).append("\n");
                        sb.append(address.getCountryName());*/
                        result = sb.toString();
                    }
                } catch (IOException e) {
                    Log.e("Location Address Loader", "Unable connect to Geocoder", e);
                } finally {
                    Message message = Message.obtain();
                    message.setTarget(handler);
                    if (result != null) {
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        bundle.putString("pinCode", pinCode);
                        bundle.putString("city", city);
                        bundle.putString("street", street);
                        bundle.putString("address", "Address");
                        message.setData(bundle);
                    } else {
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        result = "Unable to find location";
                        bundle.putString("address", result);
                        message.setData(bundle);
                    }
                    message.sendToTarget();
                }
            }
        };
        thread.start();
    }
}
