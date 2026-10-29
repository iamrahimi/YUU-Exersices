package com.pluralsight.searchInventoryMap;

import java.io.BufferedReader;
import java.io.FileReader;

public class SearchInventoryMap {
    public static void main(String[] args) {
        getInventory();
    }


    public static void getInventory() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("uploads/inventory.csv"));
            String line;

        }catch (Exception e) {
            System.out.println("Error opening file");
        }

    }
}
