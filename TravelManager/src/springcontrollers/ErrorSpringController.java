package springcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import domain.TravelManagerError;

/**
 * @author adrienne2
 *
 */
@Controller
public class ErrorSpringController {
	
	/**
	 * @param error
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "error", method = RequestMethod.POST)
	public String error(Model model)
	{
		model.addAttribute("error", new TravelManagerError("Error", "An unknown error occcurred"));
		return "error";
	}
}
