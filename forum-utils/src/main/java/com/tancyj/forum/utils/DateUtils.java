package com.tancyj.forum.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String datetoString(Date date,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }
    public static Date stringtoDate(String str,String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(str);
        return parse;
    }

//    public static void main(String[] args) throws ParseException {
//        String birthdayStr = "2020-03-19";
//        Date a  = DateUtils.stringtoDate(birthdayStr,"yyyy-MM-dd");
//        System.out.println(a);
//    }
}
