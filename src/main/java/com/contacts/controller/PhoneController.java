package com.contacts.controller;
/*
 * created by ellen
 * created on 11.06.2019
 * class created for project ContactBook
 */

import com.contacts.entity.Contact;
import com.contacts.entity.PhoneNumber;
import com.contacts.service.ContactService;
import com.contacts.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PhoneController {

    @Autowired
    private ContactService contactService;
    @Autowired
    private PhoneService phoneService;
    private PhoneNumber currentPhone;

    @GetMapping("phones")
    public String contacts(Model model) {
        model.addAttribute("result", "");
        return "phones";
    }

    @PostMapping("phones")
    public String createPhone(@RequestParam(name = "contactId", required = false, defaultValue = "") Integer contactId,
                              @RequestParam(name = "operatorName", required = false, defaultValue = "") String operatorName,
                              @RequestParam(name = "number", required = false, defaultValue = "") String number,
                              Model model) {

        Contact contact = contactService.findById(contactId);
        if(contact != null) {
            PhoneNumber phoneNumber = new PhoneNumber(operatorName, number, contact);
            phoneService.save(phoneNumber);
            model.addAttribute("result", "ok");
        }
        else{
            model.addAttribute("result", "no such contact");
        }

        return "phones";
    }

    @PostMapping("patchp")
    public String showPhone(@RequestParam(name = "id", required = true, defaultValue = "") Integer id,
                            Model model) {

        currentPhone = phoneService.findById(id);
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
        phoneService.update(phone);
    }

    @PostMapping("/deleteph")
    private String deletePhone(@RequestParam(name = "id", required = true, defaultValue = "") Integer id) {
        phoneService.delete(id);
        return "redirect:/phones";
    }
}
