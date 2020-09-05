
import dao.CustomerDao;
import dao.ProductDao;
import model.Customer;
import model.ENUM_TYPE_OF_PRODUCT;
import model.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure().build();
        List<Products> users = null;
        try(SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();
            String hql = "FROM Products p ";
            Query query = session.createQuery(hql);
            users = query.list();
            int interator =1;
            System.out.println("Lista produktow");
            for (Products product: users) {
                System.out.println(interator+ ". " + product.getProductName());
                interator++;
            }
            transaction.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}