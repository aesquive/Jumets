/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arbitreadores.base;

import arbitreadores.objetos.ArbGolAu;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author alberto
 */
public class HibernateUtilNuevoGol {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure("arbitreadores/hibernate/hibernateNuevoGol.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void main(String[] args) {
        HibernateUtilNuevoGol.getSessionFactory().openSession().createCriteria(ArbGolAu.class).list();
    }
}
