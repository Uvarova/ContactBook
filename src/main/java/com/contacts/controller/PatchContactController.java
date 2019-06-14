package com.contacts.controller;
/*
 * created by ellen
 * created on 13.06.2019
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
public class PatchContactController {
    @Autowired
    private ContactRepos contactRepos;
    private Contact currentContact;

    @PostMapping("patch")
    public String showContact(@RequestParam(name = "id", required = true, defaultValue = "") Integer id,
                               Model model) {

        currentContact = contactRepos.findById(id);
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
        if(contact.getId() != null) contactRepos.saveAndFlush(contact);
    }

}
