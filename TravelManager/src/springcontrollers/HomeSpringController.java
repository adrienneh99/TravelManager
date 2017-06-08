package springcontrollers;

import javax.servlet.http.HttpServletRequest;
import managers.LoginManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import domain.Account;
import domain.TravelManagerError;

/**
 * @author adrienne2
 *
 */
@Controller

@RequestMapping(value = {"/","/home"})
public class HomeSpringController {
	
	/**
	 * @param model
	 * @param req 
	 * @return
	 */
	@RequestMapping(value = {"/","/home"}, method=RequestMethod.GET)
	public String home(Model model, HttpServletRequest req)
	{
		String username = req.getUserPrincipal().getName();
		LoginManager loginManager = new LoginManager();
		Account acct = loginManager.getAccount(username);
		if(acct != null){
			req.getSession().setAttribute("acctKey", acct);
			return "home";
		} else {
			TravelManagerError tmError = 
					new TravelManagerError("Travel Manager Login", "No account associated with "+username);
			model.addAttribute("error", tmError);
			return "error";
		}
//		model.addAttribute("home",  new Login());
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value = "/home", params="travelprofile", method=RequestMethod.POST)
	public String showTravelProfile()
	{
		return "redirect:/travelprofile";
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value="/home", params="travelpreferences")
	public String showTravelPreferences()
	{
		return "travelprefs";
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value="/home", params="admin")
	public ModelAndView showAdmin()
	{
		return new ModelAndView("redirect:/admin");
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value="/home", params="logout", method=RequestMethod.POST)
	public String showLogout()
	{
		return "redirect:/login";
	}
}
