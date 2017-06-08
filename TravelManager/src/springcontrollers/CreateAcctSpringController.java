package springcontrollers;

import javax.servlet.http.HttpServletRequest;
import managers.CreateAcctManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import domain.Account;
import domain.Constants;
import domain.TravelManagerError;

/**
 * @author adrienne2
 *
 */
@Controller
public class CreateAcctSpringController {
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value="createacct", method = RequestMethod.GET)
	public String setupAccount(Model model)
	{
		model.addAttribute("account",  new Account());
		return "createacct";
	}
	
	/**
	 * @param account 
	 * @param model
	 * @param req 
	 * @return
	 */
	@RequestMapping(value="createacct", method = RequestMethod.POST)
	public String createAccount(Account account, Model model, HttpServletRequest req)
	{
		account.setUserRole(Constants.STANDARD_ROLE_TYPE);
		CreateAcctManager createAcctManager = new CreateAcctManager();		
		
		if (!createAcctManager.confirmUniqueUsername(account)){
			TravelManagerError error = 
					new TravelManagerError("Travel Manager Account Creation", "Username already exists. "
							+ "Please enter a different username.");
			model.addAttribute("error", error);
			return "error";
		} 
		else if (!createAcctManager.confirmUsernameFormat(account)){
			TravelManagerError error = 
					new TravelManagerError("Travel Manager Account Creation", "Invalid username format! "
							+ "Must begin with a letter, be at least 8 characters, and contain only "
							+ "letters and numbers.<br/> Please try again.");
			model.addAttribute("error", error);
			return "error";
		}
		else if (!createAcctManager.confirmPasswordFormat(account)){
			TravelManagerError error = 
					new TravelManagerError("Travel Manager Account Creation", "Invalid password format! "
							+ "Must be at least 8 characters, containing only letters and numbers.<br/> "
							+ "Please try again.");
			model.addAttribute("error", error);
			return "error";
		}
		else {
			account = createAcctManager.saveNewAccount(account);
			req.getSession().setAttribute("acctKey", account);
			return "home";		
		}
	}
}
