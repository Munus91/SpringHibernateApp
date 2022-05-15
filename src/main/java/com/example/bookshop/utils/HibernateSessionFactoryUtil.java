package com.example.bookshop.utils;

import com.example.bookshop.entity.Author;
import com.example.bookshop.entity.Book;
import com.example.bookshop.entity.Genre;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * util class for initialization and configuring session factory
 */
public class HibernateSessionFactoryUtil {
    /**
     *
     */
    private static SessionFactory sessionFactory;

    /**
     *
     */
    private HibernateSessionFactoryUtil() {}

    /**
     *
     * @return
     */
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Book.class);
                configuration.addAnnotatedClass(Genre.class);
                configuration.addAnnotatedClass(Author.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            }catch(Exception e) {
                System.out.println("Exception ! :"+ e);
            }
        }
        return sessionFactory;
    }

}
