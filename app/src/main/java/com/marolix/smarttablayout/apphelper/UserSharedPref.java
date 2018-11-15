package com.marolix.smarttablayout.apphelper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by techniche-v1 on 7/10/16.
 */

public class UserSharedPref {

    /*{
        "_id": "57f61506e22a2d142980f294",
            "name": "karthic",
            "email": "sachin@techniche.com",
            "phone": 9551780069,
            "__v": 0,
            "created": "2016-10-06T09:10:30.088Z",
            "roles": [
        "user"
        ],
        "provider": "local",
            "addresses": []
    }*/

    private static final String ISLOGGEDIN = "is_loggedin";
    private static final String USERID = "_id";
    private static final String USERNAME = "name";
    private static final String USEREMAIL = "email";
    private static final String USERPHONE = "phone";
    private static final String USERSHAREDPREF = "user_Shared_pref";
    private SharedPreferences sharedPreferences = null;
    private Context context = null;

    public UserSharedPref(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(USERSHAREDPREF, Context.MODE_PRIVATE);
    }

    public void setUserPref(String name, String email, String phone, String id) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(USERID, id);
        edit.putString(USERNAME, name);
        edit.putString(USEREMAIL, email);
        edit.putString(USERPHONE, phone);
        edit.putBoolean(ISLOGGEDIN, true);
        edit.commit();
    }

    public void setUserPref(String name) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(USERNAME, name);
        edit.putBoolean(ISLOGGEDIN, true);
        edit.commit();
    }
    public void setUserPrefPhone(String mobile) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(USERPHONE, mobile);
        edit.putBoolean(ISLOGGEDIN, true);
        edit.commit();
    }

    public boolean getLoginStatus() {
        return sharedPreferences.getBoolean(ISLOGGEDIN, false);
    }

    public String getUserName() {
        return sharedPreferences.getString(USERNAME, "");
    }

    public String getUserEmail() {
        return sharedPreferences.getString(USEREMAIL, "");
    }

    public String getUserPhone() {
        return sharedPreferences.getString(USERPHONE, "");
    }

    public String getUserId() {
        return sharedPreferences.getString(USERID, "");
    }

    public void setLogout() {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(USERID, "");
        edit.putString(USERNAME, "");
        edit.putString(USEREMAIL, "");
        edit.putString(USERPHONE, "");
        edit.putBoolean(ISLOGGEDIN, false);
        edit.commit();
    }
}