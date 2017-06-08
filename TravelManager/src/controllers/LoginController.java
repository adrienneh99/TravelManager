package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import managers.LoginManager;
import domain.Account;
import domain.Login;
import domain.TravelManagerError;

/**
 * @author adrienne2
 */
public class LoginController extends HttpServlet {

	/**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost (HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		if(req.getParameter("createAcct") != null){
			getServletContext().getRequestDispatcher("/createacct.html").forward(req, res);
		}
		else{
			//get input parameters
			Login login = new Login();
			login.setUsername(req.getParameter("username")); 
			login.setPassword(req.getParameter("password"));
			LoginManager loginManager = new LoginManager();
			Account acct = loginManager.authenticate(login);
			
			if(acct != null){
				req.getSession().setAttribute("acctKey", acct);
				getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req, res);
			} else {
				TravelManagerError error = 
						new TravelManagerError("Travel Manager Login", "Login Error! Please try again!");
				req.setAttribute("errorKey", error);
				getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(req, res);
			}
		}	
	}
}
