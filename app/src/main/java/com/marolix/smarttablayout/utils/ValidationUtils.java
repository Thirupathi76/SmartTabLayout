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
import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;


public class ValidationUtils {
    // Regular Expression
    // you can change the expression based on your need
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONE_REGEX = "\\d{10}";

    // Error Messages
    private static final String REQUIRED_MSG = "required";
    private static final String VALID_GENDER_MSG = "please enter male/female";
    private static final String PASSWORD_MESSAGE = "password should contain atleast 6 letters";
    private static final String MOBILE_MESSAGE = "Enter 10 digit Mobile Number";
    private static final String EMAIL_MSG = "invalid email";
    private static final String PHONE_MSG = "###-#######";

    // call this method when you need to check email validation
    public static boolean isEmailAddress(EditText editText, boolean required, Context context, String message) {
        return isValid(editText, EMAIL_REGEX, EMAIL_MSG, required, context, message);
    }

    public static boolean isValidEmailAddress(EditText editText, boolean required, TextInputLayout layout) {
        return isValidEmail(editText, EMAIL_REGEX, EMAIL_MSG, required, layout);
    }

    // call this method when you need to check phone number validation
    public static boolean isPhoneNumber(EditText editText, boolean required, Context context, String message) {
        return isValid(editText, PHONE_REGEX, PHONE_MSG, required, context, message);
    }

    public static boolean isPhoneNumberLayout(EditText editText, boolean required, TextInputLayout layout) {
        return isValidLayout(editText, PHONE_REGEX, PHONE_MSG, required, layout);
    }

    // return true if the input field is valid, based on the parameter passed
    public static boolean isValid(EditText editText, String regex,
                                  String errMsg, boolean required, Context context, String message) {

        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        // text required and editText is blank, so return false
        if (required && !hasText(editText, context, message))
            return false;

        // pattern doesn't match so returning false
        if (required && !Pattern.matches(regex, text)) {
            //editText.setError(errMsg);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                return false;
        }
        return true;
    }


    public static boolean isValidLayout(EditText editText, String regex,
                                        String errMsg, boolean required, TextInputLayout layout) {

        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        layout.setErrorEnabled(false);
        editText.setError(null);

        // text required and editText is blank, so return false
        if (required && !hasTextLayout(editText, layout))
            return false;

        // pattern doesn't match so returning false
        if (required && !Pattern.matches(regex, text)) {
            layout.setError(errMsg);
            return false;
        }
        ;

        return true;
    }

    public static boolean isValidEmail(EditText editText, String regex,
                                       String errMsg, boolean required, TextInputLayout layout) {

        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        layout.setErrorEnabled(false);
        editText.setError(null);
        // text required and editText is blank, so return false
        if (required && !hasTextLayout(editText, layout))
            return false;

        // pattern doesn't match so returning false
        if (required && !Pattern.matches(regex, text)) {
            layout.setError(errMsg);
            return false;
        };

        return true;
    }

    public static boolean validateEmail(EditText editText, TextInputLayout textInputLayout, String msg) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        if (!Pattern.matches(EMAIL_REGEX, text)) {
            editText.requestFocus();
            textInputLayout.setError(msg);
            return false;
        }
        textInputLayout.setError(null);
        textInputLayout.setErrorEnabled(false);
        return true;
    }


    // check the input field has any text or not
    // return true if it contains text otherwise false
    public static boolean hasTextLayout(EditText editText, TextInputLayout layout) {

        String text = editText.getText().toString().trim();
        layout.setErrorEnabled(false);
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0) {
            layout.setError(REQUIRED_MSG);
            return false;
        }

        return true;
    }

    // check the input field has any text or not
    // return true if it contains text otherwise false
    public static boolean hasText(EditText editText, TextInputLayout textInputLayout, String message) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0) {
            editText.requestFocus();
            textInputLayout.setError(message);
            return false;
        }
        textInputLayout.setError(null);
        textInputLayout.setErrorEnabled(false);
        return true;
    }

    public static boolean hasText(TextView textView, Context context, String message) {

        String text = textView.getText().toString().trim();
        textView.setError(null);

        // length 0 means there is no text
        if (text.length() == 0) {
            //editText.setError(REQUIRED_MSG);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                /*textView.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.red_border, null));
            textView.setHintTextColor(ContextCompat.getColor(context, R.color.red));
            textView.setHint(message);*/
                textView.requestFocus();
            return false;
        }
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        //textView.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.blue_border, null));
        //textView.setTextColor(ContextCompat.getColor(context, R.color.text_color));
        return true;
    }


    public static boolean isValidGender(EditText editText, Context context) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (TextUtils.isEmpty(text)) {
            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                editText.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.red_border, null));
            editText.setHintTextColor(ContextCompat.getColor(context, R.color.red));
            editText.setHint(R.string.required);*/
            return false;
        } else {
            if (!text.equalsIgnoreCase("Male") && !text.equalsIgnoreCase("Female")) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                    /*editText.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.red_border, null));
                editText.setTextColor(ContextCompat.getColor(context, R.color.red));*/
                    return false;
            }
        }
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            editText.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.blue_border, null));
        editText.setTextColor(ContextCompat.getColor(context, R.color.text_color));*/
        return true;
    }

    public static boolean isValidGenderLayout(EditText editText, TextInputLayout layout) {

        String text = editText.getText().toString().trim();
        layout.setErrorEnabled(false);
        editText.setError(null);

        // length 0 means there is no text
        if (TextUtils.isEmpty(text)) {
            layout.setError(REQUIRED_MSG);
            return false;
        } else {
            if (!text.equalsIgnoreCase("Male") && !text.equalsIgnoreCase("Female")) {
                layout.setError(VALID_GENDER_MSG);
                return false;
            }
        }

        return true;
    }


    public static boolean passwordValid(EditText editText, Context context) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                /*editText.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.red_border, null));
            editText.setHintTextColor(ContextCompat.getColor(context, R.color.red));
            editText.setHint(R.string.password);*/
                editText.requestFocus();
            return false;
        } else if (text.length() < 6) {
            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                editText.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.red_border, null));
            editText.setTextColor(ContextCompat.getColor(context, R.color.red));*/
            editText.requestFocus();
            return false;
        }
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            editText.setBackground(ResourcesCompat.getDrawable(context.getResources(), R.drawable.blue_border, null));
        editText.setTextColor(ContextCompat.getColor(context, R.color.text_color));*/
        return true;
    }


    public static boolean passwordValidLayout(EditText editText, TextInputLayout layout) {

        String text = editText.getText().toString().trim();
        layout.setErrorEnabled(false);
        editText.setError(null);
        // length 0 means there is no text
        if (text.length() == 0) {
            layout.setError(REQUIRED_MSG);
            return false;
        } else if (text.length() < 6) {
            layout.setError(PASSWORD_MESSAGE);
            return false;
        }


        return true;
    }

    //Validation for Phone Number
    public static boolean validatePhone(EditText editText, TextInputLayout textInputLayout, String msg) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        if (text.length() == 0) {
            editText.requestFocus();
            textInputLayout.setError(msg);
            return false;
        } else if (text.length() < 10) {
            editText.requestFocus();
            textInputLayout.setError(MOBILE_MESSAGE);
            return false;
        }
        textInputLayout.setError(null);
        textInputLayout.setErrorEnabled(false);
        return true;
    }
}