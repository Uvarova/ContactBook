package com.contacts.repository;
/*
 * created by ellen
 * created on 10.06.2019
 * class created for project ContactBook
 */

import com.contacts.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepos extends JpaRepository<PhoneNumber, Long> {
    PhoneNumber findById(Integer id);
    List<PhoneNumber> findByContactId(Integer id);
}
