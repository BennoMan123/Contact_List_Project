import org.jetbrains.annotations.NotNull;

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
      sleep(1000);

      Contact contact2 = new Contact();
      contact2.setFirstName("beth");
      contact2.setLastName("Cena");
      sleep(1000);

      Contact contact4 = new Contact();
      contact4.setFirstName("michael");
      contact4.setLastName("Dal");
      addContact(contact4);
      sleep(1000);

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
    */
   private static void addContact(@NotNull Contact x) {
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
    */
   private static void printInRange(@NotNull char start, @NotNull char end) {

   }

   /**
    * Returns contacts by first or last name. Returns null if there's no contacts or no contacts found.
    * @param nameType First or last name to be checked for the name.
    * @param name First/Last name requested to be return with contacts with said name.
    * @return Contacts with given first or last name.
    */
   private static ArrayList<Contact> returnContact(@NotNull String nameType, @NotNull String name) {
      /*
   maybe have it return an int, -1 for not having it or returning the first instance of it
    */
      if (contactList.isEmpty()) {
         return null;
      }

      ArrayList<Contact> returnList = new ArrayList<Contact>(0);
      if (nameType.equalsIgnoreCase("first")) {
         for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getFirstName().equalsIgnoreCase(name)) {
               returnList.add(contactList.get(i));
            }
         }
      }
      else if (nameType.equalsIgnoreCase("last")) {
         for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getLastName().equalsIgnoreCase(name)) {
               returnList.add(contactList.get(i));
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
   
      for (int i = 0; i < contactList.size(); i++) {
         System.out.println(/*YELLOW_BOLD_BRIGHT +*/ contactList.get(i)/* + RESET*/);
      }
   }

   /**
    * Temp method for testing.
    * @param milliSec milliseconds to sleep
    */
   private static void sleep(@NotNull long milliSec) {
      if (milliSec < 0) {
         return;
      }

      try {
         Thread.sleep(milliSec);
      }
      catch (Exception e) {
         System.out.println(RED + e + RESET);
      }
   }
}
