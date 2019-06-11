package com.contacts.controller;
/*
 * created by ellen
 * created on 10.06.2019
 * class created for project ContactBook
 */

import com.contacts.entity.Contact;
import com.contacts.repository.ContactRepos;
import com.contacts.repository.PhoneRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ServiceController {

    @Autowired
    private ContactRepos contactRepos;
    @Autowired
    private PhoneRepos phoneRepos;


    @GetMapping("/")
    public String greeting(
            Map<String, Object> model) {
        return "main";
    }

    @GetMapping("allcontacts")
    public String searchMess(Map<String, Object> model) {
        List<Contact> contacts = contactRepos.findAll();
      /*  for(Contact next:contacts) {
            List<PhoneNumber> numbers = phoneRepos.findById(next.getId());
            model.put("numbers", numbers);
        }*/
        //   model.put("contacts", contacts);
        return "allcontacts";
    }


}
