
import dao.CustomerDao;
import model.Customer;
import model.Products;
import service.CustomerService;
import service.ProductService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        productService.deleteProduct(productService.findProductById(81));
    }
}