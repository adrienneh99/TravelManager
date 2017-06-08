package factory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author adrienne2
 *
 */
@SuppressWarnings("deprecation")
public class HibernateSessionFactory {
	
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
     
	private static SessionFactory getSessionFactory()
    {
        try
        {
            if(sessionFactory == null)
            {
            	Configuration configuration = new Configuration();
            	configuration.configure();
//            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            	
            	serviceRegistry = new ServiceRegistryBuilder().applySettings(
                        configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            	
            }   
        }
        catch (Throwable e)
        {
           System.out.println(e.getMessage());
        }
        return sessionFactory;
    }
    
     /**
     * Returns the ThreadLocal Session instance. 
     *
     * @return Session
     * @throws HibernateException
     */
    public static Session getSession() throws HibernateException
    {
        Session session = (Session) threadLocal.get();

        if (session == null || !session.isOpen())
        {
            if (sessionFactory == null)
            {
                sessionFactory = getSessionFactory();
            }
            
            if (sessionFactory != null)
            {
                session = sessionFactory.openSession();
            }
            else
            {
                session = null;
                threadLocal.set(session);
            }
        }
        return session;
    }
    
    
    /**
     * Close the single hibernate session instance.
     *
     * @throws HibernateException
     */
    public static void closeSession() throws HibernateException
    {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null)
        {
            session.close();
        }
    }

}
