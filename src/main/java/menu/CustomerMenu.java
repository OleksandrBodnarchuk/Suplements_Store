package menu;

import model.ENUM_TYPE_OF_PRODUCT;
import service.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CustomerMenu {
    private final ProductService productService = new ProductService();
    private final static BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    public void displayMenu() {
        System.out.println("0 to display all available items");
        System.out.println("1 for PROTEIN");
        System.out.println("2 for BCAA");
        System.out.println("3 for CREATIN");
        System.out.println("4 to EXIT");
        productsMenuByChoice();
    }

    public void productsMenuByChoice() {
        int option = 0;
        try {
            option = Integer.parseInt(scanner.readLine());
            String product;
            switch (option) {
                case 0:
                    productService.findAllProducts();
                    choice();
                    break;
                case 1:
                    product = "PROTEIN";
                    productService.findByType(ENUM_TYPE_OF_PRODUCT.valueOf(product));
                    choice();
                    break;
                case 2:
                    product = "BCAA";
                    productService.findByType(ENUM_TYPE_OF_PRODUCT.valueOf(product));
                    choice();
                    break;
                case 3:
                    product = "CREATIN";
                    productService.findByType(ENUM_TYPE_OF_PRODUCT.valueOf(product));
                    choice();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void choice() {
        try {
            System.out.println("\n\tPress 0 to get back into Customer Menu: " +
                    "\n\tPress 1 to purchase an Item: ");
            int option = Integer.parseInt(scanner.readLine());
            if (option == 0) {
                displayMenu();
            } else {
                System.out.println("Please check your input.");
                option = Integer.parseInt(scanner.readLine());
                System.out.println("\n\tPress 0 to get back into Customer Menu: +" +
                        "\n\tPress 1 to purchase an Item: ");
                if (option == 0) {
                    displayMenu();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
