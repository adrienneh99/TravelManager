package managers;

import services.IAccountService;
import services.IDataService;
import domain.Account;
import factory.Factory;

/**
 * @author adrienne2
 */
public class CreateAcctManager {
	
	/**
	 * Default constructor
	 */
	public CreateAcctManager(){	
		
	}
	
	/**
	 * @param account
	 * @return
	 */
	public boolean confirmUniqueUsername (Account account){
		boolean unique = false;
		Factory factory = Factory.getInstance();
		
		try{
			IAccountService acctSvc = (IAccountService)factory.getService(IAccountService.NAME);
			unique =  acctSvc.confirmUniqueUserName(account.getUsername());
		}
		catch (Exception e)
		{
			
		}
		return unique;
	}
	
	/**
	 * @param account
	 * @return
	 */
	public boolean confirmUsernameFormat (Account account) {
        if (account.getUsername().matches("([a-zA-Z])*")){
        	if (account.getUsername().length() > 7){
        		if (account.getUsername().matches("^[a-zA-Z0-9]+$")){
            		return true;
            	}
            }
        }
        return false;
    }
	
	/**
	 * @param account
	 * @return
	 */
	public boolean confirmPasswordFormat (Account account) {
        if (account.getPassword().length() > 7) {
        	if (account.getPassword().indexOf(' ') == -1) {
        		return true;
        	}
        }
        return false;
    }
	
	/**
	 * @param account
	 * @return
	 */
	public Account saveNewAccount(Account account)
	{
		Account savedAccount = new Account();
		Factory factory = Factory.getInstance();
		
		try{
			IDataService dataSvc = (IDataService)factory.getService(IDataService.NAME);
			savedAccount =  dataSvc.saveAccount(account);
		}
		catch (Exception e)
		{
			
		}
		
		return savedAccount;
	}
}
