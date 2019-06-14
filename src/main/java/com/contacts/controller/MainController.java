package com.contacts.controller;
/*
 * created by ellen
 * created on 10.06.2019
 * class created for project ContactBook
 */

import com.contacts.entity.Contact;
import com.contacts.entity.PhoneNumber;
import com.contacts.repository.ContactRepos;
import com.contacts.repository.PhoneRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private PhoneRepos phoneRepos;
    @Autowired
    private ContactRepos contactRepos;

    @RequestMapping("/")
    public String greeting() {
        return "main";
    }

    @GetMapping("/allcontacts")
    public String showAll(Map<String, Object> map) {
        List<PhoneNumber> phones = phoneRepos.findAll();
        map.put("phones",phones);
        List<Contact> contacts = contactRepos.findDistinctByPhoneNumbersIsNull();
        map.put("contacts", contacts);
        return "allcontacts";
    }


}
