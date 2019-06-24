package com.contacts.service;
/*
 * created by ellen
 * created on 21.06.2019
 * class created for project ContactBook
 */

import com.contacts.entity.Contact;
import com.contacts.repository.ContactRepos;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepos contactRepos;

    @Override
    public Contact findById(Integer id) {
        return contactRepos.findById(id);
    }

    @Override
    public String save(Contact contact) {
        contactRepos.save(contact);
        return "ok";
    }

    @Override
    public void update(Contact contact) {
        if(contact.getId() != null) contactRepos.saveAndFlush(contact);
    }
}