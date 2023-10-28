import java.util.Date;

/**
 * Template for the Contact class.
 */
public interface contactsInterface {
    /**
     * Returns the creation time/date of the contact.
     * @return Date of creation
     */
    public Date getCreationTime();

    /**
     * Returns the address of the contact.
     * @return Address of the contact in string form
     */
    public String getAddress();

    /**
     * Sets address of the contact.
     * @param address The address of the contact
     */
    public void setAddress(String address);

    /**
     * Returns the first name of the contact.
     * @return Returns first name of the contact
     * @see getLastName
     * @see getName
     */
    public String getFirstName();

    /**
     * Sets the first name of the contact.
     * @param firstName First name of the contact
     * @see setLastName(String)
     * @see setName(String, String)
     */
    public void setFirstName(String firstName);

    /**
     * Returns the last name of the contact.
     * @return The last name of contact
     * @see getFirstName
     * @see getName
     */
    public String getLastName();

    /**
     * Sets the last name of the contact.
     * @param lastName Last name of the contact
     * @see setFirstName(String)
     * @see setName(String, String)
     */
    public void setLastName(String lastName);

    /**
     * Sets first and last name of the contact.
     * @param firstName First name of contact
     * @param lastName Last name of contact
     * @see setFirstName(String)
     * @see setLastName(String)
     */
    public void setName(String firstName, String lastName);

    /**
     * Returns the full name of the contact.
     * @return First and last name of the contact
     * @see getFirstName
     * @see getLastName
     */
    public String getName();

    /**
     * Returns the phone number of the contact.
     * @return The phone number of the contact
     */
    public String getPhoneNum();

    /**
     * Sets the phone number of the contact.
     * @param phoneNum The phone number of the contact
     */
    public void setPhoneNum(String phoneNum);

    /**
     * Sets the birthday of the contact.
     * @param birthdayDate Birthday date of the contact in date form
     * @see setBirthday(int, int, int)
     */
    public void setBirthday(Date birthdayDate);

    /**
     * Sets the birthday of the contact given the year, month, and day.
     * @param month Month of the birthdate
     * @param day Day of the birthdate
     * @param year Year of the birthdate
     * @see setBirthday(Date)
     */
    public void setBirthday(int month, int day, int year);

    /**
     * Returns the birthday of the contact in MM/dd/yyyy form.
     * @return birthdate of the contact in string form
     */
    public String getBirthday();

    /**
     * Sets the notes about the contact.
     * @param note Notes about the contact
     * @see addToNotes(String)
     */
    public void setNotes(String note);

    /**
     * Adds to the notes about the contact.
     * @param note Notes to be added about the contact
     * @see setNotes(String)
     */
    public void addToNotes(String note);

    /**
     * Returns the notes about the contact.
     * @return Returns the notes about the contact
     */
    public String getNotes();
}
