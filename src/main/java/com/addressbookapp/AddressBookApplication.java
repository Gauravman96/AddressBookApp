package com.addressbookapp;

import com.addressbookapp.model.Contact;
import com.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AddressBookApplication implements CommandLineRunner {

    @Autowired
    AddressBookService service;

    public static void main(String[] args) {
        SpringApplication.run(AddressBookApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Welcome to Address Book Program");
            System.out.println("\n----- ADDRESS BOOK MENU -----");
            System.out.println("1 Add Contact");
            System.out.println("2 Edit Contact");
            System.out.println("3 Delete Contact");
            System.out.println("4 View Contacts");
            System.out.println("5 Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                // ADD CONTACT
                case 1:

                    System.out.print("First Name: ");
                    String firstName = sc.nextLine();

                    System.out.print("Last Name: ");
                    String lastName = sc.nextLine();

                    System.out.print("Address: ");
                    String address = sc.nextLine();

                    System.out.print("City: ");
                    String city = sc.nextLine();

                    System.out.print("State: ");
                    String state = sc.nextLine();

                    System.out.print("Zip: ");
                    String zip = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    Contact contact = new Contact(firstName,lastName,address,
                            city,state,zip,phone,email);

                    service.addContact(contact);

                    System.out.println("Contact Added!");
                    break;


                // EDIT CONTACT
                case 2:

                    System.out.print("Enter First Name to Edit: ");
                    String name = sc.nextLine();

                    System.out.print("New Last Name: ");
                    String newLastName = sc.nextLine();

                    System.out.print("New Address: ");
                    String newAddress = sc.nextLine();

                    System.out.print("New City: ");
                    String newCity = sc.nextLine();

                    System.out.print("New State: ");
                    String newState = sc.nextLine();

                    System.out.print("New Zip: ");
                    String newZip = sc.nextLine();

                    System.out.print("New Phone: ");
                    String newPhone = sc.nextLine();

                    System.out.print("New Email: ");
                    String newEmail = sc.nextLine();

                    Contact newContact = new Contact(name,newLastName,newAddress,
                            newCity,newState,newZip,newPhone,newEmail);

                    System.out.println(service.editContact(name,newContact));

                    break;


                // DELETE CONTACT
                case 3:

                    System.out.print("Enter Name to Delete: ");
                    String deleteName = sc.nextLine();

                    System.out.println(service.deleteContact(deleteName));

                    break;


                // VIEW CONTACTS
                case 4:

                    List<Contact> contacts = service.getAllContacts();

                    for(Contact c : contacts){

                        System.out.println("--------------------");
                        System.out.println("Name: "+c.getFirstName()+" "+c.getLastName());
                        System.out.println("City: "+c.getCity());
                        System.out.println("Phone: "+c.getPhoneNumber());
                        System.out.println("Email: "+c.getEmail());
                    }

                    break;


                // EXIT
                case 5:

                    System.out.println("Exiting...");
                    System.exit(0);


                default:
                    System.out.println("Invalid Choice");

            }

        }
    }
}