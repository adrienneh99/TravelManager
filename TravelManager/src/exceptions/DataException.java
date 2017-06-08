package exceptions;

/**
 * @author adrienne2
 */
public class DataException extends Exception {
	
	/**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @param s
     */
    public DataException(String s) {
        super(s);
    }
}
