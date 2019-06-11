package com.contacts.controller;
/*
 * created by ellen
 * created on 11.06.2019
 * class created for project ContactBook
 */

import com.contacts.entity.Contact;
import com.contacts.entity.PhoneNumber;
import com.contacts.repository.ContactRepos;
import com.contacts.repository.PhoneRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller

public class PhoneController {

    @Autowired
    private ContactRepos contactRepos;
    @Autowired
    private PhoneRepos phoneRepos;

    @GetMapping("phones")
    public String contacts(Map<String, Object> model) {
        return "phones";
    }

    @PostMapping("phones")
    public String createContact(@RequestParam(name = "contactId", required = false, defaultValue = "") Integer contactId,
                                @RequestParam(name = "operatorName", required = false, defaultValue = "") String operatorName,
                                @RequestParam(name = "phoneNumbers", required = false, defaultValue = "") String number,
                                Map<String, Object> model) {

        Contact contact = contactRepos.findById(contactId);
        PhoneNumber phoneNumber = new PhoneNumber(operatorName, number, contact);

        phoneRepos.save(phoneNumber);

        return "phones";
    }

}
