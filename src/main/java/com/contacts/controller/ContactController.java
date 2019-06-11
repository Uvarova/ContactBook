package com.contacts.controller;
/*
 * created by ellen
 * created on 11.06.2019
 * class created for project ContactBook
 */

import com.contacts.entity.Contact;
import com.contacts.repository.ContactRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller

public class ContactController {

    @Autowired
    private ContactRepos contactRepos;

   @GetMapping("contacts")
    public String contacts(Map<String,Object> model) {
       return "contacts";
    }

    @PostMapping("contacts")
    public String createContact(@RequestParam(name = "firstName", required = false, defaultValue = "") String firstName,
                                @RequestParam(name = "lastName", required = false, defaultValue = "") String lastName,
                                @RequestParam(name = "email", required = false, defaultValue = "") String email,
                                Map<String, Object> model) {
       Contact contact = new Contact(firstName,lastName,email);
       contactRepos.save(contact);

       return "contacts";
    }
}
