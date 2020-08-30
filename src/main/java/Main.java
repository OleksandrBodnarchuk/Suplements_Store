import model.BCAA;
import model.Creatin;
import model.Protein;
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

            Protein protein1 = new Protein();
            protein1.setProductName("Real Pharm Real Whey 100");
            protein1.setPrice(137.96);
            protein1.setWeight(2000);
            protein1.setAvailableItemsInStore(10);
            session.save(protein1);


            Creatin creatin1 = new Creatin();
            creatin1.setProductName("Real Pharm Crea-HCL");
            creatin1.setPrice(63.89);
            creatin1.setWeight(250);
            creatin1.setAvailableItemsInStore(10);
            session.save(creatin1);

            BCAA bcaa1 = new BCAA();
            bcaa1.setProductName("Real Pharm Amino Rest");
            bcaa1.setPrice(82.41);
            bcaa1.setWeight(500);
            bcaa1.setAvailableItemsInStore(10);
            session.save(bcaa1);

            transaction.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}