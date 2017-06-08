package taghandlers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author adrienne2
 *
 */
public class CurrentDateTimeTag extends SimpleTagSupport {
	
	public void doTag() throws JspException, IOException {	
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
		getJspContext().getOut().print("The current date and time is: " + sdf.format(new Date()));
	}
}
