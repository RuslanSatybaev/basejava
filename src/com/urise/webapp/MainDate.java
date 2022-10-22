package com.urise.webapp;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class MainDate {
    public static void main(String[] args) {
        System.out.println(new Date(1L));
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);

        SimpleDateFormat sdf = new SimpleDateFormat("yy:MM:dd, E,z");
        System.out.println(sdf.format(date));
    }
}
