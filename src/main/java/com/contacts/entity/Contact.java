package com.contacts.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


/*
 * created by ellen
 * created on 10.06.2019
 * class created for project ContactBook
 */


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact")
    private List<PhoneNumber> phoneNumbers;

    public Contact(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
