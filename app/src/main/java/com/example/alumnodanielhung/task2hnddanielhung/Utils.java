package com.example.alumnodanielhung.task2hnddanielhung;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ALUMNOS on 10/03/2017.
 */

public class Utils {

    public static boolean isEmail (String email) {
        String regex = "^[_a-z0-9-]+(_a-z0-9-)*@[_a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
