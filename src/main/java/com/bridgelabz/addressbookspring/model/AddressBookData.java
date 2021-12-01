package com.bridgelabz.addressbookspring.model;

import com.bridgelabz.addressbookspring.dto.AddressBookDTO;
import com.bridgelabz.addressbookspring.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="address_book")
public @Data class AddressBookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int id;
    private String name;
    private String lName;
    private String address;
    private String city;
    private long zip;
    private String email;
    private long contact;

    public AddressBookData( AddressBookDTO addressBookDTO) {

        this.updateData(addressBookDTO);

    }
    public void updateData(AddressBookDTO addressBookDTO){
        this.name = addressBookDTO.name;
        this.contact = addressBookDTO.contact;
        this.lName = addressBookDTO.lName;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.zip = addressBookDTO.zip;
    }
    public AddressBookData() {

    }
}
