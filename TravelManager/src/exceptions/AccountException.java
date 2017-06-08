package exceptions;

/**
 * @author adrienne2
 */
public class AccountException extends Exception {
	
	/**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @param s
     */
    public AccountException(String s) {
        super(s);
    }
}
