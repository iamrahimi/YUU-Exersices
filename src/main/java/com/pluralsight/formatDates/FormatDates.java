package com.pluralsight.formatDates;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDates {
    public static void main(String[] args) {


        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm", Locale.ENGLISH);
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate localDate = dateTime.toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");

        System.out.println(localDate.format(formatter));
        System.out.println(localDate);
        System.out.println(dateTime.format(formatter3));
        System.out.println(dateTime.format(formatter2));
    }
}
