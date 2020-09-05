package menu;

import model.ENUM_TYPE_OF_PRODUCT;
import service.ProductService;

import java.util.Scanner;

public class SecondaryMenu {
    private final ProductService productService = new ProductService();

    public void displayMenu() {
        System.out.println("0 to display all available items");
        System.out.println("1 for PROTEIN");
        System.out.println("2 for BCAA");
        System.out.println("3 for CREATIN");
        System.out.println("4 to EXIT");
        productsMenuByChoice();
    }

    public void productsMenuByChoice() {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        String product;
        switch (option) {
            case 0:
                productService.findAllProducts();
                break;
            case 1:
                product = "PROTEIN";
                productService.findByType(ENUM_TYPE_OF_PRODUCT.valueOf(product));
                break;
            case 2:
                product = "BCAA";
                productService.findByType(ENUM_TYPE_OF_PRODUCT.valueOf(product));
                break;
            case 3:
                product = "CREATIN";
                productService.findByType(ENUM_TYPE_OF_PRODUCT.valueOf(product));
                break;
            case 4:
                System.out.println("Exiting...");
                break;
        }
    }
}
