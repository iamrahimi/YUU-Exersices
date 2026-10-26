package com.pluralsight.neighborhoodLibrary;

import java.util.Scanner;

public class NeighborhoodLibrary {
    private static final Scanner input = new Scanner(System.in);
    private static Book[] books;
    public static void main(String[] args) {

         books = new Book[] {
                 new Book(1, "978-0134685991", "Effective Java", true, "Alice Johnson"),
                 new Book(2, "978-0596009205", "Head First Java", false, null),
                 new Book(3, "978-0132350884", "Clean Code", true, "Bob Smith"),
                 new Book(4, "978-0201633610", "Design Patterns", false, null),
                 new Book(5, "978-1491950357", "Java: The Complete Reference", true, "Carol White"),
                 new Book(6, "978-1617294945", "Spring in Action", false, null),
                 new Book(7, "978-0134494166", "Core Java Volume I", true, "David Brown"),
                 new Book(8, "978-1118584194", "Java Concurrency in Practice", false, null),
                 new Book(9, "978-0321356680", "JUnit in Action", true, "Emily Davis"),
                 new Book(10, "978-1449373320", "Learning Python", false, null),
         };

        homePage();
    }

    public static void homePage()
    {
        System.out.println("Welcome to library application");
        String options = """
                Please choose an option:
                1:- Show Available Books
                2:- Show Checked Out Books
                3:- Exit - closes out of the application
                """;
        System.out.println(options);
        int choice = input.nextInt();

        switch (choice)
        {
            case 1:
                showAvailableBooks();
                break;
            case 2:
                showCheckOutBooks();
                break;
            default:
                System.out.println("Invalid option");
        }

    }

    public static void showAvailableBooks() {
        header();
        boolean foundBook = false;

        for(Book book : books){
            if(book != null && !book.isCheckedOut()){
                System.out.println(book.toString());
                foundBook = true;
            }
        }

        if (!foundBook) {
            System.out.println("There are no available books.");
            return;
        }
        footer();
        input.nextLine();
        System.out.print("\nEnter a book ID to check it out, or X to return home: ");
        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("X")) {
            homePage();
        } else if(Integer.parseInt(choice) > 0) {
            checkOutBook(Integer.parseInt(choice));
        } else {
            System.out.println("Invalid option");
        }

    }

    public static void checkOutBook(int bookID) {
        System.out.println("Please enter your name: ");
        String checkOutToName = input.nextLine();

        if(validateBookId(bookID)) {
            books[bookID - 1].setCheckedOut(true);
            books[bookID - 1].setCheckedOutTo(checkOutToName);
            System.out.println("Successfully checked out the book");
        }else {
            System.out.println("Invalid book ID");
        }

        homePage();
    }

    public static void showCheckOutBooks() {
        header();
        boolean foundBook = false;
        for(Book book : books){
            if(book != null && book.isCheckedOut()){
                System.out.println(book.toString());
                foundBook = true;
            }
        }
        if (!foundBook) {
            System.out.println("There are no available books.");
            return;
        }
        footer();
        input.nextLine();
        System.out.print("\nEnter a book ID to check in, or X to return home: ");
        String choice = input.nextLine();
        if (choice.equalsIgnoreCase("X")) {
            homePage();
        } else if(Integer.parseInt(choice) > 0) {
            checkInBook(Integer.parseInt(choice));
        } else {
            System.out.println("Invalid option");
        }
    }

    public static void checkInBook(int bookID) {

        if(validateBookId(bookID) ) {
            books[bookID - 1].setCheckedOut(false);
            books[bookID - 1].setCheckedOutTo(null);
            System.out.println("Successfully checked in the book");
        }else {
            System.out.println("Invalid book ID");
        }

        homePage();
    }

    private static boolean validateBookId(int bookID) {
        if(bookID > 0 ) {
            for (Book book : books) {
                if (book.getId() == bookID) {
                    return true;
                }

            }
        }
        return false;
    }

    public static void header() {
        System.out.println("===========================================================================");
        System.out.println("                    LIBRARY MANAGEMENT SYSTEM");
        System.out.println("===========================================================================");
        System.out.printf("%-5s %-19s %-40s%n ",
                "ID", "ISBN", "BOOK TITLE");
        System.out.println("---------------------------------------------------------------------------");
    }

    public static void footer () {
        System.out.println("============================================================================");
    }


}
