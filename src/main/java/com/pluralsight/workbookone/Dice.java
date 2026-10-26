package com.pluralsight.workbookone;

public class Dice {

    public int roll() {
        int maxValue = 100;
        int minValue = 1;
        int randomNumber = (int)(Math.random() * (maxValue - minValue + 1)) + minValue;
        return randomNumber;
    }
}
