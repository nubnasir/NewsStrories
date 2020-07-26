package com.nubnasir.newsstories.common.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by root on 9/10/18.
 * <b>Note</b> Helps to convert date time to desired format and type.
 */
public class DateTimeHelper {

    private final static String DATE_FORMAT = "MM/dd/yyyy";

    public static Date convertStringToDate(String dateStr){

        if(dateStr != null && dateStr.trim().length() > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
            try {
                return simpleDateFormat.parse(dateStr);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public static String convertDateToString(Date date){

        if(date != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
            try {
                return simpleDateFormat.format(date);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public static Date convertLongToDate(long date){
        return new Date(date);
    }
}
