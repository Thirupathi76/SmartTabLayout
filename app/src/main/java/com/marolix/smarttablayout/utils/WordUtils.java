package com.marolix.smarttablayout.utils;

/**
 * Created by techniche-v1 on 8/11/16.
 */

public class WordUtils {

    public static String toCamelCase(String s) {

        final String ACTIONABLE_DELIMITERS = " '-/";
        // to be capitalized

        StringBuilder sb = new StringBuilder();
        boolean capNext = true;

        for (char c : s.toCharArray()) {
            c = (capNext)
                    ? Character.toUpperCase(c)
                    : Character.toLowerCase(c);
            sb.append(c);
            capNext = (ACTIONABLE_DELIMITERS.indexOf((int) c) >= 0);
        }
        return sb.toString();
    }
}
