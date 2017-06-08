package managers;

import static org.junit.Assert.*;
import org.junit.Test;
import domain.Account;

/**
 * @author adrienne2
 */
public class CreateAcctManagerTest {

	/**
	 * Asserts TRUE since the username is unique
	 */
	@Test
	public void testUniqueUsername() {
		System.out.println("testUniqueUsername beginning...");
		Account acct = new Account ();
		acct.setUsername("testUniqueUsername");
		boolean result = (new CreateAcctManager()).confirmUniqueUsername(acct);
		assertTrue(result);
		System.out.println("testUniqueUsername PASSED");
	}
	
	/**
	 * Asserts FALSE since the username is not unique
	 */
	@Test
	public void testNonUniqueUsername() {
		System.out.println("testNonUniqueUsername beginning...");
		Account acct = new Account ();
		acct.setUsername("testUsername");
		boolean result = (new CreateAcctManager()).confirmUniqueUsername(acct);
		assertFalse(result);
		System.out.println("testNonUniqueUsername PASSED");
	}
	
	/**
	 * Asserts TRUE since the username format is valid
	 */
	@Test
	public void testValidUsernameFormat() {
		System.out.println("testValidUsernameFormat beginning...");
		Account acct = new Account ();
		acct.setUsername("testValidUsername");
		boolean result = (new CreateAcctManager()).confirmUsernameFormat(acct);
		assertTrue(result);
		System.out.println("testValidUsernameFormat PASSED");
	}
	
	/**
	 * Asserts FALSE since the username format is INvalid
	 */
	@Test
	public void testInvalidUsernameFormat() {
		System.out.println("testInvalidUsernameFormat beginning...");
		Account acct = new Account ();
		acct.setUsername("Invalid UN");
		boolean result = (new CreateAcctManager()).confirmUsernameFormat(acct);
		assertFalse(result);
		System.out.println("testInvalidUsernameFormat PASSED");
	}
	
	/**
	 * Asserts TRUE since the password format is valid
	 */
	@Test
	public void testValidPasswordFormat() {
		System.out.println("testValidPasswordFormat beginning...");
		Account acct = new Account ();
		acct.setPassword("testValidPassword");
		boolean result = (new CreateAcctManager()).confirmPasswordFormat(acct);
		assertTrue(result);
		System.out.println("testValidPasswordFormat PASSED");
	}
	
	/**
	 * Asserts FALSE since the password format is INvalid
	 */
	@Test
	public void testInvalidPasswordFormat() {
		System.out.println("testInvalidPasswordFormat beginning...");
		Account acct = new Account ();
		acct.setPassword("Invalid PW");
		boolean result = (new CreateAcctManager()).confirmPasswordFormat(acct);
		assertFalse(result);
		System.out.println("testInvalidPasswordFormat PASSED");
	}

}
