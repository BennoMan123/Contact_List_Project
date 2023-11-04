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

   static {
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
      while (true) {
         int input = -1;
         System.out.println(YELLOW_BOLD_BRIGHT + "What would you like to do with your contact list?\n" +
                 "1. Add contact\n" +
                 "2. Remove a contact\n" +
                 "3. Edit a contact\n" +
                 "4. Print the entire contact list\n" +
                 "5. Print contacts in range of 2 letters\n" +
                 "6. Clear all of the contacts\n" +
                 "7. Exit/Leave" + RESET);
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
               break;
         }
      }
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
      Contact contact = new Contact();
      System.out.println();
      while (true) {
         int input = -1;
         System.out.println("What would you like to add to the contact?\n" +
                 "1. Add First and Last Name\n" +
                 "2. Add First Name\n" +
                 "3. Add Last Name\n" +
                 "4. Add Address\n" +
                 "5. Add Phone Number\n" +
                 "6. Add Birthday\n" +
                 "7. Add note about the contact\n" +
                 "8. Add contact to list\n" +
                 "9. Cancel adding a contact");
         try {
            input = scan.nextInt();
         }
         catch (InputMismatchException e) {
            System.out.println(RED_BOLD_BRIGHT + "Invalid input. Please enter a number from list.\n" + RESET);
            scan.nextLine();
            continue;
         }
      
      
         if (input == 1) {
            try {
               System.out.println("Enter name:");
               scan.nextLine();
               String[] name = scan.nextLine().split(" ");
               if (name.length != 2) {
                  System.out.println(RED_BOLD_BRIGHT + "Incorrect length of name." + RESET);
                  continue;
               }
               contact.setName(name[0], name[1]);
               System.out.println(GREEN_BRIGHT + "First and last name added to contact.\n" + RESET);
            }
            catch (IllegalArgumentException e) {
               System.out.println(RED_BOLD_BRIGHT + e.toString() + RESET);
            }
         }
         
         else if (input == 2) {
            System.out.println("Enter first name:");
            try {
               scan.nextLine();
               contact.setFirstName(scan.nextLine());
               System.out.println(GREEN_BRIGHT + "First name added to contact.\n" + RESET);
            }
            catch (IllegalArgumentException e) {
               System.out.println(RED_BOLD_BRIGHT + e.toString() + RESET);
            }
         }
         
         else if (input == 3) {
            System.out.println("Enter last name:");
            try {
               scan.nextLine();
               contact.setLastName(scan.nextLine());
               System.out.println(GREEN_BRIGHT + "Last name added to contact.\n" + RESET);
            }
            catch (IllegalArgumentException e) {
               System.out.println(RED_BOLD_BRIGHT + e.toString() + RESET);
            }
         }
         
         else if (input == 4) {
            System.out.println("Enter address:");
            try {
               scan.nextLine();
               contact.setAddress(scan.nextLine());
               System.out.println(GREEN_BRIGHT + "Address added to contact.\n" + RESET);
            }
            catch (IllegalArgumentException e) {
               System.out.println(RED_BOLD_BRIGHT + e.toString() + RESET);
            }
         }
         
         else if (input == 5) {
            System.out.println("Enter phone number:");
            try {
               scan.nextLine();
               contact.setPhoneNum(scan.nextLine());
               System.out.println(GREEN_BRIGHT + "Phone number added to contact.\n" + RESET);
            }
            catch (IllegalArgumentException e) {
               System.out.println(RED_BOLD_BRIGHT + e.toString() + RESET);
            }
         }
         
         else if (input == 6) {
            System.out.println("Enter month of the birthday:");
            try {
               int month = scan.nextInt();
               System.out.println("Enter day of the birthday:");
               int day = scan.nextInt();
               System.out.println("Enter year of the birthday:");
               int year = scan.nextInt();
               contact.setBirthday(month, day, year);
               System.out.println(GREEN_BRIGHT + "Birthday added to contact.\n" + RESET);
            }
            catch (InputMismatchException | IllegalArgumentException e) {
               System.out.println(RED_BOLD_BRIGHT + e.toString() + RESET);
            }
         }

         else if (input == 7) {
            System.out.println("Enter note about contact:");
            try {
               scan.nextLine();
               contact.setNotes(scan.nextLine());
               System.out.println(GREEN_BRIGHT + "Note added to contact.\n" + RESET);
            }
            catch (Exception e) {
               System.out.println(RED_BOLD_BRIGHT + e.toString() + RESET);
            }
         }

         else if (input == 8) {
            break;
         }

         else if (input == 9) {
            System.out.println("Cancelled adding a contact.\n");
            return;
         }
         
         else {
            System.out.println(RED_BOLD_BRIGHT + "Invalid input." + RESET);
         }
      }

      if (contact.isContactEmpty()) {
         System.out.println(RED_BOLD_BRIGHT + "Contact not added to list since no input was given for the contact.\n" + RESET);
      }
      else {
         addContact(contact);
         System.out.println(GREEN_BRIGHT + "Added contact to list.\n" + RESET);
      }
   }

   /**
    * Adds contact to arraylist and sorts it.
    * @param x Contact to be added to contact list
    * @throws NullPointerException if input is null
    */
   private static void addContact(Contact x) {
      if (isNull(x)) {
         throw new NullPointerException("Contact given is null.");
      }
      contactList.add(x);
      cleanList();
      Collections.sort(contactList);
   }

   /**
    * Method to handle the edit choice.
    */
   private static void edit() {
      if (contactList.isEmpty()) {
         System.out.println(RED_BOLD_BRIGHT + "\nContact list is empty, no contacts to edit.\n" + RESET);
         return;
      }
      System.out.println(GREEN_BRIGHT + "Edit method." + RESET);
   }

   /**
    * Method to handle the remove choice.
    */
   private static void remove() {
      if (contactList.isEmpty()) {
         System.out.println(RED_BOLD_BRIGHT + "\nContact list is empty, no contacts to remove.\n" + RESET);
         return;
      }
      System.out.println(GREEN_BRIGHT + "Remove method." + RESET);
   }

   /**
    * Method to handle the range choice.
    */
   private static void range() {
      if (contactList.isEmpty()) {
         System.out.println(RED_BOLD_BRIGHT + "\nContact list is empty, no contacts to print.\n" + RESET);
         return;
      }
      System.out.println(GREEN_BRIGHT + "Range method." + RESET);
      //scan.nextLine().charAt(0);
      printInRange('a', 'b');
   }

   /**
    * Prints all of the contacts within the given char range by last name.
    * @param start Beginning of range
    * @param end End of the range
    */
   private static void printInRange(char start, char end) {
      //check if both chars are numbers or actual chars using the try catch
      //use check if the start is actually before the end

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
      if (contactList.isEmpty()) {
         return null;
      }

      nameType = nameType.toLowerCase();
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
         System.out.println(RED_UNDERLINED + "\nContact list is empty.\n" + RESET);
         return;
      }

      for (Contact contact : contactList) {
         System.out.println("\n==========================================");
         System.out.println(contact);
         System.out.println("==========================================");
      }
      System.out.println();
   }

   /**
    * Removes any contacts with nothing defined in each instance.
    */
   private static void cleanList() {
      for (int i = 0; i < contactList.size(); i++) {
         if (contactList.get(i).isContactEmpty()) {
            contactList.remove(i);
         }
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
