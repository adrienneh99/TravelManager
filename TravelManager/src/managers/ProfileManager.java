package managers;

import domain.Account;
import domain.Constants;
import exceptions.DataException;
import exceptions.ProfileException;
import factory.Factory;
import services.IDataService;
import services.IProfileService;

/**
 * @author adrienne2
 *
 */
public class ProfileManager {
	
	/**
	 * Default constructor
	 */
	public ProfileManager(){	
		
	}
	
	/**
     * @param profileServiceString
     * @param dataServiceString
     * @param account
     * @return isCreated
     */
    public String saveProfile(Account account)
    {
        String resultMessage = "";
        Factory factory = Factory.getInstance();

        try
        {
        	IProfileService profileSvc = (IProfileService)factory.getService(IProfileService.NAME);

            if (profileSvc.confirmValidProfile(account.getProfile()))
            {
            	IDataService iDataService = (IDataService)factory.getService(IDataService.NAME);
                account = iDataService.saveProfile(account);
                resultMessage = Constants.SAVE_PROFILE_SUCCESS;
            }
        }
        catch (ProfileException pe)
        {
            resultMessage = pe.getMessage();
        }
        catch (DataException de)
        {
            resultMessage = de.getMessage();
        }
        catch (Exception e)
        {
        	
        }
        return resultMessage;
    }
}
