

import service.ProductService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ProductService productService = new ProductService();
        productService.addProduct();
    }
}