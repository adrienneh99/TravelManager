package services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import domain.Account;
import domain.Profile;
import exceptions.DataException;
import factory.HibernateSessionFactory;

/**
 * @author adrienne2
 *
 */
public class DataServiceHibernateImpl implements IDataService {
	
	/**
     * Gets a hibernate session from HibernateSessionFactory
     * 
     * @return session
     */
    private Session getSession()
    {
        Session session = HibernateSessionFactory.getSession();
        return session;
    }
    
    
    /**
     * Saves the Account details to the database.
     *
     * @param account
     * @throws DataException
     * @return isSaved
     */
    @SuppressWarnings({})
    @Override
    public Account saveAccount(Account account) throws DataException
    {
        Session session = getSession();
        Transaction txn = null;
        
        try
        {
            txn = session.beginTransaction();
            Integer id = (Integer) session.save(account);
            txn.commit();
            account.setAccountId(id);
        }
        catch (HibernateException he)
        {
            if (txn != null)
            {
                txn.rollback();
            }

            throw new DataException("SQLException occurred while trying to "
                    + "access database.");
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
        return account;
    }

    /**
     * Saves the Profile details to the database.
     *
     * @throws DataException
     * @return isSaved
     */
    @SuppressWarnings({})
    @Override
    public Account saveProfile(Account account) throws DataException {

        Session session = getSession();
        Transaction txn = null;
        
        Profile profile = account.getProfile();
        profile.setAccount(account);
        
        try
        {
            txn = session.beginTransaction();
            session.saveOrUpdate(profile);
            txn.commit();
            account.setProfile(profile); 
        }
        catch (HibernateException he)
        {
            if (txn != null)
            {
                txn.rollback();
            }
            
            throw new DataException("SQLException occurred while trying to "
                    + "access database, here is the message: "
                    + he.getMessage());
        }
        finally
        {
            if (session != null)
            {
                session.close();
            }
        }
        return account;
    }

}
