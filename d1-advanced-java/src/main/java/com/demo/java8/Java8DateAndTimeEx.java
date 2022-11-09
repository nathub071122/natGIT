package com.demo.java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Java8DateAndTimeEx {
    public static void main(String[] args) {
//        current date from system clock with default time-zone
        LocalDate localDate = LocalDate.now();
        System.out.println("Local Date : " + localDate);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Local Date & Time : " + localDateTime);
        String localDateTimeString = localDateTime.toString();
        System.out.println(localDateTimeString);

        String dateString = "2022-11-09";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parsedDate = simpleDateFormat.parse(dateString);
//            old style, backward compatability.
            System.out.println(parsedDate.getDay() + "/" + (parsedDate.getMonth()+1) + "/" + (parsedDate.getYear()+1900));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parsedDate);
            System.out.println(calendar.get(Calendar.DAY_OF_MONTH) + "/" +(calendar.get(Calendar.MONTH)+1)+ "/" + calendar.get(Calendar.YEAR));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
