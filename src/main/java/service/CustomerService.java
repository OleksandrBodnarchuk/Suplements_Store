package service;

import dao.CustomerDao;
import model.Customer;
import model.Products;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CustomerService {
    private Products product = new Products();
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

    public void addCustomer() throws IOException {
        StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure().build();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Full name");
            String name = reader.readLine();
            System.out.println("Email");
            String email = reader.readLine();
            System.out.println("Address");
            String address = reader.readLine();
            CustomerDao customerDao = new CustomerDao();
            Customer customer = new Customer(name, email, address);
            customerDao.save(customer);

        } catch (Exception e) {
            e.printStackTrace();
        }

    } // working

}

