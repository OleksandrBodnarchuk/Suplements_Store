import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        final StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            Products product1 = new Products();
            product1.setProductName("Real Pharm Real Whey 100");
            product1.setPrice(137.96);
            product1.setWeight(2000);
            product1.setAvailableItemsInStore(10);
            product1.setType(ENUM_TYPE_OF_PRODUCT.PROTEIN);
            session.save(product1);

            Products product2 = new Products();
            product2.setProductName("Real Pharm Crea-HCL");
            product2.setPrice(63.89);
            product2.setWeight(250);
            product2.setAvailableItemsInStore(10);
            product2.setType(ENUM_TYPE_OF_PRODUCT.CREATIN);
            session.save(product2);

            Products product3 = new Products();
            product3.setProductName("Real Pharm Amino Rest");
            product3.setPrice(82.41);
            product3.setWeight(500);
            product3.setAvailableItemsInStore(10);
            product3.setType(ENUM_TYPE_OF_PRODUCT.BCAA);
            session.save(product3);


            transaction.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}