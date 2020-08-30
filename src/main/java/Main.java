import model.ENUM_TYPE_OF_PRODUCT;
import model.Products;
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

        try(SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            Products product1 = new Products();
            product1.setProductName("ProActive Whey INSTANT + Vitamin Supreme");
            product1.setPrice(32.41);
            product1.setWeight(700);
            product1.setAvailableItemsInStore(10);
            product1.setType(ENUM_TYPE_OF_PRODUCT.PROTEIN);
            session.save(product1);

            Products product2 = new Products();
            product2.setProductName("Universal Storm");
            product2.setPrice(119.35);
            product2.setWeight(756);
            product2.setAvailableItemsInStore(10);
            product2.setType(ENUM_TYPE_OF_PRODUCT.CREATIN);
            session.save(product2);

            Products product3 = new Products();
            product3.setProductName("7 Nutrition Bcaa Master");
            product3.setPrice(58.8);
            product3.setWeight(500);
            product3.setAvailableItemsInStore(10);
            product3.setType(ENUM_TYPE_OF_PRODUCT.BCAA);
            session.save(product3);


            Products product4 = new Products();
            product4.setProductName("Bio Tech Iso Whey Zero");
            product4.setPrice(184.26);
            product4.setWeight(2270);
            product4.setAvailableItemsInStore(10);
            product4.setType(ENUM_TYPE_OF_PRODUCT.PROTEIN);
            session.save(product4);

            Products product5 = new Products();
            product5.setProductName("PVL Mutant CreaKong ");
            product5.setPrice(32.4);
            product5.setWeight(300);
            product5.setAvailableItemsInStore(10);
            product5.setType(ENUM_TYPE_OF_PRODUCT.CREATIN);
            session.save(product5);

            Products product6 = new Products();
            product6.setProductName("Mr.Big - bcaa powder pure");
            product6.setPrice(55.5);
            product6.setWeight(250);
            product6.setAvailableItemsInStore(10);
            product6.setType(ENUM_TYPE_OF_PRODUCT.BCAA);
            session.save(product6);

            Products product7 = new Products();
            product7.setProductName("Real Pharm Real Isolate 100");
            product7.setPrice(175);
            product7.setWeight(1800);
            product7.setAvailableItemsInStore(10);
            product7.setType(ENUM_TYPE_OF_PRODUCT.PROTEIN);
            session.save(product7);

            Products product8 = new Products();
            product8.setProductName("Real Pharm Creatine");
            product8.setPrice(36.5);
            product8.setWeight(300);
            product8.setAvailableItemsInStore(10);
            product8.setType(ENUM_TYPE_OF_PRODUCT.CREATIN);
            session.save(product8);

            Products product9 = new Products();
            product9.setProductName("Real Pharm BCAA 8:1:1 Instant");
            product9.setPrice(52.41);
            product9.setWeight(400);
            product9.setAvailableItemsInStore(10);
            product9.setType(ENUM_TYPE_OF_PRODUCT.BCAA);
            session.save(product9);

            Products product10 = new Products();
            product10.setProductName("Real Pharm Real Whey 100");
            product10.setPrice(137.96);
            product10.setWeight(2000);
            product10.setAvailableItemsInStore(10);
            product10.setType(ENUM_TYPE_OF_PRODUCT.PROTEIN);
            session.save(product10);

            Products product11 = new Products();
            product11.setProductName("Real Pharm Crea-HCL");
            product11.setPrice(63.89);
            product11.setWeight(250);
            product11.setAvailableItemsInStore(10);
            product11.setType(ENUM_TYPE_OF_PRODUCT.CREATIN);
            session.save(product11);

            Products product12 = new Products();
            product12.setProductName("Real Pharm Amino Rest");
            product12.setPrice(82.41);
            product12.setWeight(500);
            product12.setAvailableItemsInStore(10);
            product12.setType(ENUM_TYPE_OF_PRODUCT.BCAA);
            session.save(product12);


            Products product13 = new Products();
            product13.setProductName("ESN Iso Whey Hardcore Big Pack");
            product13.setPrice(217.59);
            product13.setWeight(2500);
            product13.setAvailableItemsInStore(10);
            product13.setType(ENUM_TYPE_OF_PRODUCT.PROTEIN);
            session.save(product13);

            Products product14 = new Products();
            product14.setProductName("Ostrovit TCM");
            product14.setPrice(30);
            product14.setWeight(500);
            product14.setAvailableItemsInStore(10);
            product14.setType(ENUM_TYPE_OF_PRODUCT.CREATIN);
            session.save(product14);

            Products product15 = new Products();
            product15.setProductName("Activlab BCAA X-tra INSTANT");
            product15.setPrice(46.20);
            product15.setWeight(500);
            product15.setAvailableItemsInStore(10);
            product15.setType(ENUM_TYPE_OF_PRODUCT.BCAA);
            session.save(product15);


            transaction.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}