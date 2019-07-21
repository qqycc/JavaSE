package com.qqy.calculation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * 根据日期确定是该年的第几天
 * Author:qqy
 */
public class DateAndDay {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()){
            int year=Integer.parseInt(in.nextLine());
            int month=Integer.parseInt(in.nextLine());
            int day=Integer.parseInt(in.nextLine());
            String date=year+"-"+month+"-"+day;
            String date1=year+"-1-1";
            System.out.println(day(date,date1,"yyyy-MM-dd"));

        }
    }

    public static long day(String date,String date1,String format){
        SimpleDateFormat format1=new SimpleDateFormat(format);
        long day=0L;
        try {
            long time=format1.parse(date).getTime();
            long time1=format1.parse(date1).getTime();
            day=Math.abs(time-time1)/(1000*24*60*60);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day+1;
    }
}
