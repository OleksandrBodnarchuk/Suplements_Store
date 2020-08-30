package service;

import dao.CustomerDao;
import dao.ProductDao;
import model.Customer;
import model.Products;

import java.util.List;

public class customerService {
    private CustomerDao customerDao = new CustomerDao();


    public Customer findCustomer(int id) {
        return customerDao.findById(id);
    }

    public void saveCustomer(Customer customer) {
        customerDao.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerDao.delete(customer);
    }

    public void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerDao.findAll();
    }

    public Customer findCustomerByiD(int id) {
        return customerDao.findById(id);
    }
}

