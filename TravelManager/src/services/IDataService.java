package services;

import domain.Account;
import exceptions.DataException;

/**
 * @author adrienne2
 */
public interface IDataService extends IService{
	
	/**
     * Initiates the constant NAME to IDataService
     */
    public final String NAME = "IDataService";

    /**
     * @param account
     * @return
     * @throws DataException
     */
    public Account saveAccount(Account account) throws DataException;
    
    /**
     * @param account
     * @return
     * @throws DataException
     */
    public Account saveProfile(Account account) throws DataException;

}
