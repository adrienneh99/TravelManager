package filters;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

/**
 * @author adrienne2
 *
 */
public class TMTrackingFilter implements Filter {
	
	private FilterConfig config = null;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			throws ServletException, IOException {
		System.out.println("Entering TMTrackingFilter...");
		HttpServletRequest httpReq = (HttpServletRequest)req;
		String host = httpReq.getHeader("host");
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat ("E MM/dd/yyyy 'at' hh:mm:ss a zzz");
		config.getServletContext().log("TMTrackingFilter: " + sdf.format(now) + "," + host);
		System.out.println("Exiting TMTrackingFilter...");
		chain.doFilter(req, res);
	}
	
	public void destroy() {
		
	}

}
