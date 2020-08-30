package service;

import dao.ProductDao;
import model.Customer;
import model.Products;

import java.util.List;

public class productService {
    private ProductDao productDao = new ProductDao();


    public Products findProduct(int id) {
        return productDao.findById(id);
    }

    public void saveUser(Products product) {
        productDao.save(product);
    }

    public void deleteUser(Products product) {
        productDao.delete(product);
    }

    public void updateUser(Products product) {
        productDao.update(product);
    }

    public List<Products> findAllProducts() {
        return productDao.findAll();
    }

    public Products findProductById(int id) {
        return productDao.findById(id);
    }
}


