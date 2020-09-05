package model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "STORE_CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String fullName;
    @Column(nullable = true)
    private String phone;
    @Column(nullable = false)
    private String email;
    @Column
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
}

