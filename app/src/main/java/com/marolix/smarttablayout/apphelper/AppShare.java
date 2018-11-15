package com.marolix.smarttablayout.apphelper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by techniche-android on 24/11/16.
 */

public class AppShare {

    private static final String APP_SHARED_NAME = "app_shared";
    private static final String CURRENT_LOCATION = "currentLocation";
    private static final String CURR_LAT = "currLat";
    private static final String CURR_LNG = "currLng";
    private static final String TOTAL_AMOUNT = "totalCartAmount";
    private static final String PAYMENT_OPTION = "payment_option";
    private static final String STORE_ID = "StoreID";
    private static final String STORE_NAME = "StoreName";
    private static final String STORE_CODE = "StoreCode";
    private static final String DELIVERY_ADDRESS = "DeliveryAddressModel";
    private static final String STORE_LOCATION = "StoreLocation";
    private static final String LAST_SELECTED_ADDRS = "LastSelectedAddrs";

    private Context context = null;
    private SharedPreferences shared = null;

    public AppShare(Context context) {
        this.context = context;
        shared = context.getSharedPreferences(APP_SHARED_NAME, context.MODE_PRIVATE);
    }

    public void clear() {
        shared.edit().clear();
    }

    public String getCurrentLocation() {
        return shared.getString(CURRENT_LOCATION, null);
    }

    public void setCurrentLocation(String location) {
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(CURRENT_LOCATION, location);
        editor.commit();
    }

    public String getStoreId() {
        return shared.getString(STORE_ID, null);
    }

    public void setStoreId(String location) {
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(STORE_ID, location);
        editor.commit();
    }

    public String getStoreName() {
        return shared.getString(STORE_NAME, null);
    }

    public void setStoreName(String location) {
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(STORE_NAME, location);
        editor.commit();
    }

    public String getStoreCode() {
        return shared.getString(STORE_CODE, null);
    }

    public void setStoreCode(String storeCode) {
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(STORE_CODE, storeCode);
        editor.commit();
    }

    /*public void setStoreLocation(String[] location) {
        SharedPreferences.Editor editor = shared.edit();
        editor.putStringSet(STORE_LOCATION, location);
        editor.commit();
    }*/

    public boolean saveArray(String[] array, String arrayName, Context mContext) {
        SharedPreferences.Editor editor = shared.edit();
        editor.putInt(arrayName + "_size", array.length);
        for (int i = 0; i < array.length; i++)
            editor.putString(arrayName + "_" + i, array[i]);
        return editor.commit();
    }

    public String[] getArray(String arrayName, Context mContext) {
        int size = shared.getInt(arrayName + "_size", 0);
        String array[] = new String[size];
        for (int i = 0; i < size; i++)
            array[i] = shared.getString(arrayName + "_" + i, null);
        return array;
    }

    public String getStoreLocation() {
        return shared.getString(STORE_LOCATION, "[]");
    }

    public String getDeliveryAddress() {
        return shared.getString(DELIVERY_ADDRESS, null);
    }

    public void setDeliveryAddress(String location) {
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(DELIVERY_ADDRESS, location);
        editor.commit();
    }

    public String getPaymentOption() {
        return shared.getString(PAYMENT_OPTION, null);
    }

    public void setPaymentOption(String location) {
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(PAYMENT_OPTION, location);
        editor.commit();
    }

    /*public double getCurrLat(){
        return Double.parseDouble(shared.getString(CURR_LAT,"0.0"));
    }

    public void setCurrLat(double point){
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(CURR_LAT,String.valueOf(point));
    }

    public double getCurrLng(){
        return Double.parseDouble(shared.getString(CURR_LNG,"0.0"));
    }

    public void setCurrLng(double point){
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(CURR_LNG,String.valueOf(point));
    }*/

    public double getCurrTotalAmount() {
        return Double.parseDouble(shared.getString(TOTAL_AMOUNT, "0.0"));
    }

    public void setCurrTotalAmount(double point) {
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(TOTAL_AMOUNT, String.valueOf(point));
        editor.commit();
    }

    public int getLastSelectedAddrs() {
        return Integer.parseInt(shared.getString(LAST_SELECTED_ADDRS, "0"));
    }

    public void setLastSelectedAddrs(int lastSelectedAddrsPos) {
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(LAST_SELECTED_ADDRS, String.valueOf(lastSelectedAddrsPos));
        editor.commit();
    }
}