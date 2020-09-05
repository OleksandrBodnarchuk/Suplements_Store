package menu;

import model.Employee;
import service.CustomerService;
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
                "\n 1. To view current product list." +
                "\n 2. To add new product." +
                "\n 3. To add new client." +
                "\n 4. To delete product using iD." +
                "\n 5. To modify product using iD." +
                "\n 6. To exit.");
        try {
            int choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1:
                    productService.findAllProducts();
                    break;
                case 2:
                    productService.addProduct();
                    break;
                case 3:
                    CustomerService customerService = new CustomerService();
                    customerService.addCustomer();
                    break;
                case 4:
                    System.out.println("Please enter iD of the product you want to delete: \n");
                    int iD = Integer.parseInt(reader.readLine());
                    productService.deleteProduct(productService.findProduct(iD));
                    break;
                case 5:
//                    productService.updateProduct(); fix!!!!
                    break;
                case 6:
                    System.out.println("Do you want to continue? (Y/N)");
                    String quit = reader.readLine();
                    quit = quit.toUpperCase();
                    if (quit.equals("Y")) {
                        displayMenu();
                    } else {
                        initialMenu.displayMenu();
                    }
                    break;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
