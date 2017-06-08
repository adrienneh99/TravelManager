package services;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import domain.Account;
import domain.Login;
import exceptions.AccountException;
import factory.HibernateSessionFactory;

/**
 * @author adrienne2
 *
 */
public class AccountServiceHibernateImpl implements IAccountService {
	
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
     * Validates whether the username is already used in the system
     *
     * @param userName
     * @throws AccountException
     * @return isUnique
     */
    @Override
    public boolean confirmUniqueUserName(String userName) throws AccountException
    {
        boolean isUnique = false;
        String sql = "SELECT userName FROM account WHERE account.userName= "
                + ":userName ";
        
        Session session = getSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("userName", userName);
        String resultSet = (String) query.uniqueResult();
        
        if (resultSet == null)
        {
            isUnique = true;
        }
        
        session.getTransaction().commit();
        session.close();
        return isUnique;
    }
    
    /**
     * @param password
     * @return isValid
     */
    @Override
    public boolean confirmPasswordFormat(String password)
    {
        boolean isValid = false;

        if (password.length() > 7) {
            if (password.indexOf(' ') == -1) {
                isValid = true;
            }
        }
        return isValid;
    }
    
    /**
     * Validates whether the Account is registered in the system.
     * @throws com.travelmanager.model.services.exception.AccountException
     */
    public Account authenticateAccount(Login login) throws AccountException
    {
        Account acct;
        Session session = getSession();
        Transaction txn = null;
        
        try
        {
            txn = session.beginTransaction();
            
            Criteria criteria = session.createCriteria(Account.class);
            criteria.add(Restrictions.eq("username", login.getUsername()));
            acct = (Account) criteria.uniqueResult();
            txn.commit();
            
            if (acct!=null)
            {
                if (acct.getPassword().equals(login.getPassword()))
                {
                    return acct;
                }
            }
        }
        catch (HibernateException he)
        {
            if (txn != null)
            {
                txn.rollback();
            }
           
            throw new AccountException("SQLException occurred while trying to "
                    + "access database, here is the message: "
                    + he.getMessage());
        } finally {
                if (session != null)
                {
                    session.close();
                }
        }
        return null;
    }

    /**
     * Validates whether the Account is registered in the system.
     * @throws com.travelmanager.model.services.exception.AccountException
     */
    public Account getAccount(String userName) throws AccountException
    {
        Account acct;
        Session session = getSession();
        Transaction txn = null;
        
        try
        {
            txn = session.beginTransaction();
            
            Criteria criteria = session.createCriteria(Account.class);
            criteria.add(Restrictions.eq("username", userName));
            acct = (Account) criteria.uniqueResult();
            txn.commit();
            
            if (acct!=null)
            {
            	return acct;
            }
        }
        catch (HibernateException he)
        {         
            throw new AccountException("SQLException occurred while trying to "
                    + "access database, here is the message: "
                    + he.getMessage());
        } finally {
                if (session != null)
                {
                    session.close();
                }
        }
        return null;
    }
}
