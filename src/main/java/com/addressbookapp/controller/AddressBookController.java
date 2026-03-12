package com.addressbookapp.controller;

import com.addressbookapp.model.Contact;
import com.addressbookapp.service.AddressBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class AddressBookController {

    private final AddressBookService contactService;

    public AddressBookController(AddressBookService contactService) {
        this.contactService = contactService;
    }

    // UC1 Add Contact
    @PostMapping("/add")
    public Contact addContact(@RequestBody Contact contact) {

        return contactService.addContact(contact);
    }

    // UC2 Edit Contact
    @PutMapping("/edit/{name}")
    public String editContact(@PathVariable String name,
                              @RequestBody Contact contact) {

        return contactService.editContact(name, contact);
    }

    // UC3 Delete Contact
    @DeleteMapping("/delete/{name}")
    public String deleteContact(@PathVariable String name) {

        return contactService.deleteContact(name);
    }

    // UC4 Get All Contacts
    @GetMapping("/all")
    public List<Contact> getAllContacts() {

        return contactService.getAllContacts();
    }

    // UC5 Get Contact by Name
    @GetMapping("/{name}")
    public Contact getContactByName(@PathVariable String name) {

        return contactService.getContactByName(name);
    }
}