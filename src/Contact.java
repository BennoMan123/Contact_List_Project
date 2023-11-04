import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * <pre>
 * Class to hold information about a contact.
 * Holds information of:
 * * First and last name
 * * Address
 * * Phone number
 * * Birthday
 * * Any notes about the contact, if any
 * </pre>
 */
public class Contact implements contactsInterface, Comparable<Contact>, textColors {
    /**
     * Creation time/date of contact.
     */
    private final Date creationTime = new Date();
    /**
     * First name of contact.
     */
    private String firstName;
    /**
     * Last name of contact.
     */
    private String lastName;
    /**
     * Phone number of the contact.
     */
    private String phoneNum;
    /**
     * Birthday of the contact.
     */
    private Date birthday = null;
    /**
     * Notes about the contact.
     */
    private StringBuffer notes = new StringBuffer();
    /**
     * Address of the contact.
     */
    private String address = "N/A";


    /**
     * Default constructor; sets most to null or "" or "N/A".
     */
    public Contact() {
        firstName = "";
        lastName = "";
        phoneNum = "N/A";
    }

    /**
     * Sets first and last name; sets rest to default.
     * @param firstName First name of contact
     * @param lastName Last name of contact
     */
    public Contact(String firstName, String lastName) {
        setName(firstName, lastName);
        phoneNum = "N/A";
    }

    /**
     * Sets first and last name and the birthday given year, month, and day.
     * @param firstName First name of contact
     * @param lastName Last name of contact
     * @param birthdayMonth Birthday month of contact
     * @param birthdayDay Birthday day of contact
     * @param birthdayYear Birthday year of contact
     */
    public Contact(String firstName, String lastName, int birthdayMonth, int birthdayDay, int birthdayYear) {
        setName(firstName, lastName);
        setBirthday(birthdayMonth, birthdayDay, birthdayYear);
        phoneNum = "N/A";
    }

    /**
     * Sets first and last name, notes about the contact, and the birthday given year, month, and day.
     * @param firstName First name of contact
     * @param lastName Last name of contact
     * @param birthdayMonth Birthday month of contact
     * @param birthdayDay Birthday day of contact
     * @param birthdayYear Birthday year of contact
     * @param note Notes about the contact
     */
    public Contact(String firstName, String lastName, int birthdayMonth, int birthdayDay, int birthdayYear, String note) {
        this(firstName, lastName, birthdayMonth, birthdayDay, birthdayYear);
        setNotes(note);
    }

    /**
     * {@inheritDoc}
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * {@inheritDoc}
     */
    public String getAddress() {
        if (address.equalsIgnoreCase("N/A")) {
            return RED_BOLD_BRIGHT + address + RESET;
        }
        return address;
    }

    /**
     * {@inheritDoc}
     * @param address The address of the contact
     * @throws NullPointerException if input is null
     */
    public void setAddress(String address) {
        if (isNull(address)) {
            throw new NullPointerException("Address given is null.");
        }
        this.address = address;
    }

    /**
     * {@inheritDoc}
     * @see getLastName
     * @see getName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * {@inheritDoc}
     * @throws NullPointerException if input is null
     * @see setLastName(String)
     * @see setName(String, String)
     */
    public void setFirstName(String firstName) {
        if (isNull(firstName)) {
            throw new NullPointerException("First Name given is null.");
        }

        if (firstName.isEmpty()) {
            this.firstName = "";
            return;
        }

        if (!Character.isUpperCase(firstName.charAt(0))) {
            firstName = firstCharToUpper(firstName);
        }

        this.firstName = firstName;
    }

    /**
     * {@inheritDoc}
     * @see getFirstName
     * @see getName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * {@inheritDoc}
     * @throws NullPointerException if input is null
     * @see setFirstName(String)
     * @see setName(String, String)
     */
    public void setLastName(String lastName) {
        if (isNull(lastName)) {
            throw new NullPointerException("Last Name given is null.");
        }

        if (lastName.isEmpty()) {
            this.lastName = "";
            return;
        }

        if (!Character.isUpperCase(lastName.charAt(0))) {
            lastName = firstCharToUpper(lastName);
        }

        this.lastName = lastName;
    }

