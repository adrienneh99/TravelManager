package services;

import domain.Profile;
import exceptions.ProfileException;

/**
 * @author adrienne2
 *
 */
public interface IProfileService extends IService{
	
	/**
     * Initiates the constant NAME to IProfileService
     */
    public final String NAME = "IProfileService";

    /**
     * @param firstName
     * @return
     * @throws ProfileException
     */
    public boolean confirmValidFirstName(String firstName) throws ProfileException;

    /**
     * @param middleName
     * @return
     * @throws ProfileException
     */
    public boolean confirmValidMiddleName(String middleName) throws ProfileException;

    /**
     * @param lastName
     * @return
     * @throws ProfileException
     */
    public boolean confirmValidLastName(String lastName) throws ProfileException;

    /**
     * @param phoneNumber
     * @return
     * @throws ProfileException
     */
    public boolean confirmValidPhoneNumber(String phoneNumber) throws ProfileException;

    /**
     * @param passport
     * @return
     * @throws ProfileException
     */
    public boolean confirmValidPassport(String passport) throws ProfileException;

    /**
     * @param city
     * @return
     * @throws ProfileException
     */
    public boolean confirmValidCity(String city) throws ProfileException;

    /**
     * @param state
     * @return
     * @throws ProfileException
     */
    public boolean confirmValidState(String state) throws ProfileException;

    /**
     * @param zip
     * @return
     * @throws ProfileException
     */
    public boolean confirmValidZip(String zip) throws ProfileException;

    /**
     * @param testString
     * @return
     */
    public boolean stringContainsNumber(String testString);

    /**
     * @param profile
     * @return
     * @throws ProfileException
     */
    public boolean confirmValidProfile(Profile profile) throws ProfileException;

    /**
     * @param gender
     * @return
     * @throws ProfileException
     */
    public boolean confirmValidGender(char gender) throws ProfileException;

}
