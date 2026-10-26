package com.pluralsight.famousQuotes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class famousQuotes {
    public static Scanner input = new Scanner(System.in);
    public static String[] quotes;
    public static void main(String[] args) {

        quotes = new String[] {
                "Keep learning.",
                "Small steps lead to big changes.",
                "Believe in your ability to grow.",
                "Every day is a new chance.",
                "Practice makes progress.",
                "Be kind to yourself.",
                "Mistakes help you learn.",
                "Stay curious.",
                "You can do hard things.",
                "Keep moving forward."
        };

        int choice = 0;

        try {
            System.out.println("please enter your choice: ");
            System.out.println("1:- See your favorite quote ");
            System.out.println("2:- See random quote ");
            choice = input.nextInt();
            boolean done = true;
            if (choice == 1) {
                displayQuotes();

            } else if (choice == 2) {
                int rendomNumber = (int) (Math.random() * 10) + 1;
                System.out.println(quotes[rendomNumber]);
                confirmationCheck();
            }
        } catch (Exception e) {
            System.out.println("invalid choice");
        }
    }

    public static void displayQuotes() {

        System.out.println("Please enter number between 1 and 10: ");
        try {
            int inputNumber = input.nextInt();
            System.out.println("----------------------------------");
            System.out.println(quotes[inputNumber]);
            System.out.println("-----------------------------------");
        }catch (Exception e){
            System.out.println("Invalid input");
        }

        confirmationCheck();
    }

    public static void confirmationCheck () {
        System.out.println("------------------------------------------------------------");
        System.out.println("Please enter Yes if you want see another quotes or X to quit");
        input.nextLine();
        String userChoice = input.nextLine();
        if (userChoice.equalsIgnoreCase("yes") || userChoice.equalsIgnoreCase("Y")) {
           displayQuotes();
        }else {
            System.out.println("Thanks for using our quotes");
        }
    }
}
