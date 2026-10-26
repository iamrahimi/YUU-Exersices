package com.pluralsight.bedtimeStories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class bedtimeStories {
    public static Scanner scanner = new Scanner(System.in);
    public static String[] books;
    public static void main(String[] args) {
        System.out.println("Welcome to my bedtime stories application!");

        books = new String[] {
                "goldilocks.txt",
                "hansel_and_gretel.txt",
                "mary_had_a_little_lamb.txt"
        };
       askUserChoice(books);

    }

    public static void askUserChoice(String[] books) {
        System.out.println("Please choose what file do you want to read:");
        System.out.println("1. Goldilocks");
        System.out.println("2. Hansel and Gretel");
        System.out.println("3. Mary had a little lamb");
        System.out.println("4. To quit the application");

        try {
            int userChoice = scanner.nextInt();
            scanner.nextLine();
            if (userChoice == 1) {
                readFile(books[0]);

            }  else if (userChoice == 2) {
                readFile(books[1]);

            } else if (userChoice == 3) {
                readFile(books[2]);
            } else if (userChoice == 4) {
                System.out.println("Thank you for using the application, Goodbye! ");
            }else  {
                System.out.println("Invalid choice.");
            }

        }catch (Exception e){
            System.out.println("Invalid choice.");
        }
    }

    public static void readFile(String book){

        try {
            FileReader fileReader = new FileReader(book);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input;
            while((input = bufferedReader.readLine()) != null) {
                System.out.println(input);
            }

        } catch (Exception e) {
            System.out.println("The file could not be opened/ Invalid file");
        }

        System.out.println("------------------------------------------------");
       askUserChoice(books);


    }
}
