package model;

import menu.EmployeeMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Employee {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String login = "login";
    private String password = "password";

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void logIn(){
        System.out.println("Please enter your login: ");
        try {
            if (reader.readLine().equals(getLogin())){
                System.out.println("\nThank you, login is correct.\n___________________________________________");
                System.out.println("Please enter your password: ");
                if (reader.readLine().equals(getPassword())){
                    System.out.println("\nThank you, password is correct.\n___________________________________________");
                    EmployeeMenu employeeMenu = new EmployeeMenu();
                    employeeMenu.displayMenu();
                } else {
                    System.out.println("Password is not correct, closing session");
                }
            } else {
                System.out.println("Password is not correct, closing session");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
