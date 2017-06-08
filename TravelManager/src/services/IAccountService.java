package services;

import domain.Account;
import domain.Login;
import exceptions.AccountException;

/**
 * @author adrienne2
 */
public interface IAccountService extends IService{
	
	/**
     * Initiates the constant NAME to IAccountService
     */
    public final String NAME = "IAccountService";

    /**
     * @param userName
     * @return
     * @throws AccountException
     */
    public boolean confirmUniqueUserName(String userName) throws AccountException;

    /**
     * @param password
     * @return isValid
     */
    public boolean confirmPasswordFormat(String password);

    /**
     * @param login 
     * @return
     * @throws AccountException
     */
    public Account authenticateAccount(Login login) throws AccountException;
    
    /**
     * @param userName
     * @return
     * @throws AccountException
     */
    public Account getAccount(String userName) throws AccountException;

}
