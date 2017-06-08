package exceptions;

/**
 * @author adrienne2
 */
@SuppressWarnings("serial")
public class ServiceLoadException extends Exception {
	
	/**
	 * @param inMessage
	 * @param inNestedException
	 */
	public ServiceLoadException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }

}
