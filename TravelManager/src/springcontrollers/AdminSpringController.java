package springcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author adrienne2
 *
 */
@Controller
public class AdminSpringController {

	/**
	 * @param error
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "admin")
	public String admin()
	{
		return "admin";
	}
}
