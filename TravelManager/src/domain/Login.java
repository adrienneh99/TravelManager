package domain;

import javax.validation.constraints.Size;

/**
 * @author adrienne2
 */
public class Login {

	/**
	 * Login username
	 */
	@Size(min=8, message="Username is required and must be a minimum of 8 characters")
	private String username;

	/**
	 * Login password
	 */
	@Size(min=8, message="Password is required and must be a minimum of 8 characters")
	private String password;
	
	/**
    * Default constructor
    */
	public Login() {
	}

	/**
	 * @param username
	 * @param password
	 */
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * @return
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Validate if the instance variables are valid
	 *
	 * @return boolean - true if instance variables are valid, else false
	 */
	public boolean validate() {

		if (username == null) {
			return false;
		}

		if (password == null) {
			return false;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Login other = (Login) obj;
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

}
