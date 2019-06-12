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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @Autowired
    private ContactRepos contactRepos;

    @GetMapping("contacts")
    public String contacts(Model model) {
        model.addAttribute("result", "");
        return "contacts";
    }

    @PostMapping("contacts")
    public String createContact(@RequestParam(name = "firstName", required = false, defaultValue = "") String firstName,
                                @RequestParam(name = "lastName", required = false, defaultValue = "") String lastName,
                                @RequestParam(name = "email", required = false, defaultValue = "") String email,
                                Model model) {
        Contact contact = new Contact(firstName, lastName, email);
        contactRepos.save(contact);
        model.addAttribute("result", "ok");

        return "contacts";
    }

    @PatchMapping("contacts/patch")
    public String patchContact(@RequestParam(name = "id", required = false, defaultValue = "") Integer id,
                               @RequestParam(name = "firstName", required = false, defaultValue = "") String firstName,
                               @RequestParam(name = "lastName", required = false, defaultValue = "") String lastName,
                               @RequestParam(name = "email", required = false, defaultValue = "") String email,
                               Model model) {

        Contact currentContact = contactRepos.findById(id);
        if (currentContact != null) {
            currentContact.setFirstName(firstName);
            currentContact.setLastName(lastName);
            currentContact.setEmail(email);
            contactRepos.saveAndFlush(currentContact);
            model.addAttribute("result", "ok");
        } else {
            model.addAttribute("result", "no such contact");
        }

        return "contacts";
    }
}