package managers;

import services.IAccountService;
import domain.Account;
import domain.Login;
import factory.Factory;

/**
 * @author adrienne2
 */
public class LoginManager {
	
	/**
     * Default constructor
     */
	public LoginManager(){
	}
	
	/**
	 * @param login
	 * @return
	 */
	public Account authenticate (Login login){
		Account acct = null;
		
		Factory factory = Factory.getInstance();
		
		try{
			IAccountService acctSvc = (IAccountService)factory.getService(IAccountService.NAME);
			acct = acctSvc.authenticateAccount(login);
		}
		catch (Exception e)
		{
			
		}
		return acct;
	}
	
	
	/**
	 * This method is only used if authentication is being handled by Tomcat
	 * @param userName
	 * @return
	 */
	public Account getAccount(String userName)
	{
		Account acct = null;
		
		Factory factory = Factory.getInstance();
		
		try{
			IAccountService acctSvc = (IAccountService)factory.getService(IAccountService.NAME);
			acct = acctSvc.getAccount(userName);
		}
		catch (Exception e)
		{
			
		}
		return acct;
	}
}
