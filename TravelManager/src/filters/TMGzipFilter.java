package filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author adrienne2
 *
 */
public class TMGzipFilter implements Filter {
	
	/**
	 * Default constructor
	 */
	public TMGzipFilter() {
		
	}
	
	@SuppressWarnings("unused")
	private FilterConfig config = null;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			throws ServletException, IOException {
		System.out.println("Entering TMGzipFilter...");
		PrintWriter out;
		if (isGzipSupported((HttpServletRequest) req)) {
			out = getGzipWriter((HttpServletResponse) res);
			((HttpServletResponse) res).setHeader("Content-Encoding", "gzip");
			TMResponseWrapper wrapper = new TMResponseWrapper((HttpServletResponse) res);
			chain.doFilter(req, wrapper);
			out.print(wrapper.toString());
			out.close();
		} else {
			chain.doFilter(req, res);
		}
		System.out.println("Exiting TMGzipFilter...");
	}
	
	public void destroy() {
		config = null;
	}
	
	/**
	 * @param req
	 * @return
	 */
	public boolean isGzipSupported(HttpServletRequest req) {
		String encodings = req.getHeader("Accept-Encoding");
		return ((encodings != null) && (encodings.indexOf("gzip") != -1));
	}
	
	/**
	 * @param res
	 * @return
	 * @throws IOException
	 */
	public PrintWriter getGzipWriter(HttpServletResponse res) throws IOException {
		return (new PrintWriter(new GZIPOutputStream(res.getOutputStream())));
	}

}
