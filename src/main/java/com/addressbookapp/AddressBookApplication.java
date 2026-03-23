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
            System.out.println("\n--- ADDRESS BOOK MENU ---");
            System.out.println("1 Add Contact");
            System.out.println("2 Edit Contact");
            System.out.println("3 Delete Contact");
            System.out.println("4 View Contacts");
            System.out.println("5 Get By Name");
            System.out.println("6 View by City (UC9)");
            System.out.println("7 View by State (UC9)");
            System.out.println("8 Count by City (UC10)");
            System.out.println("9 Count by State (UC10)");
            System.out.println("10 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                // UC1 Add Contact
                case 1:
                    System.out.print("First Name: ");
                    String f = sc.nextLine();

                    System.out.print("Last Name: ");
                    String l = sc.nextLine();

                    System.out.print("Address: ");
                    String a = sc.nextLine();

                    System.out.print("City: ");
                    String c = sc.nextLine();

                    System.out.print("State: ");
                    String s = sc.nextLine();

                    System.out.print("Zip: ");
                    String z = sc.nextLine();

                    System.out.print("Phone: ");
                    String p = sc.nextLine();

                    System.out.print("Email: ");
                    String e = sc.nextLine();

                    Contact contact = new Contact(f,l,a,c,s,z,p,e);
                    service.addContact(contact);
                    System.out.println("Contact Added!");
                    break;

                // UC2 Edit
                case 2:
                    System.out.print("Enter Name to Edit: ");
                    String name = sc.nextLine();

                    System.out.print("New Last Name: ");
                    String nl = sc.nextLine();

                    System.out.print("New Address: ");
                    String na = sc.nextLine();

                    System.out.print("New City: ");
                    String nc = sc.nextLine();

                    System.out.print("New State: ");
                    String ns = sc.nextLine();

                    System.out.print("New Zip: ");
                    String nz = sc.nextLine();

                    System.out.print("New Phone: ");
                    String np = sc.nextLine();

                    System.out.print("New Email: ");
                    String ne = sc.nextLine();

                    Contact newC = new Contact(name,nl,na,nc,ns,nz,np,ne);
                    System.out.println(service.editContact(name,newC));
                    break;

                // UC3 Delete
                case 3:
                    System.out.print("Enter Name to Delete: ");
                    String del = sc.nextLine();
                    System.out.println(service.deleteContact(del));
                    break;

                // UC4 View All
                case 4:
                    List<Contact> list = service.getAllContacts();
                    list.forEach(x ->
                        System.out.println(
                            x.getFirstName()+" | "+
                            x.getCity()+" | "+
                            x.getState()
                        )
                    );
                    break;

                // UC5 Get By Name
                case 5:
                    System.out.print("Enter Name: ");
                    Contact found = service.getContactByName(sc.nextLine());

                    if(found != null){
                        System.out.println(
                            found.getFirstName()+" | "+
                            found.getCity()+" | "+
                            found.getState()
                        );
                    } else {
                        System.out.println("Contact Not Found");
                    }
                    break;

                // UC9 View by City
                case 6:
                    service.viewByCity().forEach((city,lst) -> {
                        System.out.println("City: " + city);
                        lst.forEach(cn -> System.out.println(" - " + cn.getFirstName()));
                    });
                    break;

                // UC9 View by State
                case 7:
                    service.viewByState().forEach((state,lst) -> {
                        System.out.println("State: " + state);
                        lst.forEach(cn -> System.out.println(" - " + cn.getFirstName()));
                    });
                    break;

                // UC10 Count by City
                case 8:
                    System.out.println(service.countByCity());
                    break;

                // UC10 Count by State
                case 9:
                    System.out.println(service.countByState());
                    break;

                case 10:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}