package com.addressbookapp.controller;

import com.addressbookapp.model.Contact;
import com.addressbookapp.service.AddressBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contacts")
public class AddressBookController {

    private final AddressBookService service;

    public AddressBookController(AddressBookService service){
        this.service = service;
    }

    @PostMapping("/add")
    public Contact add(@RequestBody Contact c){
        return service.addContact(c);
    }

    @GetMapping("/all")
    public List<Contact> all(){
        return service.getAllContacts();
    }

    // UC9
    @GetMapping("/city")
    public Map<String,List<Contact>> city(){
        return service.viewByCity();
    }

    @GetMapping("/state")
    public Map<String,List<Contact>> state(){
        return service.viewByState();
    }

    // UC10
    @GetMapping("/count/city")
    public Map<String,Long> countCity(){
        return service.countByCity();
    }

    @GetMapping("/count/state")
    public Map<String,Long> countState(){
        return service.countByState();
    }
}