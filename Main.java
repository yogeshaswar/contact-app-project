import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import models.*;

public class Main {
    static ContactManager manager = new ContactManager();

    public static void main(String[] args) {
        try {
            LoadContacts("New Text Document.txt");
            System.out.println("CONTACT LOADED\n\n");
            System.out.println(manager);
            manageContacts();
            System.out.println(manager);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    // LoadContacts from file:
    public static void LoadContacts(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner fileScanner = new Scanner(fis);
        while (fileScanner.hasNextLine()) {
            try {
                Contact contact = new Contact(fileScanner.next(), fileScanner.next(), fileScanner.next());
                manager.addContact(contact);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
        fileScanner.close();

    }

    // Manage Contacts:
    public static void manageContacts() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Would you like to\na) Add a contact \nb) Remove a contact\nc) Exit");
            String responce = scan.nextLine();
            if (responce.equals("a")) {
                System.out.println("\nName:");
                String name = scan.nextLine();
                System.out.println("\nBirth Date:");
                String birthDate = scan.nextLine();
                System.out.println("Phone Number:");
                String phoneNumber = scan.nextLine();
                if (name.isBlank() || phoneNumber.isBlank() || phoneNumber.length() < 5) {
                    System.out.println("\nThe input you provided is invalid, Rgistration failed.");
                }
                try {
                    manager.addContact(new Contact(name, birthDate, phoneNumber));
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                } finally {
                    System.out.println("\n\nUPDATED CONTACTS\n\n" + manager);
                }
            } else if (responce.equals("b")) {
                System.out.println("Who would you like to remove?");
                String name = scan.nextLine();
                manager.removeContact(name);
            } else {
                break;
            }
        }
        scan.close();
    }
}
