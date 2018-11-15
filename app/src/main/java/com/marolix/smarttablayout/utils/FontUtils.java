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
import android.graphics.Typeface;

/**
 * @author Pranav J.Dev E-mail : pranav@techniche.co
 *          Date : 16/6/16
 *          Module : MTD.
 *
 */
public class FontUtils {

    private static FontUtils instance = null;
    private Context mContext;
    private static Typeface italicTypeFace = null;
    private static Typeface regularTypeFace = null;
    private static Typeface chivoTypeFace = null;
    private static Typeface robotoTypeFace = null;
    private static Typeface montserratTypeFace = null;

    private static final String FONT_LIGHT = "Fonts/Montserrat-UltraLight.otf";
    private static final String FONT_REGULAR = "Fonts/Montserrat-Light.otf";
    private static final String FONT_CHIVO = "Fonts/Chivo-Regular.ttf";
    private static final String ROBOTO_REGULAR = "Fonts/Roboto-Regular.ttf";
    private static final String MONTSERRAT_REGULAR = "Fonts/Montserrat-Regular.ttf";

    private FontUtils(Context mContext2) {
        mContext = mContext2;
    }

    public synchronized static FontUtils getInstance(Context mContext) {

        if (instance == null) {
            instance = new FontUtils(mContext);
        }
        return instance;
    }



    public Typeface getRegularTypeFace() {
        if(regularTypeFace == null){
            regularTypeFace = Typeface.createFromAsset(mContext.getAssets(), FONT_REGULAR);
        }
        return regularTypeFace;
    }

    public Typeface getLightTypeFace() {
        if(italicTypeFace == null){
            italicTypeFace = Typeface.createFromAsset(mContext.getAssets(), FONT_LIGHT);
        }
        return italicTypeFace;
    }

    public Typeface getChivoTypeFace() {
        if(chivoTypeFace == null){
            chivoTypeFace = Typeface.createFromAsset(mContext.getAssets(), FONT_CHIVO);
        }
        return chivoTypeFace;
    }

    public Typeface getRobotoTypeFace() {
        if(robotoTypeFace == null){
            robotoTypeFace = Typeface.createFromAsset(mContext.getAssets(), ROBOTO_REGULAR);
        }
        return robotoTypeFace;
    }

    public Typeface getMontesratTypeFace() {
        if(montserratTypeFace == null){
            montserratTypeFace = Typeface.createFromAsset(mContext.getAssets(), MONTSERRAT_REGULAR);
        }
        return montserratTypeFace;
    }


}

