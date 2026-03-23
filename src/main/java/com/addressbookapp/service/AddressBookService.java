package com.addressbookapp.service;

import com.addressbookapp.model.Contact;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AddressBookService {

    List<Contact> contactList = new ArrayList<>();

    // UC1 + UC7
    public Contact addContact(Contact contact) {

        if(contactList.contains(contact)){
            System.out.println("Duplicate Not Allowed");
            return null;
        }

        contactList.add(contact);
        return contact;
    }

    // UC2
    public String editContact(String name, Contact newContact) {

        for(Contact c : contactList){
            if(c.getFirstName().equalsIgnoreCase(name)){

                c.setLastName(newContact.getLastName());
                c.setAddress(newContact.getAddress());
                c.setCity(newContact.getCity());
                c.setState(newContact.getState());
                c.setZip(newContact.getZip());
                c.setPhoneNumber(newContact.getPhoneNumber());
                c.setEmail(newContact.getEmail());

                return "Updated";
            }
        }
        return "Not Found";
    }

    // UC3
    public String deleteContact(String name) {
        boolean removed = contactList.removeIf(
                c -> c.getFirstName().equalsIgnoreCase(name));
        return removed ? "Deleted" : "Not Found";
    }

    // UC4
    public List<Contact> getAllContacts(){
        return contactList;
    }

    // UC5
    public Contact getContactByName(String name){
        return contactList.stream()
                .filter(c -> c.getFirstName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    // UC9
    public Map<String,List<Contact>> viewByCity(){
        return contactList.stream()
                .collect(Collectors.groupingBy(Contact::getCity));
    }

    public Map<String,List<Contact>> viewByState(){
        return contactList.stream()
                .collect(Collectors.groupingBy(Contact::getState));
    }

    // UC10
    public Map<String,Long> countByCity(){
        return contactList.stream()
                .collect(Collectors.groupingBy(
                        Contact::getCity, Collectors.counting()));
    }

    public Map<String,Long> countByState(){
        return contactList.stream()
                .collect(Collectors.groupingBy(
                        Contact::getState, Collectors.counting()));
    }
}