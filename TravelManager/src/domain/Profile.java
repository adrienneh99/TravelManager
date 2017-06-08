package domain;

import java.util.Date;

/**
 * @author adrienne2
 */
public class Profile {
	
	/**
	 * Account ID
	 */
	private Integer accountId;
    
	/**
	 * Account
	 */
    private Account account;

    /**
     * User first name
     */
    private String firstName;

    /**
     * User middle name
     */
    private String middleName;

    /**
     * User last name
     */
    private String lastName;

    /**
     * User primary street address
     */
    private String primaryAddress;

    /**
     * User primary city
     */
    private String primaryCity;

    /**
     * User primary state
     */
    private String primaryState;

    /**
     * User primary zip code
     */
    private String primaryZip;

    /**
     * User primary email
     */
    private String primaryEmail;

    /**
     * User primary phone
     */
    private String primaryPhone;

    /**
     * User gender
     */
    private char gender;

    /**
     * User date of birth
     */
    private Date dateOfBirth;

    /**
     * User passport number
     */
    private String passportNum;

    /**
     * Default constructor
     */
    public Profile() {
    }
    
    /**
     * does NOT include account ID, account
     * 
     * @param firstName
     * @param middleName
     * @param lastName
     * @param primaryAddress
     * @param primaryCity
     * @param primaryState
     * @param primaryZip
     * @param primaryEmail
     * @param primaryPhone
     * @param gender
     * @param dateOfBirth
     * @param passportNum
     */
    public Profile (String firstName, String middleName, String lastName, String primaryAddress, String primaryCity, 
    		String primaryState, String primaryZip, String primaryEmail, String primaryPhone, char gender, Date dateOfBirth, 
    		String passportNum) {
       this.firstName = firstName;
       this.middleName = middleName;
       this.lastName = lastName;
       this.primaryAddress = primaryAddress;
       this.primaryCity = primaryCity;
       this.primaryState = primaryState;
       this.primaryZip = primaryZip;
       this.primaryEmail = primaryEmail;
       this.primaryPhone = primaryPhone;
       this.gender = gender;
       this.dateOfBirth = dateOfBirth;
       this.passportNum = passportNum;
    }

    /**
     * does NOT include account ID, passportNum
     * 
     * @param account
     * @param firstName
     * @param middleName
     * @param lastName
     * @param primaryAddress
     * @param primaryCity
     * @param primaryState
     * @param primaryZip
     * @param primaryEmail
     * @param primaryPhone
     * @param gender
     * @param dateOfBirth
     */
    public Profile (Account account, String firstName, String middleName, String lastName, String primaryAddress, 
    		String primaryCity, String primaryState, String primaryZip, String primaryEmail, String primaryPhone, 
    		char gender, Date dateOfBirth) {
        this.account = account;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.primaryAddress = primaryAddress;
        this.primaryCity = primaryCity;
        this.primaryState = primaryState;
        this.primaryZip = primaryZip;
        this.primaryEmail = primaryEmail;
        this.primaryPhone = primaryPhone;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
     * does NOT include account ID
     * 
     * @param account
     * @param firstName
     * @param middleName
     * @param lastName
     * @param primaryAddress
     * @param primaryCity
     * @param primaryState
     * @param primaryZip
     * @param primaryEmail
     * @param primaryPhone
     * @param gender
     * @param dateOfBirth
     * @param passportNum
     */
    public Profile (Account account, String firstName, String middleName, String lastName, String primaryAddress, 
    		String primaryCity, String primaryState, String primaryZip, String primaryEmail, String primaryPhone, 
    		char gender, Date dateOfBirth, String passportNum) {
       this.account = account;
       this.firstName = firstName;
       this.middleName = middleName;
       this.lastName = lastName;
       this.primaryAddress = primaryAddress;
       this.primaryCity = primaryCity;
       this.primaryState = primaryState;
       this.primaryZip = primaryZip;
       this.primaryEmail = primaryEmail;
       this.primaryPhone = primaryPhone;
       this.gender = gender;
       this.dateOfBirth = dateOfBirth;
       this.passportNum = passportNum;
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
    public Account getAccount() {
        return this.account;
    }
    
    /**
     * @param account
     */
    public void setAccount(Account account) {
        this.account = account;
    }
    
    /**
     * @return
     */
    public String getFirstName() {
        return this.firstName;
    }
    
    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * @return
     */
    public String getMiddleName() {
        return this.middleName;
    }
    
    /**
     * @param middleName
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    
    /**
     * @return
     */
    public String getLastName() {
        return this.lastName;
    }
    
    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * @return
     */
    public String getPrimaryAddress() {
        return this.primaryAddress;
    }
    
    /**
     * @param primaryAddress
     */
    public void setPrimaryAddress(String primaryAddress) {
        this.primaryAddress = primaryAddress;
    }
    
    /**
     * @return
     */
    public String getPrimaryCity() {
        return this.primaryCity;
    }
    
    /**
     * @param primaryCity
     */
    public void setPrimaryCity(String primaryCity) {
        this.primaryCity = primaryCity;
    }
    
    /**
     * @return
     */
    public String getPrimaryState() {
        return this.primaryState;
    }
    
    /**
     * @param primaryState
     */
    public void setPrimaryState(String primaryState) {
        this.primaryState = primaryState;
    }
    
    /**
     * @return
     */
    public String getPrimaryZip() {
        return this.primaryZip;
    }
    
    /**
     * @param primaryZip
     */
    public void setPrimaryZip(String primaryZip) {
        this.primaryZip = primaryZip;
    }
    
    /**
     * @return
     */
    public String getPrimaryEmail() {
        return this.primaryEmail;
    }
    
    /**
     * @param primaryEmail
     */
    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }
    
    /**
     * @return
     */
    public String getPrimaryPhone() {
        return this.primaryPhone;
    }
    
    /**
     * @param primaryPhone
     */
    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }
    
