package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "addressbook")
public class AddressBookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private long phoneNumber;
    private int zip;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;

    public AddressBookModel(AddressBookDTO addressBookDTO) {
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
        this.zip = addressBookDTO.getZip();
    }

    public AddressBookModel() {
    }
}
