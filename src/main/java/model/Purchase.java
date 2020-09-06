package model;

import model.ENUM_TYPE_OF_PRODUCT;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


@Entity(name = "STORE_SELLS")
public class Purchase {

    @GeneratedValue
    private Integer sellId;

    @Column(nullable = false)
    private String Customer_Name;
    @Column(nullable = true)
    private String phone;
    @Column(nullable = false)
    private String email;
    @Column
    private String address;
    @Column
    private int item_Purchased;
    @Column
    private ENUM_TYPE_OF_PRODUCT type_of_product;
    @Column
    private int product_iD;

    public Integer getSellId() {
        return sellId;
    }

    public void setSellId(Integer sellId) {
        this.sellId = sellId;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getItem_Purchased() {
        return item_Purchased;
    }

    public void setItem_Purchased(int item_Purchased) {
        this.item_Purchased = item_Purchased;
    }

    public ENUM_TYPE_OF_PRODUCT getType_of_product() {
        return type_of_product;
    }

    public void setType_of_product(ENUM_TYPE_OF_PRODUCT type_of_product) {
        this.type_of_product = type_of_product;
    }

    public int getProduct_iD() {
        return product_iD;
    }

    public void setProduct_iD(int product_iD) {
        this.product_iD = product_iD;
    }
}
