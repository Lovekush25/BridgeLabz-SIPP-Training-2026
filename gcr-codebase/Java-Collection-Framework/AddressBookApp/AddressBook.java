import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class AddressBook {

    private ArrayList<Contact> contacts = new ArrayList<>();
    private HashMap<String, Contact> contactMap = new HashMap<>();
    private HashSet<String> phoneNumbers = new HashSet<>();

    public void addContact(String name, String phone, String email) {

        if (phoneNumbers.contains(phone)) {
            System.out.println("Phone number already exists.");
            return;
        }

        Contact contact = new Contact(name, phone, email);

        contacts.add(contact);
        contactMap.put(name.toLowerCase(), contact);
        phoneNumbers.add(phone);

        System.out.println("Contact Added Successfully.");
    }

    public void searchContact(String name) {

        Contact contact = contactMap.get(name.toLowerCase());

        if (contact == null) {
            System.out.println("Contact Not Found.");
        } else {
            System.out.println(contact);
        }
    }

    public void deleteContact(String name) {

        Contact contact = contactMap.remove(name.toLowerCase());

        if (contact == null) {
            System.out.println("Contact Not Found.");
            return;
        }

        contacts.remove(contact);
        phoneNumbers.remove(contact.getPhone());

        System.out.println("Contact Deleted Successfully.");
    }

    public void displayContacts() {

        if (contacts.isEmpty()) {
            System.out.println("No Contacts Available.");
            return;
        }

        Collections.sort(contacts, Comparator.comparing(Contact::getName));

        System.out.println("\n----- Address Book -----");

        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("------------------------");
        }
    }
}