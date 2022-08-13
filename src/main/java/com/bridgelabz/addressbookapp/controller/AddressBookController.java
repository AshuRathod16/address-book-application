package com.bridgelabz.addressbookapp.controller;


import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @Autowired
    IAddressBookService addressBookService;

    @PostMapping("/addcontact")
    public AddressBookModel addContact(@RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.addContact(addressBookDTO);
    }

    @PutMapping("/updatecontact/{id}")
    public AddressBookModel updateContact(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.updateContact(id, addressBookDTO);
    }

    @GetMapping("/getemployees")
    public List<AddressBookModel> getEmployees() {
        return addressBookService.getEmployees();
    }

    @DeleteMapping("/deletecontact/{id}")
    public AddressBookModel deleteContact(@PathVariable Long id) {
        return addressBookService.deleteContact(id);
    }

    @GetMapping("/getemployee/{id}")
    public AddressBookModel getEmployee(@PathVariable Long id) {
        return addressBookService.getEmployee(id);
    }
}
