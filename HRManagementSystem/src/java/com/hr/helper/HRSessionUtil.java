/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.helper;

import com.hr.models.Employee;
import com.hr.models.Role;
import com.hr.models.Task;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 */
public class HRSessionUtil {

    private static final SessionFactory SESSION_FACTORY;
    private static final ServiceRegistry SERVICE_REGISTRY;

    static {
        try {
            //This will automatically find the hibernate configuration file and
            //use the configs mentioned there.
            Configuration configuration = new Configuration()
                    .configure("com/hr/configuration/hibernate.cfg.xml");
            //Builds the service registry using the configs we have specified
            SERVICE_REGISTRY = new StandardServiceRegistryBuilder()
                    .applySettings(
                            configuration
                                    .getProperties()
                    )
                    .build();
            //Builds the session factory using the service registry
            SESSION_FACTORY = configuration
                    .buildSessionFactory(SERVICE_REGISTRY);

        } catch (HibernateException ex) {
            // Log the exception.
            System.err.println("Error" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Method to get session factory
     * 
     */
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
    /**
     * Method to open session
     * 
     */
    public static Session openSession(){
        return SESSION_FACTORY.openSession();
    }
    /**
     * Method to get current session
     * 
     */
    public static Session getCurrentSession(){
        return SESSION_FACTORY.getCurrentSession();
    }
    /**
     * Method to close session
     * 
     */
    public static void closeSession(){
        if (SESSION_FACTORY != null) {
            SESSION_FACTORY.close();
        }
    }
}