    /**
     * {@inheritDoc}
     * @param firstName First name of contact
     * @param lastName Last name of contact
     * @throws NullPointerException if input is null
     * @see setFirstName(String)
     * @see setLastName(String)
     */
    public void setName(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    /**
     * {@inheritDoc}
     * @see getFirstName
     * @see getLastName
     */
    @Override
    public String getName() {
        if (getFirstName().equals("") && getLastName().equals("")) {
            return RED_BOLD_BRIGHT + "No name given." + RESET;
        }
        return String.format("%s %s", firstName, lastName);
    }

    /**
     * {@inheritDoc}
     */
    public String getPhoneNum() {
        if (phoneNum.equalsIgnoreCase("N/A")) {
            return RED_BOLD_BRIGHT + phoneNum + RESET;
        }
        return phoneNum;
    }

    /**
     * {@inheritDoc}
     */
    public void setPhoneNum(String phoneNum) {
        if (isNull(phoneNum)) {
            throw new NullPointerException("Phone number inputted is null.");
        }
        //check if it contains dashes and also if the length of the number is 10 to add dashes
        //check if it contains the dashes, if not, add them by changing string to char array and adding them in
        this.phoneNum = phoneNum;
    }

    /**
     * {@inheritDoc}
     * @see setBirthday(int, int, int)
     */
    @Override
    public void setBirthday(Date birthdayDate) {
        if (!isNull(birthdayDate)) {
            this.birthday = birthdayDate;
        }
    }

    /**
     * {@inheritDoc}
     * @throws NullPointerException if input is null
     * @throws IllegalArgumentException if any of the inputs are out of range of a given month or day number or a date later than the current
     * @see setBirthday(Date)
     */
    public void setBirthday(int month, int day, int year) {
        Calendar myCal = Calendar.getInstance();

        //Checks if the month given is in range
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month inputted; Month given is less than 1 or more than 12.");
        }

        //Checks if the day is not less than 1
        if (day < 1) {
            throw new IllegalArgumentException("Day inputted is less than 1.");
        }

        //Checks if the day is in range of February (and if it's leap year)
        if (month == 2 && day > 28 && !isLeapYear(year)) {
            throw new IllegalArgumentException("Invalid day inputted.");
        }
        if (month == 2 && day > 29 && isLeapYear(year)) {
            throw new IllegalArgumentException("Invalid day inputted.");
        }

        //Checks if the day is in range of the month (months having 31 days and then 30 days)
        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) &&
                (day > 31)) {
            throw new IllegalArgumentException("Invalid day inputted; Day is greater than the last day of the month. Must be 1-31");
        }
        if ((month == 4 || month == 6 || month == 9 || month == 11) && (day > 30)) {
            throw new IllegalArgumentException("Invalid day inputted; Day is greater than the last day of the month. Must be 1-30");
        }

        //Checks if the year, day, month is later than the current
        if (year > Year.now().getValue()) {
            throw new IllegalArgumentException("Year can not be later than current year.");
        }
        if (year == Year.now().getValue() && (month > LocalDate.now().getMonth().getValue() || LocalDate.now().getDayOfMonth() < day)) {
            throw new IllegalArgumentException("Day or month can not be later than current time.");
        }

        //Sets the birthdate
        myCal.set(Calendar.YEAR, year);
        myCal.set(Calendar.MONTH, month-1);
        myCal.set(Calendar.DAY_OF_MONTH, day);
        setBirthday(myCal.getTime());
    }

    /**
     * {@inheritDoc}
     * Returns N/A if there's no birthday given
     */
    @Override
    public String getBirthday() {
        if (isNull(birthday)) {
            return RED_BOLD_BRIGHT + "N/A" + RESET;
        }

        return new SimpleDateFormat("MM/dd/yyyy").format(birthday);
    }

    /**
     * {@inheritDoc}
     * @throws NullPointerException if input is null
     * @see addToNotes(String)
     */
    @Override
    public void setNotes(String note) {
        if (isNull(note)) {
            throw new NullPointerException("Note sent in is null.");
        }
        notes = new StringBuffer(note + "\n");
    }

    /**
     * {@inheritDoc}
     * @throws NullPointerException if input is null
     * @see setNotes(String)
     */
    @Override
    public void addToNotes(String note) {
        if (isNull(note)) {
            throw new NullPointerException("Note sent in is null.");
        }

        notes.append(note + "\n");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNotes() {
        String Notes = "Notes:\n";

        if (notes.isEmpty()) {
            return Notes + "No notes entered.";
        }

        return Notes + notes.toString().trim();
    }

    /**
     * Compares the contacts first by last name, then by last name.
     * @param o Contact to be compared to this one
     * @return Returns if less than, equal to, or greater than the last name, then first name if equal
     */
    @Override
    public int compareTo(Contact o) {
        if (String.CASE_INSENSITIVE_ORDER.compare(this.lastName, o.getLastName()) == 0) {
            return String.CASE_INSENSITIVE_ORDER.compare(this.firstName, o.getFirstName());
        }
        else {
            return String.CASE_INSENSITIVE_ORDER.compare(this.lastName, o.getLastName());
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean isContactEmpty() {
        return address.equals("N/A") && phoneNum.equals("N/A") && notes.isEmpty() && firstName.equals("") && lastName.equals("") && isNull(birthday);
    }

    /**
     * Sets the first letter of the inputted to a capital of the letter.
     * @param str The word to have the first letter be turned to uppercase
     * @return String with the first letter turned to an uppercase, returns null if the string is null, returns "" if empty
     */
    private static String firstCharToUpper(String str) {
        if (isNull(str)) {
            return null;
        }

        if (str.isEmpty()) {
            return "";
        }

        char[] word = str.toCharArray();
        word[0] = ("" + word[0]).toUpperCase().charAt(0);
        return new String(word);
    }

    /**
     * Returns if the year given is a leap year or not.
     * @param year Year to be checked for leap year or not
     * @return True if a leap year, false if not
     * @throws NullPointerException if input is null
     */
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }

    /**
     * <pre>
     * Returns if the object given is null or not.
     * See similar: {@link Objects#isNull(Object)}
     * </pre>
     * @param o Any object
     * @return If it is null or not
     */
    private static boolean isNull(Object o) {
        return Objects.isNull(o);
    }

    /**
     * Returns the string of the contact information.
     * @return Contact information of a contact
     */
    @Override
    public String toString() {
        return String.format("%sName: %s\nPhone Number: %s\nAddress: %s\nBirthday: %s\n%s%s",
                GREEN_BRIGHT, getName() + GREEN_BRIGHT, getPhoneNum() + GREEN_BRIGHT, getAddress() + GREEN_BRIGHT, getBirthday() + GREEN_BRIGHT, getNotes(), RESET);
    }
}
