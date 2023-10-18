import java.util.ArrayList;
import java.util.Collections;

public class Main implements textColors {
    private static ArrayList<Contact> arrayList = new ArrayList<Contact>();
    public static void main(String[] args) {
        // Print colored text to the console
        System.out.println(GREEN + "This text is green." + RESET);
        System.out.println(YELLOW + "This text is yellow." + RESET);
        System.out.println(RED + "This text is red." + RESET);
        //System.out.println(new Contact().getDateOfCreation().getGregorianChange());
        //System.out.println(new Contact().getCreationTime());
        Contact contact1 = new Contact();
        contact1.setFirstName("john");
        contact1.setLastName("Cena");
        sleep(1000);

        Contact contact2 = new Contact();
        contact2.setFirstName("john");
        contact2.setLastName("Cena");
        sleep(1000);

        Contact contact4 = new Contact();
        contact4.setFirstName("michael");
        contact4.setLastName("Dal");
        arrayList.add(contact4);
        sleep(1000);

        Contact contact3 = new Contact();
        contact3.setFirstName("michael");
        contact3.setLastName("jackson");
        arrayList.add(contact1);
        arrayList.add(contact2);
        arrayList.add(contact3);



        Collections.sort(arrayList);
        printContacts();
    }

    /*
    methods ideas:
    return all contacts
    return contacts within a certain alphabetical order
    return a specific contact
    add/remove/edit contacts

     */

    private static void printContacts() {
        if (arrayList.isEmpty()) {
            System.out.println("Contact list is empty.");
        }

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    private static void sleep(long milliSec) {
        try {
            Thread.sleep(milliSec);
        }
        catch (Exception e) {
            System.out.println(RED + e.toString() + RESET);
        }
    }
}
