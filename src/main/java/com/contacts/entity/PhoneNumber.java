package com.contacts.entity;
/*
 * created by ellen
 * created on 10.06.2019
 * class created for project ContactBook
 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String operatorName;
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact")
    private Contact contact;


    public PhoneNumber(String operatorName, String number, Contact contact){
        this.operatorName = operatorName;
        this.number = number;
        this.contact = contact;
    }
}