    /**
     * @return
     */
    public char getGender() {
        return this.gender;
    }
    
    /**
     * @param gender
     */
    public void setGender(char gender) {
        this.gender = gender;
    }
    
    /**
     * @return
     */
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    /**
     * @param dateOfBirth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
     * @return
     */
    public String getPassportNum() {
        return this.passportNum;
    }
    
    /**
     * @param passportNum
     */
    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    /**
     * Validate if the instance variables are valid
     *
     * @return boolean - true if instance variables are valid, else false
     */
    public boolean validate() {
        if (firstName == null) {
            return false;
        }
        if (middleName == null) {
            return false;
        }
        if (lastName == null) {
            return false;
        }
        if (primaryAddress == null) {
            return false;
        }
        if (primaryCity == null) {
            return false;
        }
        if (primaryState == null) {
            return false;
        }
        if (primaryZip == null) {
            return false;
        }
        if (primaryEmail == null) {
            return false;
        }
        if (primaryPhone == null) {
            return false;
        }
        if (gender == ' ') {
            return false;
        }
        if (dateOfBirth == null) {
            return false;
        }
        if (passportNum == null) {
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
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result
				+ ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result
				+ ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + gender;
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result
				+ ((passportNum == null) ? 0 : passportNum.hashCode());
		result = prime * result
				+ ((primaryAddress == null) ? 0 : primaryAddress.hashCode());
		result = prime * result
				+ ((primaryCity == null) ? 0 : primaryCity.hashCode());
		result = prime * result
				+ ((primaryEmail == null) ? 0 : primaryEmail.hashCode());
		result = prime * result
				+ ((primaryPhone == null) ? 0 : primaryPhone.hashCode());
		result = prime * result
				+ ((primaryState == null) ? 0 : primaryState.hashCode());
		result = prime * result
				+ ((primaryZip == null) ? 0 : primaryZip.hashCode());
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
		Profile other = (Profile) obj;
		if (account == null) {
			if (other.account != null) {
				return false;
			}
		} else if (!account.equals(other.account)) {
			return false;
		}
		if (accountId == null) {
			if (other.accountId != null) {
				return false;
			}
		} else if (!accountId.equals(other.accountId)) {
			return false;
		}
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null) {
				return false;
			}
		} else if (!dateOfBirth.equals(other.dateOfBirth)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (gender != other.gender) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (middleName == null) {
			if (other.middleName != null) {
				return false;
			}
		} else if (!middleName.equals(other.middleName)) {
			return false;
		}
		if (passportNum == null) {
			if (other.passportNum != null) {
				return false;
			}
		} else if (!passportNum.equals(other.passportNum)) {
			return false;
		}
		if (primaryAddress == null) {
			if (other.primaryAddress != null) {
				return false;
			}
		} else if (!primaryAddress.equals(other.primaryAddress)) {
			return false;
		}
		if (primaryCity == null) {
			if (other.primaryCity != null) {
				return false;
			}
		} else if (!primaryCity.equals(other.primaryCity)) {
			return false;
		}
		if (primaryEmail == null) {
			if (other.primaryEmail != null) {
				return false;
			}
		} else if (!primaryEmail.equals(other.primaryEmail)) {
			return false;
		}
		if (primaryPhone == null) {
			if (other.primaryPhone != null) {
				return false;
			}
		} else if (!primaryPhone.equals(other.primaryPhone)) {
			return false;
		}
		if (primaryState == null) {
			if (other.primaryState != null) {
				return false;
			}
		} else if (!primaryState.equals(other.primaryState)) {
			return false;
		}
		if (primaryZip == null) {
			if (other.primaryZip != null) {
				return false;
			}
		} else if (!primaryZip.equals(other.primaryZip)) {
			return false;
		}
		return true;
	}
    
}
