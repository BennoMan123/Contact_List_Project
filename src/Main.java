import java.util.*;

/**
 * Client class to run the project and to be add to the list of contacts.
 */
public class Main implements textColors {
   /**
    * Scanner to scan in input from user.
    */
   private static Scanner scan = new Scanner(System.in);
   /**
    * Arraylist to store all of the contacts.
    */
   private static ArrayList<Contact> contactList = new ArrayList<Contact>();

   /**
    * Main method to run the program.
    * @param args Used for nothing
    */
   public static void main(String[] args) {
      // Print colored text to the console
      System.out.println(GREEN + "This text is green." + RESET);
      System.out.println(RED + "This text is red." + RESET);


      Contact contact1 = new Contact();
      contact1.setFirstName("john");
      contact1.setLastName("Cena");
      contact1.setBirthday(1, 21, 2001);
      System.out.println(contact1.getBirthday());

      Contact contact2 = new Contact();
      contact2.setFirstName("beth");
      contact2.setLastName("Cena");

      Contact contact4 = new Contact();
      contact4.setFirstName("michael");
      contact4.setLastName("Dal");
      addContact(contact4);

      Contact contact3 = new Contact();
      contact3.setFirstName("michael");
      contact3.setLastName("jackson");
      addContact(contact1);
      addContact(contact2);
      addContact(contact3);

      printContacts();
   }

   /*
   methods ideas:
   return all contacts
   return contacts within a certain alphabetical range
   return a specific contact
   add(check if the added contact already exists and then asks user if they want to still add it anyway)/remove/edit contacts
    */

   /**
    * Method to handle the add choice.
    */
   private static void add() {

   }

   /**
    * Adds contact to arraylist and sorts it.
    * @param x Contact to be added to arraylist
    * @throws NullPointerException if input is null
    */
   private static void addContact(Contact x) {
      if (isNull(x)) {
         throw new NullPointerException("Contact given is null.");
      }
      contactList.add(x);
      Collections.sort(contactList);
   }

   /**
    * Method to handle the edit choice.
    */
   private static void edit() {

   }

   /**
    * Method to handle the remove choice.
    */
   private static void remove() {

   }

   /**
    * Method to handle the range choice.
    */
   private static void range() {

   }

   /**
    * Prints all of the contacts within the given char range by last name.
    * @param start Beginning of range
    * @param end End of the range
    * @throws NullPointerException if input is null
    */
   private static void printInRange(char start, char end) {

   }

   /**
    * Returns contact(s) by first or last name. Returns null if there's no contact or contacts found.
    * @param nameType First or last name to be checked for the name.
    * @param name First/Last name requested to be return with contacts with said name.
    * @return Contacts with given first or last name.
    * @throws IllegalArgumentException if nameType parameter is invalid, (not first or last name)
    * @throws NullPointerException if input is null
    */
   private static ArrayList<Contact> returnContact(String nameType, String name) {
      if (isNull(nameType) || isNull(name)) {
         throw new NullPointerException("nameType or name given is null.");
      }
      /*
   maybe have it return an int, -1 for not having it or returning the first instance of it
    */
      nameType = nameType.toLowerCase(Locale.ROOT);
      if (contactList.isEmpty()) {
         return null;
      }

      ArrayList<Contact> returnList = new ArrayList<Contact>(0);
      if (nameType.equalsIgnoreCase("first") || nameType.contains("first")) {
         for (Contact contact : contactList) {
            if (contact.getFirstName().equalsIgnoreCase(name)) {
               returnList.add(contact);
            }
         }
      }
      else if (nameType.equalsIgnoreCase("last") || nameType.contains("last")) {
         for (Contact contact : contactList) {
            if (contact.getLastName().equalsIgnoreCase(name)) {
               returnList.add(contact);
            }
         }
      }
      else {
         throw new IllegalArgumentException("Invalid name type.");
      }

      if (returnList.size() == 0) {
         return null;
      }
      else {
         return returnList;
      }
   }

   /**
    * Prints all of the contacts in contact list.
    */
   private static void printContacts() {
      if (contactList.isEmpty()) {
         System.out.println(RED_UNDERLINED + "Contact list is empty." + RESET);
         return;
      }

      for (Contact contact : contactList) {
         System.out.println("==========================================");
         System.out.println(/*YELLOW_BOLD_BRIGHT +*/ contact/* + RESET*/);
         System.out.println("==========================================");
      }
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
}
