package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Addressbook")
@Data
public class AddressBookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String emailId;
    private String password;
    private long phoneNumber;
    private LocalDateTime registerDate;
    private LocalDateTime updatedDate;

    public AddressBookModel(AddressBookDTO addressBookDTO) {
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
        this.zip = addressBookDTO.getZip();
        this.emailId=addressBookDTO.getEmailId();
        this.password=addressBookDTO.getPassword();
    }

    public AddressBookModel() {

    }
}
