package domain;

/**
 * @author adrienne2
 */
public class Account {
	
	/**
     * Account ID
     */
	private Integer accountId;

    /**
     * Account username
     */
    private String username;

    /**
     * Account password
     */
    private String password;

    /**
     * Account user role
     */
    private String userRole;
    
    /**
     * User profile
     */
    private Profile profile;
    
    /**
     * Default constructor
     */
    public Account() {
    }
	
    /**
     * @param username
     * @param password
     * @param userRole
     */
    public Account(String username, String password, String userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }
    
    /**
     * @param username
     * @param password
     * @param userRole
     * @param profile 
     */
    public Account(String username, String password, String userRole, Profile profile) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.profile = profile;
    }
   
    /**
     * @return
     */
    public Integer getAccountId() {
        return this.accountId;
    }
    
    /**
     * @param accountId
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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
     * @return
     */
    public String getUserRole() {
        return this.userRole;
    }
    
    /**
     * @param userRole
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    
    /**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
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
        if (userRole == null) {
            return false;
        }
        return true;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		result = prime * result
				+ ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		Account other = (Account) obj;
		if (accountId == null) {
			if (other.accountId != null) {
				return false;
			}
		} else if (!accountId.equals(other.accountId)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (profile == null) {
			if (other.profile != null) {
				return false;
			}
		} else if (!profile.equals(other.profile)) {
			return false;
		}
		if (userRole == null) {
			if (other.userRole != null) {
				return false;
			}
		} else if (!userRole.equals(other.userRole)) {
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
