package menu;

import model.ENUM_TYPE_OF_PRODUCT;
import service.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerMenu {
    private final ProductService productService = new ProductService();
    private final static BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    private InitialMenu initialMenu;

    public void displayMenu() {
        System.out.println("1 to display all available items");
        System.out.println("2 for PROTEIN");
        System.out.println("3 for BCAA");
        System.out.println("4 for CREATIN");
        System.out.println("0 to EXIT");
        productsMenuByChoice();
    }

    public void productsMenuByChoice() {
        int option = 0;
        try {
            option = Integer.parseInt(scanner.readLine());
            String product;
            switch (option) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    productService.findAllProducts();
                    choice();
                    break;
                case 2:
                    product = "PROTEIN";
                    productService.findByType(ENUM_TYPE_OF_PRODUCT.valueOf(product));
                    choice();
                    break;
                case 3:
                    product = "BCAA";
                    productService.findByType(ENUM_TYPE_OF_PRODUCT.valueOf(product));
                    choice();
                    break;
                case 4:
                    product = "CREATIN";
                    productService.findByType(ENUM_TYPE_OF_PRODUCT.valueOf(product));
                    choice();
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
            }
            if (option == 1) {
                productService.findAllProducts();
                productService.addItemToBasket();
                continueChoice();
            } else {
                option = Integer.parseInt(scanner.readLine());
                System.out.println("\n\tPress 0 to get back into Customer Menu: +" +
                        "\n\tPress 1 to purchase an Item: ");
                if (option == 1) {
                    productService.findAllProducts();
                    productService.addItemToBasket();
                    continueChoice();
                } else {
                    System.out.println("Please check your input.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void continueChoice() {
        try {
            System.out.println("Do you want to continue? (Y/N)");
            String quit = scanner.readLine();
            quit = quit.toUpperCase();
            if (quit.equals("Y")) {
                displayMenu();
            } else {
                initialMenu.displayMenu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
