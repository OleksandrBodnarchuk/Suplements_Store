
import dao.CustomerDao;
import model.Customer;
import model.Products;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Products products = new Products();
        try {
            products.addProduct();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}