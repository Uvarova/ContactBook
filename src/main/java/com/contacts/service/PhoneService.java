package com.contacts.service;
/*
 * created by ellen
 * created on 24.06.2019
 * class created for project ContactBook
 */

import com.contacts.entity.PhoneNumber;

public interface PhoneService {
    PhoneNumber findById(Integer id);
    String save(PhoneNumber phone);
    void update(PhoneNumber phone);
    String delete(Integer id);
}
