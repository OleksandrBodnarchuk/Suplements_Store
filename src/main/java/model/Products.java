package model;

import javax.persistence.Entity;
import java.util.Set;

@Entity(name = "PRODUCTS")

public class Products {

//private ENUM_TYPE_OF_PRODUCT type; // protein, bcaa
    private String name;


    private Set<Products> products;

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
}
