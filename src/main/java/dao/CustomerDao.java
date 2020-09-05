package dao;

import model.Customer;
import model.Products;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CustomerDao {
    public Customer findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Customer.class, id);
    }

    public void save(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(customer);
        tx1.commit();
        session.close();
    }

    public void update(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
    }

    public void delete(Customer customer) { // working
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(customer);
        transaction.commit();
        session.close();
    }

    public Customer findCustomerById(int id) { // working
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Customer.class, id);
    }

    public List<Customer> findAll() {
        return (List<Customer>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from customers").list();
    }
}
