package service;

import dao.CustomerDao;
import model.Customer;

import java.io.IOException;
import java.util.List;

public class customerService {
    private CustomerDao customerDao = new CustomerDao();


    public Customer findCustomer(int id) {
        return customerDao.findById(id);
    }

    public void saveCustomer(Customer customer) throws IOException {
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

