package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {

        String sandwichSize;
        int customarAge;
        double customarTotalPrice = 0;
        double discountRate;
        Scanner input = new Scanner(System.in);
        System.out.println("Hello and welcome, to my sandwich shop!");
        System.out.println("Please select your sandwich from option below: \n" +
                            "a. 1: Regular: base price $5.45\n" +
                            "b. 2: Large: base price $8.95 \n");
        sandwichSize = input.nextLine();
        if(sandwichSize.equals("a") || sandwichSize.equals("regular") ){
            customarTotalPrice = 5.45;
        } else if (sandwichSize.equals("b") || sandwichSize.equals("larg")) {
            customarTotalPrice = 8.95;
        } else {
            System.out.println("Invalid sandwich size!");
        }


        System.out.println("We have some discount for certain age\n" +
                "a. Student (17 years old or younger) – receive a 10% discount\n" +
                "b. Seniors (65 years old or older) – receive a 20% discount\n" +
                "c. Everyone else won't receive a discount \n " +
                "Please enter your age?");
        customarAge = input.nextInt();

        if(customarAge > 17 || customarAge < 30){
            customarTotalPrice *= 0.90;
        } else if (customarAge > 65) {
            customarTotalPrice *= 0.80;
        }

        System.out.println("Your total is: " + customarTotalPrice);





    }
}
