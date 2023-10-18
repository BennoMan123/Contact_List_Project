import java.util.Date;
import java.util.Locale;

public class Contact implements Comparable<Contact> {
    private Date creationTime = new Date();
    private String firstName, lastName;
    private String phoneNum;


    public Contact() {
        firstName = "N/A";
        lastName = "N/A";
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (!Character.isUpperCase(firstName.charAt(0))) {
            firstName = firstCharToUpper(firstName);
        }

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (!Character.isUpperCase(lastName.charAt(0))) {
            lastName = firstCharToUpper(lastName);
        }

        this.lastName = lastName;
    }

    public void setName(String firstName, String lastName) {
        setLastName(lastName);
        setFirstName(firstName);
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        //check if it contains dashes and also if the length of the number is 10 to add dashes
        //check if it contains the dashes, if not, add them by changing string to char array and adding them in
        //this.phoneNum = phoneNum;
    }

    @Override
    public int compareTo(Contact o) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.lastName, o.lastName);
    }

    private static String firstCharToUpper(String str) {
        char[] word = str.toCharArray();
        String char0 = "" + word[0];
        char0 = char0.toUpperCase();
        word[0] = char0.charAt(0);
        return str = new String(word);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}' + "Created on " + creationTime.toString();
    }
}
