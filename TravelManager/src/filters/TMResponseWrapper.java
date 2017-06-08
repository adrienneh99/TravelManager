package filters;

import java.io.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * @author adrienne2
 *
 */
public class TMResponseWrapper extends HttpServletResponseWrapper {
	
	/**
	 * Default constructor
	 * @param res
	 */
	public TMResponseWrapper(HttpServletResponse res) {
		super(res);
	}

	StringWriter writer = new StringWriter();
	
	public PrintWriter getWriter() {
		return new PrintWriter(writer);
	}
	
	public String toString() {
		return writer.toString();
	}

}
