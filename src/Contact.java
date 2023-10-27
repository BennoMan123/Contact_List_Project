import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Contact implements contactsInterface, Comparable<Contact>, textColors {
    private Date creationTime = new Date();
    private String firstName, lastName;
    private String phoneNum;
    private Date birthday = null;
    private StringBuffer notes = new StringBuffer();
    private String Address = "N/A";


    public Contact() {
        firstName = "";
        lastName = "";
        phoneNum = "N/A";
    }

    public Contact(String firstName, String lastName) {
        setName(firstName, lastName);
        phoneNum = "N/A";
    }

    public Contact(String firstName, String lastName, int birthdayMonth, int birthdayDay, int birthdayYear) {
        setName(firstName, lastName);
        setBirthday(birthdayMonth, birthdayDay, birthdayYear);
        phoneNum = "N/A";
    }

    public Contact(String firstName, String lastName,
                   int birthdayMonth, int birthdayDay, int birthdayYear, String note) {
        this(firstName, lastName, birthdayMonth, birthdayDay, birthdayYear);
        setNotes(note);
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getFirstName() {
        return firstName;
    }

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

    public String getLastName() {
        return lastName;
    }

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

    public void setName(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        //check if it contains dashes and also if the length of the number is 10 to add dashes
        //check if it contains the dashes, if not, add them by changing string to char array and adding them in
        this.phoneNum = phoneNum;
    }

    @Override
    public void setBirthday(Date birthdayDate) {
        if (!isNull(birthdayDate)) {
            this.birthday = birthdayDate;
        }
    }

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

        //Sets the birthday date
        myCal.set(Calendar.YEAR, year);
        myCal.set(Calendar.MONTH, month-1);
        myCal.set(Calendar.DAY_OF_MONTH, day);
        setBirthday(myCal.getTime());
    }

    @Override
    public String getBirthday() {
        if (isNull(birthday)) {
            return RED_BOLD_BRIGHT + "No birthday given." + RESET;
        }

        return new SimpleDateFormat("MM/dd/yy").format(birthday);
    }

    @Override
    public void setNotes(String note) {
        if (isNull(note)) {
            throw new NullPointerException("Note sent in is null.");
        }
        notes = new StringBuffer(note + "\n");
    }

    @Override
    public void addToNotes(String note) {
        if (isNull(note)) {
            throw new NullPointerException("Note sent in is null.");
        }

        notes.append(note + "\n");
    }

    @Override
    public String getNotes() {
        String Notes = "Notes:\n";

        if (notes.isEmpty()) {
            return Notes + "No notes entered.";
        }

        return Notes + notes.toString();
    }

    @Override
    public int compareTo(Contact o) {
        if (String.CASE_INSENSITIVE_ORDER.compare(this.lastName, o.getLastName()) == 0) {
            return String.CASE_INSENSITIVE_ORDER.compare(this.firstName, o.getFirstName());
        }
        else {
            return String.CASE_INSENSITIVE_ORDER.compare(this.lastName, o.getLastName());
        }
    }

    private static String firstCharToUpper(String str) {
        if (str.isBlank()) {
            return null;
        }

        char[] word = str.toCharArray();
        String char0 = "" + word[0];
        char0 = char0.toUpperCase();
        word[0] = char0.charAt(0);
        return new String(word);
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0)&& (year % 100 != 0 || year % 400 == 0);//;]isLeapYear;
    }

    private static boolean isNull(Object o) {
        return Objects.isNull(o);
    }

    @Override
    public String toString() {
        return GREEN_BRIGHT + "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}' +"Birthday: " + getBirthday() + "\tCreated on " + creationTime.toString() + RESET;
    }
}
