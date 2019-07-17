package com.contacts.service;
/*
 * created by ellen
 * created on 24.06.2019
 * class created for project ContactBook
 */

import com.contacts.entity.Contact;
import com.contacts.entity.PhoneNumber;
import com.contacts.repository.PhoneRepos;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@NoArgsConstructor
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PhoneRepos phoneRepos;
    private static final Logger LOGGER = Logger.getLogger(ContactServiceImpl.class.getName());
    private Contact currentContact;

    @Override
    public PhoneNumber findById(Integer id) {
        return phoneRepos.findById(id);
    }

    @Override
    public String save(PhoneNumber phone) {
        phoneRepos.save(phone);
        LOGGER.info("phone " + phone.getId() + " is saved");
        return "ok";
    }

    @Override
    public void update(PhoneNumber phone) {
        currentContact = phoneRepos.findById(phone.getId()).getContact();
        phone.setContact(currentContact);
        if(phone.getId() != null && phone.getContact() != null) {
            phoneRepos.saveAndFlush(phone);
            LOGGER.info("phone " + phone.getId() + " is updated");
        }
    }

    @Override
    public String delete(Integer id) {
        phoneRepos.delete(phoneRepos.findById(id));
        LOGGER.info("phone " + id + " is deleted");
        return "ok";
    }


}
