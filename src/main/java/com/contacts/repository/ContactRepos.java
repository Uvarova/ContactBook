package com.contacts.repository;
/*
 * created by ellen
 * created on 10.06.2019
 * class created for project ContactBook
 */

import com.contacts.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepos extends JpaRepository<Contact, Long> {
    Contact findById(Integer id);
    List<Contact> findDistinctByPhoneNumbersIsNull();
}
