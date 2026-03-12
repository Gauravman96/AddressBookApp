package com.addressbookapp.service;

import com.addressbookapp.model.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class AddressBookService {

    List<Contact> contactList = new ArrayList<>();


    // UC1 Add Contact
    public Contact addContact(Contact contact) {

        contactList.add(contact);

        return contact ;
    }


    // UC2 Edit Contact
    public String editContact(String name, Contact newContact) {

        for (Contact c : contactList) {

            if (c.getFirstName().equalsIgnoreCase(name)) {
                  
                c.setLastName(newContact.getLastName());
                c.setAddress(newContact.getAddress());
                c.setCity(newContact.getCity());
                c.setState(newContact.getState());
                c.setZip(newContact.getZip());
                c.setPhoneNumber(newContact.getPhoneNumber());
                c.setEmail(newContact.getEmail());

                return "Contact Updated";
            }
        }

        return "Contact Not Found";
    }


    // UC3 Delete Contact
    public String deleteContact(String name) {

        for (Contact c : contactList) {

            if (c.getFirstName().equalsIgnoreCase(name)) {

                contactList.remove(c);
                return "Contact Deleted";
            }
        }

        return "Contact Not Found";
    }


    // UC4 Multiple Contacts (List already handling)
    public List<Contact> getAllContacts() {

        return contactList;
    }


    // UC5 Get Contact by Name
    public Contact getContactByName(String name) {

        for (Contact c : contactList) {

            if (c.getFirstName().equalsIgnoreCase(name)) {

                return c;
            }
        }

        return null;
    }
}