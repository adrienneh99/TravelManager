package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.CreateAcctManager;
import domain.Account;
import domain.TravelManagerError;
import domain.Constants;

/**
 * @author adrienne2
 */
public class CreateAcctController extends HttpServlet {

	/**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost (HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		Account account = new Account();
		account.setUsername(req.getParameter("username")); 
		account.setPassword(req.getParameter("password"));
		account.setUserRole(Constants.STANDARD_ROLE_TYPE);
		CreateAcctManager createAcctManager = new CreateAcctManager();		
		
		if (!createAcctManager.confirmUniqueUsername(account)){
			TravelManagerError error = 
					new TravelManagerError("Travel Manager Account Creation", "Username already exists. "
							+ "Please enter a different username.");
			req.setAttribute("errorKey", error);
			getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(req, res);
		} 
		else if (!createAcctManager.confirmUsernameFormat(account)){
			TravelManagerError error = 
					new TravelManagerError("Travel Manager Account Creation", "Invalid username format! "
							+ "Must begin with a letter, be at least 8 characters, and contain only "
							+ "letters and numbers.<br/> Please try again.");
			req.setAttribute("errorKey", error);
			getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(req, res);
		}
		else if (!createAcctManager.confirmPasswordFormat(account)){
			TravelManagerError error = 
					new TravelManagerError("Travel Manager Account Creation", "Invalid password format! "
							+ "Must be at least 8 characters, containing only letters and numbers.<br/> "
							+ "Please try again.");
			req.setAttribute("errorKey", error);
			getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(req, res);
		}
		else {
			account = createAcctManager.saveNewAccount(account);
			req.getSession().setAttribute("acctKey", account);
			getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req, res);		
		}
	}
}
