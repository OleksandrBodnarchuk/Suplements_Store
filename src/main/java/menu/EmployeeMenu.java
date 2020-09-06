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
    private final CustomerService customerService = new CustomerService();
    private final InitialMenu initialMenu = new InitialMenu();

    public void displayMenu() {
        System.out.println("Choose: " +
                "\n 1. To view current product list." +
                "\n 2. To add new product." +
                "\n 3. To add new client." +
                "\n 4. To delete product using iD." +
                "\n 5. To delete customer usind iD" +
                "\n 6. To modify product using iD." +
                "\n 0. To exit.");
        try {
            int choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 0:
                    try {
                        System.out.println("Do you want to Exit? (Y/N)");
                        String quit = reader.readLine();
                        quit = quit.toUpperCase();
                        if (quit.equals("Y")) {
                            initialMenu.displayMenu();
                        } else {
                            displayMenu();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    System.out.println("HERE LIST OF ALL PRODUCTS IN DATABASE");
                    productService.findAllProducts();
                    choice();
                    break;
                case 2:
                    System.out.println("YOU ARE ADDING NEW PRODUCT TO DATABASE");
                    productService.addProduct();
                    break;
                case 3:
                    System.out.println("YOU ARE ADDING NEW CUSTOMER TO DATABASE");
                    customerService.addCustomer();
                    continueChoice();
                    break;
                case 4:
                    System.out.println("Please enter iD of the product you want to delete: \n");
                    int iD = Integer.parseInt(reader.readLine());
                    productService.deleteProduct(productService.findProduct(iD));
                    continueChoice();
                    break;
                case 5:
                    System.out.println("Please enter iD of the customer you want to delete: \n");
                    int custID = Integer.parseInt(reader.readLine());
                    customerService.deleteCustomer(customerService.findCustomerByiD(custID));
                    continueChoice();
                    break;
                case 6:
                    productService.updateProduct();
                    continueChoice();
                    break;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void choice() {

        System.out.println("\n\t Press 1 to select option: \n\t Press 0 to get back into Employee Menu: ");
        secondaryChoice();
    }

    private void continueChoice() {
        try {
            System.out.println("Do you want to continue? (Y/N)");
            String quit = reader.readLine();
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

    private void secondaryChoice() {
        try {
            int choice = Integer.parseInt(reader.readLine());
            if (choice == 0) {
                displayMenu();
            }
            if (choice == 1) {
                System.out.println("Choose: " +
                        "\n 1. To view current product list again." +
                        "\n 2. To add new product." +
                        "\n 3. To delete product using iD." +
                        "\n 4. To modify product using iD." +
                        "\n 0. To exit.");
                try {
                    choice = Integer.parseInt(reader.readLine());
                    switch (choice) {
                        case 0:
                            try {
                                System.out.println("Do you want to Exit? (Y/N)");
                                String quit = reader.readLine();
                                quit = quit.toUpperCase();
                                if (quit.equals("Y")) {
                                    displayMenu();
                                } else {
                                    initialMenu.displayMenu();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 1:
                            System.out.println("HERE LIST OF ALL PRODUCTS IN DATABASE");
                            productService.findAllProducts();
                            choice();
                            break;
                        case 2:
                            System.out.println("YOU ARE ADDING NEW PRODUCT TO DATABASE");
                            productService.addProduct();
                            break;
                        case 3:
                            System.out.println("Please enter iD of the product you want to delete: \n");
                            int iD = Integer.parseInt(reader.readLine());
                            productService.deleteProduct(productService.findProduct(iD));
                            continueChoice();
                            break;
                        case 4:
                            System.out.println("Please enter iD of the customer you want to modify: \n");
//                    productService.updateProduct(); fix!!!!
                            break;
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Check your input");
                choice();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
