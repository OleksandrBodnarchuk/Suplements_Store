package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity (name = "PROTEIN")
public class Protein {
    @Id
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

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

    public int getAvailableItemsInStore() {
        return availableItemsInStore;
    }

    public void setAvailableItemsInStore(int availableItemsInStore) {
        this.availableItemsInStore = availableItemsInStore;
    }
}
