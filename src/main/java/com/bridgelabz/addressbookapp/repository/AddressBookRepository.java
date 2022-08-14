package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressBookRepository extends JpaRepository<AddressBookModel, Long> {
    Optional<AddressBookModel> findByEmailId(String emailId);
}
