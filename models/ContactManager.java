package models;

import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contacts;

    // Constructor:
    public ContactManager() {
        this.contacts = new ArrayList<Contact>();
    }

    // getter:
    public Contact getContact(int index) {
        return new Contact(contacts.get(index));
    }

    public void setContacts(int index, Contact contact) {
        contacts.set(index, new Contact(contact));
    }

    public void addContact(Contact contact) {
        contacts.add(new Contact(contact));
    }

    public void removeContact(String name) {
        if (contacts.isEmpty()) {
            throw new IllegalStateException("There are no contacts to remove");
        }
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                contacts.remove(i);
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < contacts.size(); i++) {
            temp += contacts.get(i).toString();
            temp += "\n\n";

        }
        return temp;
    }

}
