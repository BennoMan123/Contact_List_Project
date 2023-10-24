import java.util.*;

public class Main implements textColors {
   private static Scanner scan = new Scanner(System.in);
   private static ArrayList<Contact> contactList = new ArrayList<Contact>();

   public static void main(String[] args) {
      // Print colored text to the console
      System.out.println(GREEN + "This text is green." + RESET);
      System.out.println(YELLOW + "This text is yellow." + RESET);
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
      contactList.add(contact4);
      sleep(1000);

      Contact contact3 = new Contact();
      contact3.setFirstName("michael");
      contact3.setLastName("jackson");
      contactList.add(contact1);
      contactList.add(contact2);
      contactList.add(contact3);

      sortList();
      printContacts();
   }

   /*
   methods ideas:
   return all contacts
   return contacts within a certain alphabetical range
   return a specific contact
   add(check if the added contact already exists and then asks user if they want to still add it anyway)/remove/edit contacts

    */

   private static void addContact(Contact x) {
      contactList.add(x);
      sortList();
   }

   private static void printContacts() {
      if (contactList.isEmpty()) {
         System.out.println(RED_UNDERLINED + "Contact list is empty." + RESET);
         return;
      }
   
      for (int i = 0; i < contactList.size(); i++) {
         System.out.println(/*YELLOW_BOLD_BRIGHT +*/ contactList.get(i)/* + RESET*/);
      }
   }

   private static void sortList() {
      Collections.sort(contactList);
   }


   private static void sleep(long milliSec) {
      try {
         Thread.sleep(milliSec);
      }
      catch (Exception e) {
         System.out.println(RED + e + RESET);
      }
   }
}
