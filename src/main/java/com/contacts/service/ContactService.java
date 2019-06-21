package com.contacts.service;
/*
 * created by ellen
 * created on 21.06.2019
 * class created for project ContactBook
 */

import com.contacts.entity.Contact;

public interface ContactService {
    public String save(Contact contact);
    public void update(Contact contact);
}
