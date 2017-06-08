package services;

import domain.Profile;
import exceptions.ProfileException;

/**
 * @author adrienne2
 *
 */
public class ProfileServiceImpl implements IProfileService {
	
	public boolean confirmValidFirstName(String firstName) throws ProfileException {
        boolean isValid = false;
        if (firstName != null && !firstName.isEmpty()) {
            if (!stringContainsNumber(firstName)) {
                isValid = true;
            }
        }
        if (!isValid) {
            throw new ProfileException("Invalid First Name, cannot contain numbers and is required");
        }
        return isValid;
    }

    public boolean confirmValidMiddleName(String middleName) throws ProfileException {
        boolean isValid = false;
        if (middleName != null && !middleName.isEmpty()) {
            if (!stringContainsNumber(middleName)) {
                isValid = true;
            }
        }
        if (!isValid) {
            throw new ProfileException("Invalid Middle Name, cannot contain numbers and is required");
        }
        return isValid;
    }

    public boolean confirmValidLastName(String lastName) throws ProfileException {
        boolean isValid = false;
        if (lastName != null && !lastName.isEmpty()) {
            if (!stringContainsNumber(lastName)) {
                isValid = true;
            }
        }
        if (!isValid) {
            throw new ProfileException("Invalid Last Name, cannot contain numbers and is required");
        }
        return isValid;
    }

    public boolean confirmValidPhoneNumber(String phoneNumber) throws ProfileException {
        boolean isValid = false;
        String regex = "\\d{3}-\\d{3}-\\d{4}";

        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            if (phoneNumber.matches(regex)) {
                isValid = true;
            }
        }

        if (!isValid) {
            throw new ProfileException("Invalid Phone Number, phone number is required and must "
            		+ "follow this format: XXX-XXX-XXXX");
        }

        return isValid;
    }

    /**
     * @param emailAddress
     * @return
     * @throws ProfileException
     */
    public boolean confirmValidEmailAddress(String emailAddress) throws ProfileException {
        boolean isValid = false;

        if (emailAddress != null && !emailAddress.isEmpty()) {
            int index = emailAddress.indexOf('@');
            if (index > -1) {
                isValid = true;
            }
        }

        if (!isValid) {
            throw new ProfileException("Invalid Email Address, an email address is required.");
        }

        return isValid;
    }

    public boolean confirmValidCity(String city) throws ProfileException {
        boolean isValid = false;
        if (city != null && !city.isEmpty()) {
            if (!stringContainsNumber(city)) {
                isValid = true;
            }
        }
        if (!isValid) {
            throw new ProfileException("Invalid City, cannot contain numbers and is required");
        }
        return isValid;
    }

    public boolean confirmValidState(String state) throws ProfileException {
        boolean isValid = false;
        if (state != null && !state.isEmpty()) {
            if (!stringContainsNumber(state) && state.length() < 3 && state.length() > 1) {
                isValid = true;
            }
        }
        if (!isValid) {
            throw new ProfileException("Invalid State, cannot contain numbers, must be 2 letter "
            		+ "abbreviation, and is required");
        }
        return isValid;
    }

    public boolean confirmValidZip(String zip) throws ProfileException {
        boolean isValid = false;
        String zipPattern = "\\d{5}";
        if (zip != null && !zip.isEmpty()) {
            if (zip.matches(zipPattern)) {
                isValid = true;
            }
        }
        if (!isValid) {
            throw new ProfileException("Invalid Zip, must be 5 digit zip code and is required");
        }
        return isValid;
    }

    public boolean confirmValidPassport(String passport) throws ProfileException {
        boolean isValid = false;
        String passportPattern = "\\d{9}";
        if (passport != null && !passport.isEmpty()) {
            if (passport.matches(passportPattern)) {
                isValid = true;
            }
        }
        if (!isValid) {
            throw new ProfileException("Invalid Passport Number, must be 9 digits and is required");
        }
        return isValid;
    }

    public boolean confirmValidGender(char gender) throws ProfileException {
        boolean isValid = false;
        if (gender == ('M') || gender == ('F')) {
            isValid = true;
        }
        if (!isValid) {
            throw new ProfileException("Invalid Gender, must be either M or F");
        }
        return isValid;
    }

    /**
     * @param profile
     * @return
     * @throws ProfileException
     */
    public boolean confirmValidProfile(Profile profile) throws ProfileException {
        boolean isValid = false;

        try {
            if (this.confirmValidFirstName(profile.getFirstName())) {
                if (this.confirmValidMiddleName(profile.getMiddleName())) {
                    if (this.confirmValidLastName(profile.getLastName())) {
                        if (this.confirmValidPhoneNumber(profile.getPrimaryPhone())) {
                            if (this.confirmValidPassport(profile.getPassportNum())) {
                                if (profile.getPrimaryAddress() != null && !profile.getPrimaryAddress().isEmpty()) {
                                    if (this.confirmValidCity(profile.getPrimaryCity())) {
                                        if (this.confirmValidState(profile.getPrimaryState())) {
                                            if (this.confirmValidZip(profile.getPrimaryZip())) {
                                                if (this.confirmValidGender(profile.getGender())) {
                                                    if (this.confirmValidEmailAddress(profile.getPrimaryEmail())) {
                                                        if (profile.getDateOfBirth() != null) {
                                                            isValid = true;
                                                        } else {
                                                            throw new ProfileException("A valid date of birth "
                                                            		+ "in the MM/DD/YYYY format is required.");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (ProfileException ex) {
            throw new ProfileException(ex.getMessage());
        }

        return isValid;
    }

    public boolean stringContainsNumber(String testString) {
        boolean containsNumber = false;
        if (testString.matches(".*[0-9].*")) {
            containsNumber = true;
        }
        return containsNumber;
    }

}
