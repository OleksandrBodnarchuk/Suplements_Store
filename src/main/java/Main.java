
import dao.CustomerDao;
import dao.ProductDao;
import model.Customer;
import model.Products;
import service.CustomerService;
import service.ProductService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
       ProductService service = new ProductService();
       service.findAllProducts();

    }
}