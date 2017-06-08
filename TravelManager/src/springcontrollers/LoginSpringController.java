package springcontrollers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import managers.LoginManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import domain.Account;
import domain.Login;
import domain.TravelManagerError;

/**
 * @author adrienne2
 *
 */
@Controller
public class LoginSpringController {
	
	/**
	 * @param model
	 * @return
	 */
//	@RequestMapping(value = {"/","/login"}, method=RequestMethod.GET)
	public String login(Model model)
	{
		model.addAttribute("login",  new Login());
		return "login";
	}
	
	/**
	 * @param login
	 * @param model
	 * @return
	 */
//	@RequestMapping(params="createAcct", method=RequestMethod.POST)
	public String showCreateAccount()
	{
		return "redirect:/createacct";
	}
	
	/**
	 * @param login 
	 * @param result 
	 * @param model 
	 * @param req
	 * @return
	 */
//	@RequestMapping(params="login", method = RequestMethod.POST)
	public String login(@ModelAttribute("login") @Valid Login login, BindingResult result, Model model, HttpServletRequest req)
	{
		if(result.hasErrors()){
			return "login";
		}
		else {
			LoginManager loginManager = new LoginManager();
			Account acct = loginManager.authenticate(login);
			
			if(acct != null){
				req.getSession().setAttribute("acctKey", acct);
				return "home";
			} else {
				TravelManagerError tmError = 
						new TravelManagerError("Travel Manager Login", "Login Error! Please try again!");
				model.addAttribute("error", tmError);
				return "error";
			}		
		}
	}
}
