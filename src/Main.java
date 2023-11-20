import java.util.*;

/**
 * Client class to run the project and to be able to maintain to the list of contacts.
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
                    System.out.println(YELLOW_BOLD_BRIGHT + "\nThank you for using this program." + RESET);
                    scan.close();
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
                 "5. Print a contact\n" +
                 "6. Print contacts in range of 2 letters\n" +
                 "7. Clear all of the contacts\n" +
                 "8. Exit/Leave" + RESET);
         try {
            input = scan.nextInt();
         }
         catch (InputMismatchException e) {
            System.out.println(RED_BOLD_BRIGHT + "***Invalid input.***\n" + RESET);
            scan.nextLine();
         }
      
         switch (input) {
            case 1 -> add();
            case 2 -> remove();
            case 3 -> edit();
            case 4 -> printContacts();
            case 5 -> printSingleContact();
            case 6 -> range();
            case 7 -> {
               contactList.clear();
               System.out.println(GREEN_BRIGHT + "Contact list has been cleared.\n" + RESET);
            }
            case 8 -> System.exit(0);
            default -> System.out.println(RED_UNDERLINED + "Invalid input." + RESET);
         }
      }
   }

   /**
    * Method to handle the add choice.
    */
   private static void add() {
      Contact contact = new Contact();
      System.out.println();
      cleanList();
      while (true) {
         int input = -1;
         System.out.println("What would you like to add to the contact?\n" + YELLOW_BOLD_BRIGHT +
                 "1. Add First and Last Name\n" +
                 "2. Add First Name\n" +
                 "3. Add Last Name\n" +
                 "4. Add Address\n" +
                 "5. Add Phone Number\n" +
                 "6. Add Birthday\n" +
                 "7. Add note about the contact\n" +
                 GREEN_UNDERLINED + "8. Add contact to list\n" +
                 RED_UNDERLINED + "9. Cancel adding a contact" + RESET);
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
                  throw new IllegalLengthException("Incorrect length of name; Only 2 words allowed for name.");
               }
               contact.setName(name[0], name[1]);
               System.out.println(GREEN_BRIGHT + "First and last name added to contact.\n" + RESET);
            }
            catch (IllegalArgumentException | NullPointerException e) {
               System.out.println(RED_BOLD_BRIGHT + e.getMessage() + RESET);
            }
         }
         
         else if (input == 2) {
            System.out.println("Enter first name:");
            try {
               scan.nextLine();
               contact.setFirstName(scan.nextLine());
               System.out.println(GREEN_BRIGHT + "First name added to contact.\n" + RESET);
            }
            catch (IllegalArgumentException | NullPointerException e) {
               System.out.println(RED_BOLD_BRIGHT + e.getMessage() + RESET);
            }
         }
         
         else if (input == 3) {
            System.out.println("Enter last name:");
            try {
               scan.nextLine();
               contact.setLastName(scan.nextLine());
               System.out.println(GREEN_BRIGHT + "Last name added to contact.\n" + RESET);
            }
            catch (IllegalArgumentException | NullPointerException e) {
               System.out.println(RED_BOLD_BRIGHT + e.getMessage() + RESET);
            }
         }
         
         else if (input == 4) {
            System.out.println("Enter address:");
            try {
               scan.nextLine();
               contact.setAddress(scan.nextLine());
               System.out.println(GREEN_BRIGHT + "Address added to contact.\n" + RESET);
            }
            catch (IllegalArgumentException | NullPointerException e) {
               System.out.println(RED_BOLD_BRIGHT + e.getMessage() + RESET);
            }
         }
         
         else if (input == 5) {
            System.out.println("Enter phone number:");
            try {
               scan.nextLine();
               contact.setPhoneNum(scan.nextLine());
               System.out.println(GREEN_BRIGHT + "Phone number added to contact.\n" + RESET);
            }
            catch (IllegalArgumentException | NullPointerException e) {
               System.out.println(RED_BOLD_BRIGHT + e.getMessage() + RESET);
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
               System.out.println(RED_BOLD_BRIGHT + e.getMessage() + RESET);
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
               System.out.println(RED_BOLD_BRIGHT + e.getMessage() + RESET);
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
    * @param contact Contact to be added to contact list
    * @throws NullPointerException if input is null
    */
   private static void addContact(Contact contact) {
      if (isNull(contact)) {
         throw new NullPointerException("Contact given is null.");
      }
      contactList.add(contact);
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
   
      while (true) {
         cleanList();
         System.out.println();
         printListNames();

         System.out.println(GREEN_BRIGHT + "\nWhich contact would you like to edit? Press 0 to exit." + RESET);
         int num;
         try {
            num = scan.nextInt();
            if (num == 0) {
               System.out.println(GREEN_BOLD_BRIGHT + "Exiting.\n" + RESET);
               return;
            }
            if (num < 0 || num > contactList.size()) {
               throw new IllegalArgumentException("Number is not in range.");
            }
         
            System.out.println("\n==========================================");
            System.out.println(contactList.get(--num));
            System.out.println("==========================================\n");
            System.out.println("What would you like to edit about the contact?\n" +
                    "1. Edit First and Last Name\n" +
                    "2. Edit First Name\n" +
                    "3. Edit Last Name\n" +
                    "4. Edit address\n" +
                    "5. Edit Phone Number\n" +
                    "6. Edit Birthday\n" +
                    "7. Edit note about the contact\n" +
                    "8. Add note about the contact\n" +
                    GREEN_UNDERLINED + "9. Exit out of editing" + RESET);
            int input = scan.nextInt();
         
            if (input == 1) {
               System.out.println("Enter name:");
               scan.nextLine();
               String[] name = scan.nextLine().split(" ");
               if (name.length != 2) {
                  throw new IllegalLengthException("Incorrect length of name; Only 2 words allowed for name.");
               }
               contactList.get(num).setName(name[0], name[1]);
               System.out.println(GREEN_BRIGHT + "First and last name edited in contact.\n" + RESET);
            }
            
            else if (input == 2) {
               System.out.println("Enter first name:");
               scan.nextLine();
               contactList.get(num).setFirstName(scan.nextLine());
               System.out.println(GREEN_BRIGHT + "First name edited in contact.\n" + RESET);
            }
            
            else if (input == 3) {
               System.out.println("Enter last name:");
               scan.nextLine();
               contactList.get(num).setLastName(scan.nextLine());
               System.out.println(GREEN_BRIGHT + "Last name edited in contact.\n" + RESET);
            }
            
            else if (input == 4) {
               System.out.println("Enter address:");
               scan.nextLine();
               contactList.get(num).setAddress(scan.nextLine());
               System.out.println(GREEN_BRIGHT + "Address edited in contact.\n" + RESET);
            }
            
            else if (input == 5) {
               System.out.println("Enter phone number:");
               scan.nextLine();
               contactList.get(num).setPhoneNum(scan.nextLine());
               System.out.println(GREEN_BRIGHT + "Phone number edited in contact.\n" + RESET);
            }
            
            else if (input == 6) {
               System.out.println("Enter month of the birthday:");
               int month = scan.nextInt();
               System.out.println("Enter day of the birthday:");
               int day = scan.nextInt();
               System.out.println("Enter year of the birthday:");
               int year = scan.nextInt();
               contactList.get(num).setBirthday(month, day, year);
               System.out.println(GREEN_BRIGHT + "Birthday edited in contact.\n" + RESET);
            }
            
            else if (input == 7) {
               System.out.println("Enter note about contact:");
               scan.nextLine();
               contactList.get(num).setNotes(scan.nextLine());
               System.out.println(GREEN_BRIGHT + "Note edited in contact.\n" + RESET);
            }
            
            else if (input == 8) {
               System.out.println("Add note about contact:");
               scan.nextLine();
               contactList.get(num).addToNotes(scan.nextLine());
               System.out.println(GREEN_BRIGHT + "Note edited in contact.\n" + RESET);
            }
            
            else if (input == 9) {
               System.out.println("Exiting out of editing.\n");
               return;
            }
            
            else {
               System.out.println(RED_BOLD_BRIGHT + "Invalid input." + RESET);
            }
         }
         catch (Exception e) {
            System.out.println(RED_BOLD_BRIGHT + e.getMessage() + "\n" + RESET);
         }
      }
   }

   /**
    * Method to handle the remove choice.
    */
   private static void remove() {
      if (contactList.isEmpty()) {
         System.out.println(RED_BOLD_BRIGHT + "\nContact list is empty, no contacts to remove.\n" + RESET);
         return;
      }
      cleanList();
      System.out.println(GREEN_BRIGHT + "\nWhich contact would you like to remove? Enter the number." + RESET);
      printListNames();
      int num;
      try {
         num = scan.nextInt();
         if (num < 1 || num > contactList.size()) {
            throw new IllegalArgumentException();
         }
      }
      catch (Exception e) {
         System.out.println(RED_BOLD_BRIGHT + "\nInvalid input.\n" + RESET);
         return;
      }
      contactList.remove(--num);
      System.out.println(GREEN_BOLD_BRIGHT + "Contact successfully removed from list.\n");
   }

   /**
    * Method to handle the range choice.
    */
   private static void range() {
      if (contactList.isEmpty()) {
         System.out.println(RED_BOLD_BRIGHT + "\nContact list is empty, no contacts to print.\n" + RESET);
         return;
      }
   
      scan.nextLine();
      cleanList();
   
      while (true) {
         Character start;
         Character end;
         try {
            System.out.println("\nWhat letter would you like to begin your range in? (Press 1 to escape)");
            start = scan.nextLine().trim().toUpperCase().charAt(0);
            if (start.equals('1')) {
               System.out.println(GREEN_BOLD_BRIGHT + "Exiting.\n" + RESET);
               return;
            }
         
            System.out.println("What letter would you like to end your range in? (Press 1 to escape)");
            end = scan.nextLine().trim().toUpperCase().charAt(0);
            if (end.equals('1')) {
               System.out.println(GREEN_BOLD_BRIGHT + "Exiting.\n" + RESET);
               return;
            }
            if (start.compareTo(end) > 0) {
               throw new InputMismatchException("Starting point cannot be before end point.");
            }
         }
         catch (InputMismatchException e) {
            System.out.println(RED_BOLD_BRIGHT + e.getMessage() + "\n" + RESET);
            continue;
         }
         try {
            printInRange(start, end);
         }
         catch (Exception e) {
            System.out.println(RED_BOLD_BRIGHT + e.getMessage() + RESET);
            continue;
         }
         break;
      }
   }

   /**
    * Prints all of the contacts within the given char range by last name.
    * @param start Beginning of range
    * @param end End of the range
    * @throws IllegalArgumentException if either of the inputted chars are a digit or end is before starting point
    */
   private static void printInRange(Character start, Character end) {
      if (Character.isDigit(start) || Character.isDigit(end)) {
         throw new IllegalArgumentException("Input cannot be a number, unless it is 1.");
      }
      if (start.compareTo(end) > 0) {
         throw new IllegalArgumentException("Starting point cannot be after end point.");
      }
      if (contactList.isEmpty()) {
         System.out.println(RED_BOLD_BRIGHT + "\nContact list is empty, no contacts to print.\n" + RESET);
         return;
      }
      cleanList();
   
      for (int i = 0; i < contactList.size(); i++) {
         Character lastNameInitial = contactList.get(i).getLastName().charAt(0);
         if (lastNameInitial.compareTo(end) > 0) {
            break;
         }
         if (lastNameInitial.compareTo(start) >= 0 && lastNameInitial.compareTo(end) <= 0) {
            System.out.println("\n==========================================");
            System.out.println(contactList.get(i));
            System.out.println("==========================================");
         }
      }
      System.out.println();
   }

   /**
    * Method to run the print single contact option.
    */
   private static void printSingleContact() {
      scan.nextLine();
      if (contactList.isEmpty()) {
         System.out.println(RED_BOLD_BRIGHT + "\nContact list is empty, no contacts to print.\n" + RESET);
         return;
      }
      cleanList();
      System.out.println("What's the last name?");
      String lastName = scan.nextLine();
   
      System.out.println("What's the first name?");
      String firstName = scan.nextLine();
   
      for (Contact contact : contactList) {
         if (firstName.equalsIgnoreCase(contact.getFirstName()) && lastName.equalsIgnoreCase(contact.getLastName())) {
            System.out.println(contact + "\n");
            return;
         }
      }
      System.out.println(RED_BOLD_BRIGHT + "Contact not found in contact list.\n" + RESET);
   }

   /**
    * Prints all of the contacts in contact list.
    */
   private static void printContacts() {
      if (contactList.isEmpty()) {
         System.out.println(RED_UNDERLINED + "\nContact list is empty.\n" + RESET);
         return;
      }
   
      cleanList();
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
      if (contactList.isEmpty()) {
         return;
      }

      for (int i = 0; i < contactList.size(); i++) {
         if (contactList.get(i).isContactEmpty()) {
            contactList.remove(i);
         }
      }
   }

   /**
    * Prints the contact list as a list with the names only.
    */
   private static void printListNames() {
      if (contactList.isEmpty()) {
         System.out.println(RED_UNDERLINED + "\nContact list is empty.\n" + RESET);
         return;
      }
   
      cleanList();
      int count = 1;
      for (Contact contact : contactList) {
         System.out.println(count++ + ". " + contact.getName());
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
