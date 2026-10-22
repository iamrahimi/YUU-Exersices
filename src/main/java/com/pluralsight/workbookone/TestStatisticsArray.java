package com.pluralsight.workbookone;

import java.util.Arrays;

public class TestStatisticsArray {

    public static void main(String[] args) {
        int[] scores = {85, 90, 78, 92, 88, 76, 95, 89, 84, 91};

        int total = 0;
        int highScore = scores[0];
        int lowScore = scores[0];

        for (int i = 1; i < scores.length; i++) {
            total += scores[i];

            if (scores[i] > highScore) {
                highScore = scores[i];
            }

            if (scores[i] < lowScore) {
                lowScore = scores[i];
            }
        }

        double average = (double) total / scores.length;

        int[] sortedScores = scores.clone();
        Arrays.sort(sortedScores);

        int middle = sortedScores.length / 2;
        double median = (sortedScores[middle - 1] + sortedScores[middle]) / 2.0;

        System.out.println("===== TEST STATISTICS =====");
        System.out.printf("Average:    %.2f%n", average);
        System.out.println("High Score: " + highScore);
        System.out.println("Low Score:  " + lowScore);
        System.out.printf("Median:     %.2f%n", median);
    }
}
