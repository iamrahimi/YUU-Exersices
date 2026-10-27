package com.pluralsight.videogames;

import java.io.*;
import java.text.Format;

public class VideoGamesApplication {
    public static void main(String[] args) throws FileNotFoundException {
        VideoGame[] vg = new VideoGame[20];
       try {
           FileReader fr = new FileReader("uploads/videoGames/videogames.csv");
           BufferedReader br = new BufferedReader(fr);
           String line;
           line = br.readLine();
           int numberGames = 0;
//           The total number of games loaded
////               The average rating (rounded to 2 decimals is fine)
        float averageRating = 0;
////               The oldest release year
        int oldestReleasYear = 2026;
////               The number of PC titles
        int numberOFPCtitle = 0;
           while ((line = br.readLine()) != null) {
               String[] values = line.split(",");
               if(values.length == 5){
                   averageRating += Float.parseFloat(values[4]);

                   if(oldestReleasYear > Integer.parseInt(values[3])){
                       oldestReleasYear = Integer.parseInt(values[3]);
                   }

                   if(values[1].equalsIgnoreCase("PC")) numberOFPCtitle++;

                   VideoGame vg1 = new VideoGame(values[0], values[1], values[2], Integer.parseInt(values[3]), Float.parseFloat(values[4]));
               }else {
                   System.out.println("Warning: date is missing");
               }

               numberGames ++;

           }

           System.out.println("Number of games: " + numberGames);
           System.out.printf("Average rating:%.2f%n", (averageRating / numberGames));
           System.out.println("Oldest release year: " + oldestReleasYear);
           System.out.println("Number of PC titles: " + numberOFPCtitle);

       }catch (FileNotFoundException e){
           System.out.println(e.getMessage());
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}
