package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import com.bridgelabz.addressbookapp.util.ResponseUtil;

import java.util.List;

public interface IAddressBookService {
    AddressBookModel addContact(AddressBookDTO addressBookDTO);

    AddressBookModel updateContact(Long id, AddressBookDTO addressBookDTO);

    List<AddressBookModel> getEmployees(String token);

    AddressBookModel deleteContact(Long id);

    AddressBookModel getEmployee(Long id);

    ResponseUtil login(String emailId, String password);
}
