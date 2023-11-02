import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.*;

/**
 * Client class to run the project and to be add to the list of contacts.
 */
public class Main implements textColors {
   /**
    * Scanner to scan in input from user.
    */
   private static final Scanner scan = new Scanner(System.in);
   /**
    * Arraylist to store all of the contacts.
    */
   private static final ArrayList<Contact> contactList = new ArrayList<Contact>();

   private static final DrawingPanel p = new DrawingPanel(new File("spongebob_squinting.jpg"));
   private static final Graphics g = p.getGraphics();

   static {
      p.setVisible(false);
      Runtime.getRuntime().addShutdownHook(new Thread(
              new Runnable() {
                 public void run() {
                    System.out.println("Thank you for using this program.");
                 }
              }
              ));
   }

   /**
    * Main method to run the program.
    * @param args Used for nothing
    */
   public static void main(String[] args) {
      // Print colored text to the console
      System.out.println(GREEN + "This text is green." + RESET);
      System.out.println(RED + "This text is red." + RESET);
   
      while (true) {
         int input = -1;
         System.out.println("What would you like to do with your contact list?\n" +
                 "1. Add contact\n" +
                 "2. Remove contact\n" +
                 "3. Edit a contact\n" +
                 "4. Print entire contact list\n" +
                 "5. Print contacts in range of 2 letters.\n" +
                 "6. Clear all contacts\n" +
                 "7. Exit");
         try {
            input = scan.nextInt();
         }
         catch (InputMismatchException e) {
            System.out.println(RED_BOLD_BRIGHT + "***Invalid input.***\n" + RESET);
            scan.nextLine();
         }

         switch (input) {
            case 1:
               add();
               break;

            case 2:
               remove();
               break;

            case 3:
               edit();
               break;

            case 4:
               printContacts();
               break;

            case 5:
               range();
               break;

            case 6:
               contactList.clear();
               System.out.println(GREEN_BRIGHT + "Contact list has been cleared." + RESET);
               break;

            case 7:
               System.exit(0);

            default:
               System.out.println(RED_UNDERLINED + "Invalid input." + RESET);
               error();
               break;
         }
      }
   }

   /**
    * Temp method. Will remove.
    */
   public static void error() {
      p.setVisible(true);
      p.toFront();
      JOptionPane.showMessageDialog(null, "Why would you enter that?", "Invalid Input", JOptionPane.ERROR_MESSAGE);
      p.setVisible(false);
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
      System.out.println(GREEN_BRIGHT + "Add method." + RESET);
      addContact(new Contact());
      System.out.println(GREEN_BRIGHT + "Added a blank contact." + RESET);
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
      System.out.println(GREEN_BRIGHT + "Edit method." + RESET);
   }

   /**
    * Method to handle the remove choice.
    */
   private static void remove() {
      System.out.println(GREEN_BRIGHT + "Remove method." + RESET);
   }

   /**
    * Method to handle the range choice.
    */
   private static void range() {
      System.out.println(GREEN_BRIGHT + "Range method." + RESET);
      printInRange('a', 'b');
   }

   /**
    * Prints all of the contacts within the given char range by last name.
    * @param start Beginning of range
    * @param end End of the range
    * @throws NullPointerException if input is null
    */
   private static void printInRange(char start, char end) {
      System.out.println(GREEN_BRIGHT + "printInRange method." + RESET);
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
   
      nameType = nameType.toLowerCase();
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
         System.out.println(contact);
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
