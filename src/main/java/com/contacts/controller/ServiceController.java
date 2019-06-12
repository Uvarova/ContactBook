package com.contacts.controller;
/*
 * created by ellen
 * created on 10.06.2019
 * class created for project ContactBook
 */

import com.contacts.entity.PhoneNumber;
import com.contacts.repository.PhoneRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ServiceController {

    @Autowired
    private PhoneRepos phoneRepos;

    @RequestMapping("/")
    public String greeting() {
        return "main";
    }

    @GetMapping("/allcontacts")
    public String showAll(Map<String, Object> map) {
        List<PhoneNumber> phones = phoneRepos.findAll();
        map.put("phones",phones);

        return "allcontacts";
    }


}
