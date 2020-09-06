package service;

import dao.ProductDao;
import menu.EmployeeMenu;
import menu.InitialMenu;
import model.ENUM_TYPE_OF_PRODUCT;
import model.Products;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import utils.HibernateSessionFactoryUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ProductService {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private EmployeeMenu employeeMenu;
    private InitialMenu initialMenu;
    private final ProductDao productDao = new ProductDao();

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
            System.out.println("Select type of products arrived: \n PROTEIN \n CREATIN \n BCAA");
            String type = reader.readLine();
            ProductDao productDao = new ProductDao();
            Products products = new Products(name, weight, price, items, ENUM_TYPE_OF_PRODUCT.valueOf(type));
            productDao.save(products);
            System.out.println("Product added to database");

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // working

    public void deleteProduct(Products product) {
        productDao.delete(product);
    } // working

    public void findAllProducts() {
        productDao.findAll();
    } // working

    public void addProduct() throws IOException {
        StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure().build();

        try {
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

    public void addProduct(Products newProduct) throws IOException {
        StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure().build();
        productDao.save(newProduct);
        System.out.println("Product added:");

    }

    public void updateProduct() throws IOException {
        System.out.println("Please insert iD what you want to update");
        int iD = Integer.parseInt(reader.readLine());
        Products productWeHave = findProduct(iD);
        System.out.println(productWeHave);
        System.out.println("_______________________________ + \nNew Product Name");
        String name = reader.readLine();
        System.out.println("New Product Weight");
        int weight = Integer.parseInt(reader.readLine());
        System.out.println("New Product Price");
        double price = Double.parseDouble(reader.readLine());
        System.out.println("New Amount of items");
        int items = Integer.parseInt(reader.readLine());
        System.out.println("New type of product: \n PROTEIN \n CREATIN \n BCAA");
        String type = reader.readLine();
        Products newProduct = new Products(name, weight, price, items, ENUM_TYPE_OF_PRODUCT.valueOf(type));
        productDao.delete(productWeHave);
        addProduct(newProduct);
    }

    public void findByType(ENUM_TYPE_OF_PRODUCT type_of_product) {
        productDao.findByType(type_of_product);
        //   continueChoice();
    }

    public void findById(int id) {
        productDao.findById(id);
    }

    public void addItemToBasket() throws IOException {
        System.out.println("Insert iD of an item you want to add to your basket");
        int id = Integer.parseInt(reader.readLine());
        Products productWeHave = findProduct(id);
       Products updatedProduct =  new Products(productWeHave.getProductName(),productWeHave.getWeight(),
                productWeHave.getPrice(), productWeHave.getAvailableItemsInStore()-1,productWeHave.getType());
       productDao.delete(productWeHave);
       addProduct(updatedProduct);
    }

    public void updateProduct(Products product) {
        productDao.update(product);
    } // fix

}



