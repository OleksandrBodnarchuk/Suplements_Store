package dao;

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

    public void delete(Products product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
        session.close();
    }

    public Products findProductById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Products.class, id);
    }

    public List<Products> findAll() {
        return (List<Products>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from products").list();
    }
}

