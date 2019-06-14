package com.contacts.controller;
/*
 * created by ellen
 * created on 13.06.2019
 * class created for project ContactBook
 */

import com.contacts.entity.Contact;
import com.contacts.entity.PhoneNumber;
import com.contacts.repository.ContactRepos;
import com.contacts.repository.PhoneRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PatchPhoneController {
    @Autowired
    private PhoneRepos phoneRepos;
    @Autowired
    private ContactRepos contactRepos;
    private PhoneNumber currentPhone;
    private Contact currentContact;

    @PostMapping("patchp")
    public String showPhone(@RequestParam(name = "id", required = true, defaultValue = "") Integer id,
                               Model model) {

        currentPhone = phoneRepos.findById(id);
        if (currentPhone == null) return "redirect:/phones";
        model.addAttribute("phone",currentPhone);
        return "patchphone";
    }

    @GetMapping("patchp")
    private String getPhone (Model model){
        return "patchp";
    }

    @PostMapping("patchp/toDo")
    private String updatePhone(Model model, PhoneNumber phone) {
        model.addAttribute("phone", phone);
        patchPhone(model, phone);
        return "redirect:/phones";
    }

    @PatchMapping("patchp/toDo")
    private void patchPhone(Model model, PhoneNumber phone) {
        Integer contactId = currentPhone.getContact().getId();
        currentContact = contactRepos.findById(contactId);
        phone.setContact(currentContact);
        if(phone.getId() != null && phone.getContact() != null) phoneRepos.saveAndFlush(phone);
    }

}
