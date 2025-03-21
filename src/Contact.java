import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * <pre>
 * Class to hold information about a contact.
 * Information stored:
 * * First and last name
 * * Address
 * * Phone number
 * * Birthday
 * * Any notes about the contact
 * </pre>
 */
public class Contact implements Cloneable, Comparable<Contact>, contactsInterface, textColors {
   /**
    * Formatting for dates.
    */
   private static SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
   /**
    * Creation time/date of contact.
    */
   private final Date creationTime = new Date();
   /**
    * Time/date of contact being updated.
    */
   private final Date updatedTime = new Date(creationTime.getTime());
   /**
    * First name of the contact.
    */
   private String firstName = "";
   /**
    * Last name of the contact.
    */
   private String lastName = "";
   /**
    * Phone number of the contact.
    */
   private String phoneNum = "N/A";
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
    * True if there's nothing set in the contact, false otherwise.
    */
   private boolean isEmpty = true;


   /**
    * Default constructor; sets variables to null, "", or "N/A".
    */
   public Contact() {}

   /**
    * Used for cloning.
    * @param firstName first name
    * @param lastName last name
    * @param phoneNum phone number
    * @param birthday birthday
    * @param notes notes
    * @param address address
    * @param isEmpty if contact is empty or not
    */
   private Contact(String firstName, String lastName, String phoneNum, Date birthday, StringBuffer notes, String address, boolean isEmpty) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.phoneNum = phoneNum;
      this.birthday = birthday;
      this.notes = notes;
      this.address = address;
      this.isEmpty = isEmpty;
   }

   /**
    * Sets first and last name; sets rest to default.
    * @param firstName First name of contact
    * @param lastName Last name of contact
    * @throws NullPointerException if first or last name is null
    */
   public Contact(String firstName, String lastName) {
      setName(firstName, lastName);
   }

   /**
    * Sets first and last name and the birthday given month, day, and year.
    * @param firstName First name of contact
    * @param lastName Last name of contact
    * @param birthdayMonth Birthday month of contact
    * @param birthdayDay Birthday day of contact
    * @param birthdayYear Birthday year of contact
    * @throws NullPointerException if first or last name is null
    * @throws IllegalArgumentException if any of the int inputs are out of range
    */
   public Contact(String firstName, String lastName, int birthdayMonth, int birthdayDay, int birthdayYear) {
      this(firstName, lastName);
      setBirthday(birthdayMonth, birthdayDay, birthdayYear);
   }

   /**
    * Sets first and last name, notes about the contact, and the birthday given month, day, and year.
    * @param firstName First name of contact
    * @param lastName Last name of contact
    * @param birthdayMonth Birthday month of contact
    * @param birthdayDay Birthday day of contact
    * @param birthdayYear Birthday year of contact
    * @param note Notes about the contact
    * @throws NullPointerException if first or last name is null or notes is null
    * @throws IllegalArgumentException if any of the int inputs are out of range
    * @throws IllegalLengthException if there's no notes given.
    */
   public Contact(String firstName, String lastName, int birthdayMonth, int birthdayDay, int birthdayYear, String note) {
      this(firstName, lastName, birthdayMonth, birthdayDay, birthdayYear);
      setNotes(note);
   }

   /**
    * For adding to csv file.
    * In the order of first name,last name,phone number, birthday birthday long, notes, address.
    * @return a line suitable for csv files
    */
   public String getCsvLine() {
      return String.format("%s, %s, %s,%s %s, %s, %s\n",
              convertForCSV(firstName),
              convertForCSV(lastName),
              convertForCSV(phoneNum),
              Objects.isNull(birthday) ? "N/A" : getBirthday(),
              Objects.isNull(birthday) ? Long.toString(Long.MAX_VALUE) : Long.toString(birthday.getTime()),
              notes.toString().replace("Notes:\n", ""),
              convertForCSV(address));
   }

   /**
    * Internal method that converts a string to a string usable for the csv file.
    * @param str string to be converted
    * @return String converted.
    */
   private static String convertForCSV(String str) {
      return Objects.isNull(str) || str.equals("N/A") ? "" : str;
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
    * @throws IllegalLengthException if there's an empty string given
    */
   public void setAddress(String address) {
      Objects.requireNonNull(address, "Address given is null.");
      if (address.isEmpty()){
         throw new IllegalLengthException("Illegal length of address; No address is given.");
      }
      this.address = address;
      if (isEmpty)
         isEmpty = false;
      setUpdatedTime();
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
      Objects.requireNonNull(firstName, "First Name given is null.");
   
      if (firstName.isEmpty()) {
         this.firstName = "";
         return;
      }

      if (Character.isLetter(firstName.charAt(0)) && !Character.isUpperCase(firstName.charAt(0))) {
         firstName = firstCharToUpper(firstName);
      }
   
      this.firstName = firstName;
      if (isEmpty)
         isEmpty = false;
      setUpdatedTime();
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
      Objects.requireNonNull(lastName, "Last Name given is null.");
   
      if (lastName.isEmpty()) {
         this.lastName = "";
         return;
      }
   
      if (Character.isLetter(lastName.charAt(0)) && !Character.isUpperCase(lastName.charAt(0))) {
         lastName = firstCharToUpper(lastName);
      }
   
      this.lastName = lastName;
      if (isEmpty)
         isEmpty = false;
      setUpdatedTime();
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
      Objects.requireNonNull(firstName, "First name given is null.");
      Objects.requireNonNull(lastName, "Last name given is null.");
   
      setFirstName(firstName);
      setLastName(lastName);
   }

   /**
    * {@inheritDoc}
    * @see getFirstName
    * @see getLastName
    */
   public String getName() {
      if (firstName.equals("") && lastName.equals("")) {
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
    * @throws NullPointerException if input is null
    * @throws IllegalLengthException if length of input given is equal to 0
    * @throws IllegalArgumentException if the phone number contains a letter or a punctuation mark that's not a dash. Also thrown if the first or last characters are dashes.
    */
   public void setPhoneNum(String phoneNum) {
      Objects.requireNonNull(phoneNum, "Phone number given is null.");
   
      if (phoneNum.length() < 1 || phoneNum.length() > 10) {
         throw new IllegalLengthException("Illegal length of phone number; Must be between 1 and 10.");
      }

      if (phoneNum.matches(".*[a-zA-Z]+.*")) {
         throw new IllegalArgumentException("Phone number can't contain letters or punctuation; It can only be numbers and dashes.");
      }

      if (phoneNum.charAt(0) == '-' || phoneNum.charAt(phoneNum.length() - 1) == '-') {
         throw new IllegalArgumentException("Dash can't be the first and/or last character of the phone number.");
      }

      for (int i = 0; i < phoneNum.length(); i++) {
         String str = "" + phoneNum.charAt(i);
         if (Pattern.matches("[\\p{Punct}\\p{IsPunctuation}]", str) && !str.equals("-")) {
            throw new IllegalArgumentException("Phone number can't contain letters or non-dash punctuation; It can only be numbers and dashes.");
         }
      }

      if ((phoneNum.length() == 10 || phoneNum.length() == 9) && !phoneNum.contains("-")) {
         char[] number = phoneNum.toCharArray();
         char[] finalNumber = new char[phoneNum.length() + 2];
         int indexOfNumber = 0;
         for (int i  = 0; i < finalNumber.length; i++) {
            if (i == 3 || i == 7) {
               finalNumber[i] = '-';
            }
            else {
               finalNumber[i] = number[indexOfNumber];
               indexOfNumber++;
            }
         }
         this.phoneNum = new String(finalNumber);
      }
      else if ((phoneNum.length() == 7 || phoneNum.length() == 6) && !phoneNum.contains("-")) {
         char[] number = phoneNum.toCharArray();
         char[] finalNumber = new char[phoneNum.length() + 1];
         int indexOfNumber = 0;
         for (int i  = 0; i < finalNumber.length; i++) {
            if (i == 3) {
               finalNumber[i] = '-';
            }
            else {
               finalNumber[i] = number[indexOfNumber];
               indexOfNumber++;
            }
         }
         this.phoneNum = new String(finalNumber);
      }
      else if (phoneNum.length() == 8 && !phoneNum.contains("-")) {
         char[] number = phoneNum.toCharArray();
         char[] finalNumber = new char[9];
         int indexOfNumber = 0;
         for (int i  = 0; i < finalNumber.length; i++) {
            if (i == 4) {
               finalNumber[i] = '-';
            }
            else {
               finalNumber[i] = number[indexOfNumber];
               indexOfNumber++;
            }
         }
         this.phoneNum = new String(finalNumber);
      }
      else {
         this.phoneNum = phoneNum;
      }

      if (isEmpty)
         isEmpty = false;
      setUpdatedTime();
   }

   /**
    * {@inheritDoc}
    * @see setBirthday(int, int, int)
    * @throws NullPointerException if given input is null.
    */
   public void setBirthday(Date birthdayDate) {
      this.birthday = compareDate(Objects.requireNonNull(birthdayDate, "Date given is null."));

      if (isEmpty)
         isEmpty = false;
      setUpdatedTime();
   }

   /**
    * Compares date to current to make sure it is not before the current year.
    * @param date the date to be checked.
    * @return the date if good
    */
   private static Date compareDate(Date date) {
      String[] testing = dateFormat.format(Objects.requireNonNull(date)).split("/");
      String[] current = dateFormat.format(new Date()).split("/");

      if (Integer.parseInt(current[2]) < Integer.parseInt(testing[2])) {
         throw new IllegalArgumentException("Invalid year given");
      }

      if (Integer.parseInt(current[2]) == Integer.parseInt(testing[2]) && (Integer.parseInt(current[0]) < Integer.parseInt(testing[0]) || Integer.parseInt(current[1]) < Integer.parseInt(testing[1])))
         throw new IllegalArgumentException("Invalid month/day given");

      return date;
   }

   /**
    * {@inheritDoc}
    * @throws IllegalArgumentException if any of the inputs are out of range of a given month or day number or a date later than the current
    * @throws NullPointerException if input is null
    * @see setBirthday(Date)
    */
   public void setBirthday(int month, int day, int year) {
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
      Calendar myCal = Calendar.getInstance();
      myCal.set(Calendar.YEAR, year);
      myCal.set(Calendar.MONTH, month-1);
      myCal.set(Calendar.DAY_OF_MONTH, day);
      setBirthday(myCal.getTime());
   }

   /**
    * {@inheritDoc}
    * Returns N/A if there's no birthday given
    */
   public String getBirthday() {
      if (Objects.isNull(birthday)) {
         return RED_BOLD_BRIGHT + "N/A" + RESET;
      }
      return dateFormat.format(birthday);
   }

   /**
    * {@inheritDoc}
    * @throws NullPointerException if input is null
    * @throws IllegalLengthException if length of input given is equal to 0
    * @see addToNotes(String)
    */
   public void setNotes(String note) {
      Objects.requireNonNull(note, "Note given is null.");
   
      if (note.isEmpty()){
         throw new IllegalLengthException("Illegal length of notes given.");
      }
      notes = new StringBuffer(note).append(note.endsWith(";") || note.endsWith("; ") ? "" : "; ");
      if (isEmpty)
         isEmpty = false;
      setUpdatedTime();
   }

   /**
    * {@inheritDoc}
    * @throws NullPointerException if input is null
    * @see setNotes(String)
    */
   public void addToNotes(String note) {
      Objects.requireNonNull(note, "Note given is null.");
      if (note.isEmpty()){
         return;
      }
   
      notes.append(note).append(note.endsWith(";") || note.endsWith("; ") ? "" : "; ");
      if (isEmpty)
         isEmpty = false;
      setUpdatedTime();
   }

   /**
    * {@inheritDoc}
    */
   public String getNotes() {
      String Notes = "Notes:\n";
   
      if (notes.length() == 0) {
         return Notes + RED_BOLD_BRIGHT + "No notes entered." + RESET;
      }
   
      return Notes + notes.toString().trim();
   }

   /**
    * Returns the updated date and time of the contact.
    * @return the date of when the contact was last updated
    */
   public Date getUpdatedTime() {
      return updatedTime;
   }

   /**
    * Updates the updated time to current time.
    */
   private void setUpdatedTime() {
      updatedTime.setTime(System.currentTimeMillis());
   }

   /**
    * Compares the contacts first by last name, then by last name.
    * @param o Contact to be compared to this one
    * @return Returns if less than, equal to, or greater than the last name, then first name if equal
    */
   @Override
   public int compareTo(Contact o) {
      if (String.CASE_INSENSITIVE_ORDER.compare(this.lastName, o.lastName) == 0) {
         if (String.CASE_INSENSITIVE_ORDER.compare(this.firstName, o.firstName) == 0) {
            return creationTime.compareTo(o.creationTime);
         }
         return String.CASE_INSENSITIVE_ORDER.compare(this.firstName, o.firstName);
      }
      else {
         return String.CASE_INSENSITIVE_ORDER.compare(this.lastName, o.lastName);
      }
   }

   /**
    * {@inheritDoc}
    */
   public boolean isContactEmpty() {
      return isEmpty;
   }

   /**
    * Sets the first letter of the inputted to a capital of the letter.
    * @param str The word to have the first letter be turned to uppercase
    * @return String with the first letter turned to an uppercase, returns null if the string is null, returns "" if empty
    */
   public static String firstCharToUpper(String str) {
      if (Objects.isNull(str)) {
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
    */
   public static boolean isLeapYear(int year) {
      return new GregorianCalendar().isLeapYear(year);
   }

   /**
    * Returns the string of the contact information.
    * @return Contact information of a contact
    */
   @Override
   public String toString() {
      return String.format("%sName: %s\nPhone Number: %s\nAddress: %s\nBirthday: %s\n%s\nCreated on %s\nLast Updated: %s%s",
             GREEN_BRIGHT, getName() + GREEN_BRIGHT, getPhoneNum() + GREEN_BRIGHT, getAddress() + GREEN_BRIGHT,
             getBirthday() + GREEN_BRIGHT, getNotes() + GREEN_BRIGHT, getCreationTime().toString(), getUpdatedTime().toString(), RESET);
   }

   /**
    * Creates a copy of an instance of Contact with the same attributes.
    * @return a copy of the contact
    */
   @Override
   public Object clone() {
      return new Contact(firstName, lastName, phoneNum, birthday, notes, address, isEmpty);
   }
}