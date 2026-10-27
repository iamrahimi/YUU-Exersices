package com.pluralsight.searchEngineLogger;

import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    private static String logName = "";
    public static void main(String[] args) {
        logger("Lunch");
        System.out.println("Welcome to SearchEngineLogger");
        Scanner input = new Scanner(System.in);

        boolean searching = true;
        while (searching) {
            System.out.println("Enter a search term (X or x to exit)");
            String keyword = input.nextLine();
            System.out.println("Look find the result ...");

            if (keyword.equalsIgnoreCase("X")) {
                logger("Exit");
                System.out.println("Good bye");
                searching = false;
            }else {
                logger("search: " + keyword);
            }
        }



    }

    public static void logger(String message) {
        LocalDateTime dateTime = LocalDateTime.now();
        if(logName.equals("")) {
           logName = String.valueOf(dateTime.getDayOfMonth() +""+ dateTime.getHour() +""+ dateTime.getMinute() +""+ dateTime.getSecond());
        }
        String timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateTime);
        try {
            String text = timeStamp + " " + message;
            FileWriter fWriter = new FileWriter("uploads/logs/logs-"+logName+".txt", true);
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            bWriter.write(text);
            bWriter.newLine();
            bWriter.close();

        }catch (Exception e) {
            System.out.println("Could not write to log file");
        }
    }
}
