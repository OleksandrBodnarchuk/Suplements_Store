package model;

import javax.persistence.*;

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

    @Override
    public String toString() {
        return "Index for purchase: " + iD +
                "\t\t\n" + "Name: " + ProductName +
                "\t\t\n" + "Weight: " + weight +
                "\t\t\n" + "Price: " + price +
                "\t\t\n" + "Type: " + type +
                "\t\t\n" + "Available: " + availableItemsInStore
                + "\n"+"|------------------------------------|";
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
    public Products(Products products) {
    }
    public Products(int iD, Products products) {
    }
}
