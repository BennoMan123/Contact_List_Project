import java.util.Date;
import java.util.Objects;

public class Contact implements Comparable<Contact>, textColors {
    private Date creationTime = new Date();
    private String firstName, lastName;
    private String phoneNum;


    public Contact() {
        firstName = "N/A";
        lastName = "N/A";
        phoneNum = "N/A";
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
        if (Objects.isNull(firstName)) {
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
        if (Objects.isNull(lastName)) {
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
        if (String.CASE_INSENSITIVE_ORDER.compare(this.lastName, o.lastName) == 0) {
            return String.CASE_INSENSITIVE_ORDER.compare(this.firstName, o.firstName);
        }
        else {
            return String.CASE_INSENSITIVE_ORDER.compare(this.lastName, o.lastName);
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

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}' + "Created on " + creationTime.toString();
    }
}
