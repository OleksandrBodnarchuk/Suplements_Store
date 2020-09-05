package dao;

import model.ENUM_TYPE_OF_PRODUCT;
import model.Products;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ProductDao {

    public Products findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Products.class, id);
    }


    public void save(Products product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(product);
        tx1.commit();
        session.close();
    }

    public void update(Products product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(product);
        transaction.commit();
        session.close();
    }

    public void delete(Products product) { // working
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
        session.close();
    }

    public void findAll() {
        List<Products> products = (List<Products>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From STORE_PRODUCTS").list();
        int iterator = 1;
        for (Object o : products) {
            System.out.println(iterator + ". " + o);
            iterator++;
        }
    }

    public void findByType(ENUM_TYPE_OF_PRODUCT type) {
        List<Products> products = (List<Products>) HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("From STORE_PRODUCTS WHERE type = '" + type + "'").list();
        int iterator = 1;
        for (Object o : products) {
            System.out.println(iterator + ". " + o);
            iterator++;
        }
    }

}

