package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.TravelManagerError;

/**
 * @author adrienne2
 */
public class ErrorServlet extends HttpServlet{
	
	/**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	public void doPost (HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		if(req.getParameter("travelProfile") != null){
			getServletContext().getRequestDispatcher("/jsp/travelprofile.jsp").forward(req, res);
		}
		
		TravelManagerError error = (TravelManagerError)req.getAttribute("errorKey");
		
		if(error==null){
			error = new TravelManagerError("Error", "An unknown error occcurred");
		}
	}
}
