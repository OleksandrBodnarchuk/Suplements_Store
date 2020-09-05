package service;

import dao.ProductDao;
import model.ENUM_TYPE_OF_PRODUCT;
import model.Products;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ProductService {
    private ProductDao productDao = new ProductDao();


    public Products findProduct(int id) {
        return productDao.findById(id);
    }

    public void saveProduct(Products product) {
        StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure().build();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Product Name: ");
            String name = reader.readLine();
            System.out.println("Product Weight");
            int weight = Integer.parseInt(reader.readLine());
            System.out.println("Product Price");
            double price = Double.parseDouble(reader.readLine());
            System.out.println("Amount of items");
            int items = Integer.parseInt(reader.readLine());
            System.out.println("Select type of products arrived: \nPROTEIN \n CREATIN \n BCAA");
            String type = reader.readLine();
            ProductDao productDao = new ProductDao();
            Products products = new Products(name, weight, price, items, ENUM_TYPE_OF_PRODUCT.valueOf(type));
            productDao.save(products);
            System.out.println("Product added to database");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(Products product) {
        productDao.delete(product);
    } // working

    public void updateProduct(Products product) {
        productDao.update(product);
    }

    public List findAllProducts() {
        return productDao.findAll();
    }

    public Products findProductById(int id) {
        return productDao.findById(id);
    }

    public void addProduct() throws IOException {
        StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure().build();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Product Name: ");
            String name = reader.readLine();
            System.out.println("Product Weight");
            int weight = Integer.parseInt(reader.readLine());
            System.out.println("Product Price");
            double price = Double.parseDouble(reader.readLine());
            System.out.println("Amount of items");
            int items = Integer.parseInt(reader.readLine());
            System.out.println("Select type of products arrived: \nPROTEIN \n CREATIN \n BCAA");
            String type = reader.readLine();
            ProductDao productDao = new ProductDao();
            Products products = new Products(name, weight, price, items, ENUM_TYPE_OF_PRODUCT.valueOf(type));
            productDao.save(products);
            System.out.println("Product added to database");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }     // working


    public void getAllProducts(){
        ProductDao productDao = new ProductDao();
        productDao.findAll();

    }
}


