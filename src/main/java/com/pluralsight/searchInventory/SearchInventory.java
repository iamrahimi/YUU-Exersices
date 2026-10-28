package com.pluralsight.searchInventory;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchInventory {
    static ArrayList<Products> inventory = new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        getProductsFromCsvFile();
        appHome();


    }

    public static void appHome () {
        System.out.println("-----------------------------------------");
        System.out.println("Welcome to Search Inventory");
        System.out.println("""
                What do you want to do?
                1- List all products
                2- Lookup a product by its id
                3- Find all products within a price range
                4- Add a new product
                5- Quit the application
                """);
        System.out.println("Enter command:");


        try {
            int command = input.nextInt();
            input.nextLine();

            if (command == 1) {
                // displaying all products.
                displayProducts();

            } if (command == 2) {
                // Filter product by it id
                System.out.println("Please enter the product id:");
               int index = input.nextInt(); input.nextLine();
                Products p =  inventory.get(index);
                System.out.printf("id: %d %s - Price: $%.2f%n",
                        p.getId(), p.getName(), p.getPrice());

            } if (command == 3) {
                // Filter product by price range
                filterProductByPriceRange();

            } else if (command == 4) {
                // Add product to the file
               addSingleProduct();

            }else if (command == 5) {
                System.out.println("Thank you for using Search Inventory");
                System.out.println("Goodbye!");
            }


            if(command == 1 || command == 2 || command == 3 || command == 4 ){
                appHome();
            }

        }catch(InputMismatchException e){
            System.out.println("Invalid input");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void displayProducts() {

        ArrayList<Products> inventoryData = getInventory();
        inventoryData.sort((product1, product2) ->
                product1.getName().compareTo(product2.getName()));

//        addProduct(); // Adding 5 product to the array

        for(int i = 0; i < inventoryData.size(); i++) {
            Products p = inventoryData.get(i);
            System.out.printf("id: %d %s - Price: $%.2f%n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    public static ArrayList<Products> getInventory() {
        getProductsFromCsvFile();
        return inventory;
    }

    public static void getProductsFromCsvFile() {
        inventory.clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader("uploads/inventory.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\\|");
                inventory.add(new Products(Integer.parseInt(values[0]), values[1], Float.parseFloat(values[2])));
            }
            System.out.println("Product Exported successfully");
        }catch (Exception e){
            System.out.println("Error reading inventory.csv");
        }

    }

    public static void addProduct() {

        inventory.add(new Products(1, "Apple", 1.00f));
        inventory.add(new Products(2, "Banana", 0.75f));
        inventory.add(new Products(3, "Milk", 3.50f));
        inventory.add(new Products(4, "Bread", 2.99f));
        inventory.add(new Products(5, "Eggs", 4.25f));
        System.out.println("Added products to inventory");

    }

    public static void addSingleProduct() throws IOException {
        System.out.println("Please enter the product id:");
        int index = input.nextInt(); input.nextLine();
        System.out.println("Please enter the product name:");
        String name = input.nextLine();
        System.out.println("Please enter the product price:");
        float price = input.nextFloat();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("uploads/inventory.csv", true));
            bw.newLine();
            bw.write(index + "|" + name + "|" + price );
            bw.close();

        }catch (Exception e){
            System.out.println("Error reading inventory.csv");
        }

    }

    public static void filterProductByPriceRange() {
        System.out.println("Please enter the price range start: ");
        float startPrice = input.nextFloat(); input.nextLine();
        System.out.println("Please enter the price range end: ");
        float endPrice = input.nextFloat(); input.nextLine();

        for(Products p : inventory){
            if(p.getPrice()>=startPrice&&p.getPrice()<=endPrice){
                System.out.printf("id: %d %s - Price: $%.2f%n",
                        p.getId(), p.getName(), p.getPrice());
            }
        }
    }
}
