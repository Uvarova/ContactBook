package com.contacts.service;
/*
 * created by ellen
 * created on 21.06.2019
 * class created for project ContactBook
 */

import com.contacts.entity.Contact;
import com.contacts.entity.PhoneNumber;
import com.contacts.repository.ContactRepos;
import com.contacts.repository.PhoneRepos;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@NoArgsConstructor
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepos contactRepos;
    @Autowired
    private PhoneRepos phoneRepos;

    private Contact contact;
    private static final Logger LOGGER = Logger.getLogger(ContactServiceImpl.class.getName());

    @Override
    public Contact findById(Integer id) {
        return contactRepos.findById(id);
    }

    @Override
    public String save(Contact contact) {
        contactRepos.save(contact);
        LOGGER.info("contact " + contact.getId() + " is saved");
        return "ok";
    }

    @Override
    public void update(Contact contact) {
        if(contact.getId() != null) contactRepos.saveAndFlush(contact);
        LOGGER.info("contact " + contact.getId() + " is updated");
    }

    @Override
    public String delete(Integer id) {
        contact = contactRepos.findById(id);
        List<PhoneNumber> phones = phoneRepos.findByContactId(id);
        for (PhoneNumber curPhone:phones) {
            phoneRepos.delete(curPhone);
            LOGGER.info("phone " + curPhone.getId() + " is deleted");
        }
        contactRepos.delete(contact);
        LOGGER.info("contact " + contact.getId() + " is deleted");
        return "ok";
    }
}
