package com.pluralsight.workbookone;

public class RollTheDice {
    public static void main(String[] args) {
        Dice dice = new Dice();
        int roll1;
        int roll2;
        int twoCounter = 0;
        int fourCounter = 0;
        int sixCounter = 0;
        int sevenCounter = 0;


        int i = 0;
        while (i <= 100) {
            roll1 = dice.roll();
            roll2 = dice.roll();
            System.out.println("Roll " + i + " : " + roll1 + " - " + roll2 + " Sum: " + (roll1 + roll2));
            if((roll1 + roll2) == 2 ){
                twoCounter += 1;
            }

            if((roll1 + roll2) == 4 ){
                fourCounter += 1;
            }

            if((roll1 + roll2) == 6 ){
                sixCounter += 1;
            }

            if((roll1 + roll2) == 7 ){
                sevenCounter += 1;
            }
            i++;
        }

        System.out.println("===============================");
        System.out.println("======== Counter Details ======");
        System.out.println("Count of 2: "+ twoCounter);
        System.out.println("Count of 4: "+ fourCounter);
        System.out.println("Count of 6: "+ sixCounter);
        System.out.println("Count of 7: "+ sevenCounter);
        System.out.println("================End Counter ==== ");
    }
}
