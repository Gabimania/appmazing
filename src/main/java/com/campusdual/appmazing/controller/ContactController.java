package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IContactService;
import com.campusdual.appmazing.model.dto.Contactdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private IContactService contactService;

    @GetMapping
    public String testController(){
        return "Contacts controller works!";
    }

    @PostMapping
    public String testControllerBody(@RequestBody String name){
        return "Contacts controller works," + name + "!";
    }

    @GetMapping(value = "/testMethod")
    public String testControllerMethod(){
        return "Contact controller method works";
    }

    @PostMapping(value="/get")
    public Contactdto queryContact(@RequestBody Contactdto contact){
        return this.contactService.queryContact(contact);
    }

    @GetMapping(value = "/getAll")
    public List<Contactdto> queryAllContacts(){
        return this.contactService.queryAllContacts();
    }
    @PostMapping(value= "/add")
    public int insertContact(@RequestBody Contactdto contact){
        return this.contactService.insertContact(contact);
    }
    @PutMapping(value= "/update")
    public int updateContact(@RequestBody Contactdto contact){
        return this.contactService.updateContact(contact);
    }
    @DeleteMapping(value ="/delete")
    public int deleteContact(@RequestBody Contactdto contact){
        return this.contactService.deleteContact(contact);
    }
}
