package com.pluralsight.workbookone;

public class ForLoop {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 10; i >= 1; i--) {
            System.out.println(i + ":- I love Java");
            Thread.sleep(1000);
        }
        System.out.println("Lunch");
    }
}
