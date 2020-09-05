package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

@Entity(name = "PRODUCTS")

public class Products {

    @GeneratedValue
    private Long iD;
    @Column
    private String ProductName;
    @Column
    private int weight;
    @Column
    private double price;
    @Column
    private int availableItemsInStore;
    @Id
    @Column
    private ENUM_TYPE_OF_PRODUCT type;

    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
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





}
