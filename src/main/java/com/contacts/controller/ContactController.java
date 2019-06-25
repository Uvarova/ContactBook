package com.contacts.controller;
/*
 * created by ellen
 * created on 11.06.2019
 * class created for project ContactBook
 */

import com.contacts.entity.Contact;
import com.contacts.service.ContactService;
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
    private ContactService contactService;
    private Contact currentContact;

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

        model.addAttribute("result", contactService.save(new Contact(firstName, lastName, email)));
        return "contacts";
    }

    @PostMapping("patch")
    public String showContact(@RequestParam(name = "id", required = true, defaultValue = "") Integer id,
                              Model model) {

        currentContact = contactService.findById(id);
        if (currentContact == null) return "redirect:/contacts";
        model.addAttribute("contact",currentContact);
        return "patchcontact";
    }

    @GetMapping("patch")
    private String getContact (Model model){
        return "patch";
    }

    @PostMapping("patch/toDo")
    private String updateContact(Model model, Contact contact) {
        model.addAttribute(contact);
        patchContact(model, contact);
        return "redirect:/contacts";
    }

    @PatchMapping("patch/toDo")
    private void patchContact(Model model, Contact contact) {
        contactService.update(contact);
    }

    @PostMapping("delete")
    private String deleteContact(@RequestParam(name = "id", required = true, defaultValue = "") Integer id) {
        contactService.delete(id);
        return "redirect:/contacts";
    }
}
