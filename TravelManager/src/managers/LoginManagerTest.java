package managers;

import static org.junit.Assert.*;
import org.junit.Test;
import domain.Account;
import domain.Login;

/**
 * @author adrienne2
 */
public class LoginManagerTest {
	
	/**
	 * Asserts that the login is valid since the acct object is NOT null
	 */
	@Test
	public void testValidLogin() {
		System.out.println("testValidLogin beginning...");
		Login login = new Login ("testUsername","testPassword");
		Account acct = (new LoginManager()).authenticate(login);
		assertNotNull (acct);
		System.out.println("testValidLogin PASSED");
	}
	
	/**
	 * Asserts that the login is invalid since the acct object IS null
	 */
	@Test
	public void testInvalidLogin() {
		System.out.println("testInvalidLogin beginning...");
		Login login = new Login ("TestUN","TestPW");
		Account acct = (new LoginManager()).authenticate(login);
		assertNull (acct);
		System.out.println("testInvalidLogin PASSED");
	}
	
}
