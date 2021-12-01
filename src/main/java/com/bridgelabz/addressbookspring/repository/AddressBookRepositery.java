package com.bridgelabz.addressbookspring.repository;



import com.bridgelabz.addressbookspring.model.AddressBookData;
import com.bridgelabz.addressbookspring.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressBookRepositery extends JpaRepository<AddressBookData, Integer> {
    @Query(value = "SELECT * FROM address_book WHERE city =?1",nativeQuery = true)
    List<AddressBookData> findByCity(String city);
    @Query(value = "SELECT * FROM address_book WHERE name =?1",nativeQuery = true)
    List<AddressBookData> findByName(String name);
    @Query(value = "SELECT * FROM address_book WHERE pincode =?1",nativeQuery = true)
    List<AddressBookData> findByPincode(long pincode);

}
