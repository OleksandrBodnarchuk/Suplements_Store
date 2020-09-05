package model;

import dao.CustomerDao;
import dao.ProductDao;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Entity(name = "STORE_PRODUCTS")

public class Products {
    @Id
    @GeneratedValue
    private Integer iD;
    @Column
    private String ProductName;
    @Column
    private int weight;
    @Column
    private double price;
    @Column
    private int availableItemsInStore;

    @Column
    @Enumerated(value = EnumType.STRING)
    private ENUM_TYPE_OF_PRODUCT type;

    public Integer getiD() {
        return iD;
    }

    public void setiD(Integer iD) {
        this.iD = iD;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableItemsInStore() {
        return availableItemsInStore;
    }

    public void setAvailableItemsInStore(int availableItemsInStore) {
        this.availableItemsInStore = availableItemsInStore;
    }

    public ENUM_TYPE_OF_PRODUCT getType() {
        return type;
    }

    public void setType(ENUM_TYPE_OF_PRODUCT type) {
        this.type = type;
    }

    public Products() {
    }

    public Products(String productName, int weight, double price, int availableItemsInStore, ENUM_TYPE_OF_PRODUCT type) {
        ProductName = productName;
        this.weight = weight;
        this.price = price;
        this.availableItemsInStore = availableItemsInStore;
        this.type = type;
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
            Products products = new Products(name, weight, price, items,ENUM_TYPE_OF_PRODUCT.valueOf(type));
            productDao.save(products);
            System.out.println("Product added to database");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
