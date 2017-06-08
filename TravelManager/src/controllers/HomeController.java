package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author adrienne2
 */
public class HomeController extends HttpServlet {

	/**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost (HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		if(req.getParameter("travelProfile") != null){
			getServletContext().getRequestDispatcher("/jsp/travelprofile.jsp").forward(req, res);
		}
		else if(req.getParameter("travelPreferences") != null){
			getServletContext().getRequestDispatcher("/jsp/travelprefs.jsp").forward(req, res);
		}
		else if(req.getParameter("admin") != null){
			getServletContext().getRequestDispatcher("/jsp/admin.jsp").forward(req, res);
		}	
		else if(req.getParameter("logout") != null){
			req.getSession().removeAttribute("acctKey");
			getServletContext().getRequestDispatcher("/login.html").forward(req, res);
		}
	}
}
