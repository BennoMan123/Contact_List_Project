import java.util.Date;

public interface contactsInterface {
    /**
     * returns the creation time/date of the contact
     * @return date of creation
     */
    public Date getCreationTime();

    /**
     * returns the address of the contact
     * @return address of the contact in string form
     */
    public String getAddress();

    /**
     * sets address of the contact
     * @param address the address of the contact
     */
    public void setAddress(String address);

    /**
     * returns the first name of the contact
     * @return returns first name of the contact
     */
    public String getFirstName();

    /**
     * sets the first name of the contact
     * @param firstName last name of the contact
     */
    public void setFirstName(String firstName);

    /**
     * returns the last name of the contact
     * @return the last name of contact
     */
    public String getLastName();

    /**
     * sets the last name of the contact
     * @param lastName last name of the contact
     */
    public void setLastName(String lastName);

    /**
     * sets first and last name of the contact
     * @param firstName first name of contact
     * @param lastName last name of contact
     */
    public void setName(String firstName, String lastName);

    /**
     * returns the full name of the contact
     * @return string of the contact name
     */
    public String getName();

    /**
     * returns the phone number of the contact
     * @return the phone number of the contact
     */
    public String getPhoneNum();

    /**
     * sets the phone number of the contact
     * @param phoneNum the phone number of the contact
     */
    public void setPhoneNum(String phoneNum);

    /**
     * sets the birthday of the contact (using date parameter)
     * @param birthdayDate birthday date of the contact in date form
     */
    public void setBirthday(Date birthdayDate);

    /**
     * sets the birthday of the contact given the year, month, and day
     * @param month month of the birthdate
     * @param day day of the birthdate
     * @param year year of the birthdate
     */
    public void setBirthday(int month, int day, int year);

    /**
     * returns the birthday of the contact in MM/dd/yyyy form
     * @return birthdate of the contact in string form
     */
    public String getBirthday();

    /**
     * sets the notes about the contact
     * @param note notes about the contact
     */
    public void setNotes(String note);

    /**
     * adds to the notes about the contact
     * @param note notes to be added about the contact
     */
    public void addToNotes(String note);

    /**
     * returns the notes about the contact
     * @return
     */
    public String getNotes();
}
