package menu;

import model.Employee;
import service.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployeeMenu {
    private Employee employee = new Employee();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final ProductService productService = new ProductService();
    private final InitialMenu initialMenu = new InitialMenu();

    public void displayMenu() {
        System.out.println("Choose: " +
                "\n 1. To view current product list" +
                "\n 2. To add new product." +
                "\n 3. To delete product using iD" +
                "\n 4. To modify product using iD" +
                "\n 5. To exit");
        try {
            int choice = Integer.parseInt(reader.readLine());
            switch (choice){
                case 1:
                    productService.findAllProducts();
                case 2:
                    productService.addProduct();
                case 3:
//                    productService.deleteProduct(); fix!!!!
                case 4:
//                    productService.updateProduct(); fix!!!!
                case 5:
                    System.out.println("Do you want to continue? (Y/N)");
                    String quit=reader.readLine();
                    quit = quit.toUpperCase();
                    if (quit.equals("Y")){
                       initialMenu.displayMenu();
                    } else {
                        displayMenu();
                    }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
