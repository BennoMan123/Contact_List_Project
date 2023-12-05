import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

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
public class Contact implements contactsInterface, Comparable<Contact>, textColors {
   /**
    * Creation time/date of contact.
    */
   private final Date creationTime = new Date();
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
   public Contact() {
   }

   /**
    * Sets first and last name; sets rest to default.
    * @param firstName First name of contact
    * @param lastName Last name of contact
    * @throws NullPointerException if first or last name is null
    */
   public Contact(String firstName, String lastName) {
      ensureNotNull(firstName, "First name given is null.");
      ensureNotNull(lastName, "Last name given is null.");
      setFirstName(firstName);
      setLastName(lastName);
      if (isEmpty) {
         isEmpty = false;
      }
   }

   /**
    * Sets first and last name and the birthday given month, day, and year.
    * @param firstName First name of contact
    * @param lastName Last name of contact
    * @param birthdayMonth Birthday month of contact
    * @param birthdayDay Birthday day of contact
    * @param birthdayYear Birthday year of contact
    * @throws NullPointerException if first or last name is null
    */
   public Contact(String firstName, String lastName, int birthdayMonth, int birthdayDay, int birthdayYear) {
      this(firstName, lastName);
      setBirthday(birthdayMonth, birthdayDay, birthdayYear);
      if (isEmpty) {
         isEmpty = false;
      }
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
    * @throws IllegalLengthException if there's no notes given.
    */
   public Contact(String firstName, String lastName, int birthdayMonth, int birthdayDay, int birthdayYear, String note) {
      this(firstName, lastName, birthdayMonth, birthdayDay, birthdayYear);
      setNotes(note);
      if (isEmpty) {
         isEmpty = false;
      }
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
      ensureNotNull(address, "Address given is null.");
      if (address.isEmpty()){
         throw new IllegalLengthException("Illegal length of address.");
      }
      this.address = address;
      if (isEmpty) {
         isEmpty = false;
      }
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
      ensureNotNull(firstName, "First Name given is null.");
   
      if (firstName.isEmpty()) {
         this.firstName = "";
         return;
      }
   
      if (!Character.isUpperCase(firstName.charAt(0))) {
         firstName = firstCharToUpper(firstName);
      }
   
      this.firstName = firstName;
      if (isEmpty) {
         isEmpty = false;
      }
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
      ensureNotNull(lastName, "Last Name given is null.");
   
      if (lastName.isEmpty()) {
         this.lastName = "";
         return;
      }
   
      if (!Character.isUpperCase(lastName.charAt(0))) {
         lastName = firstCharToUpper(lastName);
      }
   
      this.lastName = lastName;
      if (isEmpty) {
         isEmpty = false;
      }
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
      ensureNotNull(firstName, "First name given is null.");
      ensureNotNull(lastName, "Last name given is null.");
   
      setFirstName(firstName);
      setLastName(lastName);
      if (isEmpty) {
         isEmpty = false;
      }
   }

   /**
    * {@inheritDoc}
    * @see getFirstName
    * @see getLastName
    */
   @Override
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
    */
   public void setPhoneNum(String phoneNum) {
      ensureNotNull(phoneNum, "Phone number given is null.");
   
      if (phoneNum.length() < 1) {
         throw new IllegalLengthException("Illegal length of phone number.");
      }
      if (phoneNum.length() == 10) {
         char[] number = phoneNum.toCharArray();
         char[] finalNumber = new char[12];
         int indexOfnumber = 0;
         for (int i  = 0; i < finalNumber.length; i++) {
            if (i == 3 || i == 7) {
               finalNumber[i] = '-';
            }
            else {
               finalNumber[i] = number[indexOfnumber];
               indexOfnumber++;
            }
         
         }
         this.phoneNum = new String(finalNumber);
         if (isEmpty) {
            isEmpty = false;
         }
         return;
      }
      this.phoneNum = phoneNum;
      if (isEmpty) {
         isEmpty = false;
      }
   }

   /**
    * {@inheritDoc}
    * @see setBirthday(int, int, int)
    * @throws NullPointerException if given input is null.
    */
   @Override
   public void setBirthday(Date birthdayDate) {
      ensureNotNull(birthdayDate, "Date given is null.");
   
      this.birthday = birthdayDate;
      if (isEmpty) {
         isEmpty = false;
      }
   }

   /**
    * {@inheritDoc}
    * @throws IllegalArgumentException if any of the inputs are out of range of a given month or day number or a date later than the current
    * @throws NullPointerException if input is null
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
      if (Objects.isNull(birthday)) {
         return RED_BOLD_BRIGHT + "N/A" + RESET;
      }
   
      return new SimpleDateFormat("M/dd/yyyy").format(birthday);
   }

   /**
    * {@inheritDoc}
    * @throws NullPointerException if input is null
    * @throws IllegalLengthException if length of input given is equal to 0
    * @see addToNotes(String)
    */
   @Override
   public void setNotes(String note) {
      ensureNotNull(note, "Note given is null.");
   
      if (note.isEmpty()){
         throw new IllegalLengthException("Illegal length of notes given.");
      }
      notes = new StringBuffer(note + "\n");
      if (isEmpty) {
         isEmpty = false;
      }
   }

   /**
    * {@inheritDoc}
    * @throws NullPointerException if input is null
    * @throws IllegalLengthException if length of input given is equal to 0
    * @see setNotes(String)
    */
   @Override
   public void addToNotes(String note) {
      ensureNotNull(note, "Note given is null.");
   
      if (note.isEmpty()){
         throw new IllegalLengthException("Illegal length of notes given.");
      }
   
      notes.append(note + "\n");
      if (isEmpty) {
         isEmpty = false;
      }
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String getNotes() {
      String Notes = "Notes:\n";
   
      if (notes.length() == 0) {
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
      if (String.CASE_INSENSITIVE_ORDER.compare(this.lastName, o.lastName) == 0) {
         if (String.CASE_INSENSITIVE_ORDER.compare(this.firstName, o.firstName) == 0) {
            return String.CASE_INSENSITIVE_ORDER.compare(this.creationTime.toString(), o.creationTime.toString());
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
      return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
   }

   /**
    * Checks if the object given is null or not. Throws exception if the object is null, does nothing otherwise.
    * @param o Any object
    * @param errorMessage error message if and when error is thrown
    * @throws NullPointerException if object is null
    */
   public static void ensureNotNull(Object o, String errorMessage) {
      if (Objects.isNull(o)) {
         throw new NullPointerException(errorMessage);
      }
   }

   /**
    * Returns the string of the contact information.
    * @return Contact information of a contact
    */
   @Override
   public String toString() {
      return String.format("%sName: %s\nPhone Number: %s\nAddress: %s\nBirthday: %s\n%s\nCreated on %s%s",
             GREEN_BRIGHT, getName() + GREEN_BRIGHT, getPhoneNum() + GREEN_BRIGHT, getAddress() + GREEN_BRIGHT,
             getBirthday() + GREEN_BRIGHT, getNotes(), getCreationTime().toString(), RESET);
   }
}