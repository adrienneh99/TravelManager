package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.ProfileManager;
import domain.Account;
import domain.Constants;
import domain.Profile;
import domain.TravelManagerError;

/**
 * @author adrienne2
 *
 */
public class TravelProfileController extends HttpServlet{
	
	/**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 3L;

	public void doPost (HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		if(req.getParameter("cancel") != null){
			getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req, res);
		}
		else
		{
			Account account = (Account)req.getSession().getAttribute("acctKey");
			Profile profile = getProfileDataFromRequest(req);
			profile.setAccountId(account.getAccountId());
			account.setProfile(profile);
			ProfileManager profileMgr = new ProfileManager();
			
			String result = profileMgr.saveProfile(account);
			
			if (result.equals(Constants.SAVE_PROFILE_SUCCESS))
			{
				req.getSession().setAttribute("acctKey", account);
				getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req, res);
			}
			else
			{
				TravelManagerError error = new TravelManagerError("Profile Save Error", result);
				req.setAttribute("errorKey", error);
				getServletContext().getRequestDispatcher("/jsp/error.jsp").forward(req, res);
			}
		}
	}
	
	
	/**
	 * @param req
	 * @return
	 */
	public Profile getProfileDataFromRequest(HttpServletRequest req)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		//get input parameters
		Profile profile = new Profile();
		profile.setFirstName(req.getParameter("firstName"));
		profile.setMiddleName(req.getParameter("middleName"));
		profile.setLastName(req.getParameter("lastName"));
		profile.setPrimaryAddress(req.getParameter("address"));
		profile.setPrimaryCity(req.getParameter("city"));
		profile.setPrimaryState(req.getParameter("state"));
		profile.setPrimaryZip(req.getParameter("zip"));
		profile.setPrimaryEmail(req.getParameter("emailAddress"));
		profile.setPrimaryPhone(req.getParameter("phoneNumber"));
		profile.setPassportNum(req.getParameter("passportNumber"));
		String genderStr = req.getParameter("gender");
		char gender = ' ';
		
		if (genderStr.trim().length()>0)
		{
			gender = genderStr.trim().charAt(0);
		}

		profile.setGender(gender);
		Date dob = null;
        String dobRegex = "\\d{2}/\\d{2}/\\d{4}";
        String txtDateOfBirth = req.getParameter("dateOfBirth");
        
        try{
	        if (!txtDateOfBirth.isEmpty() && txtDateOfBirth.matches(dobRegex)) {
	            dob = sdf.parse(txtDateOfBirth);
	        }
        } catch (ParseException pe) {
            //do nothing, parse failed because format is invalid
        }
		
		profile.setDateOfBirth(dob);
		return profile;
	}
}
