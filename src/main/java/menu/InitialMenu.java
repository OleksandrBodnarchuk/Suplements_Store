package menu;

import model.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InitialMenu {
    private final CustomerMenu customerMenu = new CustomerMenu();
    private final Employee employee = new Employee();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public void displayMenu() {

        try {
            System.out.println("Please choose: \n\t1: If you want to purchase and item \n\t2: To log in as Employee");
            int choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1:
                    customerMenu.displayMenu();
                    break;
                case 2:
                    employee.logIn();
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
