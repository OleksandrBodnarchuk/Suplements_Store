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

            Products bcaa1 = new Products();
            bcaa1.setProductName("Real Pharm Amino Rest");
            bcaa1.setPrice(82.41);
            bcaa1.setWeight(500);
            bcaa1.setAvailableItemsInStore(10);
            bcaa1.setType(ENUM_TYPE_OF_PRODUCT.BCAA);
            session.save(bcaa1);


            transaction.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}