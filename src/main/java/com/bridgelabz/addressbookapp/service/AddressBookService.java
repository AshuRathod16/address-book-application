package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService{

    @Autowired
    AddressBookRepository addressBookRepository;

    @Override
    public AddressBookModel addContact(AddressBookDTO addressBookDTO){
        AddressBookModel addressBookModel = new AddressBookModel(addressBookDTO);
        addressBookModel.setRegisterDate(LocalDateTime.now());
        addressBookRepository.save(addressBookModel);
        return addressBookModel;
    }

    @Override
    public AddressBookModel updateContact(Long id, AddressBookDTO addressBookDTO){
        Optional<AddressBookModel> isContactPresent = addressBookRepository.findById(id);
        if (isContactPresent.isPresent()){
            isContactPresent.get().setFirstName(addressBookDTO.getFirstName());
            isContactPresent.get().setLastName(addressBookDTO.getLastName());
            isContactPresent.get().setAddress(addressBookDTO.getAddress());
            isContactPresent.get().setCity(addressBookDTO.getCity());
            isContactPresent.get().setState(addressBookDTO.getState());
            isContactPresent.get().setPhoneNumber(addressBookDTO.getPhoneNumber());
            isContactPresent.get().setZip(addressBookDTO.getZip());
            isContactPresent.get().setUpdatedDate(LocalDateTime.now());
            addressBookRepository.save(isContactPresent.get());
            return isContactPresent.get();
        } else {
            throw new AddressBookException(400, "Contact is not Found");
        }
    }

    @Override
    public List<AddressBookModel> getEmployees() {
        List<AddressBookModel> isContactPresent = addressBookRepository.findAll();
        if (isContactPresent.size() > 0){
            return isContactPresent;
        } else {
            throw new AddressBookException(400, "No Contact Is There");
        }
    }

    @Override
    public AddressBookModel deleteContact(Long id){
        Optional<AddressBookModel> isContactPresent = addressBookRepository.findById(id);
        if (isContactPresent.isPresent()){
            addressBookRepository.delete(isContactPresent.get());
            return isContactPresent.get();
        } else {
            throw new AddressBookException(400, "Contact Not Found");
        }
    }

    @Override
    public AddressBookModel getEmployee(Long id){
        Optional<AddressBookModel> isContactPresent = addressBookRepository.findById(id);
        if (isContactPresent.isPresent()){
            return isContactPresent.get();
        } else {
            throw new AddressBookException(400, "Contact Not Found");
        }
    }
}
