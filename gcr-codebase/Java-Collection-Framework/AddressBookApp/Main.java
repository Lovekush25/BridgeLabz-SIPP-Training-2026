import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {

            System.out.println("\n===== Address Book =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone : ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Email : ");
                    String email = sc.nextLine();

                    addressBook.addContact(name, phone, email);
                    break;

                case 2:

                    System.out.print("Enter Name : ");
                    addressBook.searchContact(sc.nextLine());
                    break;

                case 3:

                    System.out.print("Enter Name : ");
                    addressBook.deleteContact(sc.nextLine());
                    break;

                case 4:

                    addressBook.displayContacts();
                    break;

                case 5:

                    System.out.println("Thank You.");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
}