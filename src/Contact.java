import java.text.SimpleDateFormat;
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

    public Contact(String firstName, String lastName, String phoneNum, int birthdayMonth, int birthdayDay, int birthdayYear) {
        this(firstName, lastName, birthdayMonth, birthdayDay, birthdayYear);
        setPhoneNum(phoneNum);
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
        /*
        *****Check if everything is in range!!!***
         */
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

    private static boolean isNull(Object o) {
        return Objects.isNull(o);
    }


    @Override
    public String toString() {
        return GREEN_BRIGHT + "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}' + "Created on " + creationTime.toString() + RESET;
    }
}
