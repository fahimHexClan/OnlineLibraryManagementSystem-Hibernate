package Ijse.config;

import Ijse.Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure("Hibernate.xml")
                .addAnnotatedClass(AdminEntity.class).addAnnotatedClass(UserEntity.class)
                .addAnnotatedClass(BookEntity.class).addAnnotatedClass(LibraryBranchEntity.class)
                .addAnnotatedClass(TransactionEntity.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration =
                new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
