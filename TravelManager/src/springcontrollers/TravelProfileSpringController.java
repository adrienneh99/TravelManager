package springcontrollers;

import javax.servlet.http.HttpServletRequest;
import managers.ProfileManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import domain.Account;
import domain.Constants;
import domain.Profile;
import domain.TravelManagerError;

/**
 * @author adrienne2
 *
 */
@Controller
public class TravelProfileSpringController {
	
	/**
	 * @param model
	 * @param req 
	 * @return
	 */
	@RequestMapping(value="travelprofile", method = RequestMethod.GET)
	public String setupTravelProfile(Model model, HttpServletRequest req)
	{
		model.addAttribute("profile", new Profile());
		return "travelprofile";
	}
	
	/**
	 * @param profile 
	 * @param account
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping(params="save", method = RequestMethod.POST)
	public String saveTravelProfile(Profile profile, Model model, HttpServletRequest req)
	{
		Account account = (Account)req.getSession().getAttribute("acctKey");
		account.setProfile(profile);
		ProfileManager profileMgr = new ProfileManager();
		
		String result = profileMgr.saveProfile(account);
		
		if (result.equals(Constants.SAVE_PROFILE_SUCCESS))
		{
			req.getSession().setAttribute("acctKey", account);
			return "home";
		}
		else
		{
			TravelManagerError error = new TravelManagerError("Profile Save Error", result);
			model.addAttribute("error", error);
			return "error";
		}	
	}
	
	/**
	 * @param account
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping(value="travelprofile", params="cancel", method = RequestMethod.POST)
	public String cancelTravelProfile(Account account, Model model, HttpServletRequest req)
	{
		return "home";
	}

}
