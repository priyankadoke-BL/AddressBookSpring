package com.bridgelabz.addressbookspring.services;

import com.bridgelabz.addressbookspring.dto.AddressBookDTO;
import com.bridgelabz.addressbookspring.exceptions.AddressBookExceptions;
import com.bridgelabz.addressbookspring.model.AddressBookData;
import com.bridgelabz.addressbookspring.repository.AddressBookRepositery;
import com.bridgelabz.addressbookspring.services.IAddressBookService;
import com.bridgelabz.addressbookspring.dto.AddressBookDTO;
import com.bridgelabz.addressbookspring.exceptions.AddressBookExceptions;
import com.bridgelabz.addressbookspring.model.AddressBookData;
import com.bridgelabz.addressbookspring.repository.AddressBookRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepositery addressBookRepositery;


    @Override
    public List<AddressBookData> getAddressBookData() {
        return addressBookRepositery.findAll();
    }

    @Override
    public AddressBookData getAddressBookDataById(int AddressBookID) {
        return addressBookRepositery.findById(AddressBookID)
                .orElseThrow(() -> new AddressBookExceptions("Employee with EmployeeId" + AddressBookID
                        + " Doesn't Exists...!"));
    }

    @Override
    public AddressBookData createData(AddressBookDTO addressBookDTO) {
        AddressBookData addData = null;
        addData = new AddressBookData(addressBookDTO);
        return addressBookRepositery.save(addData);
    }

    @Override
    public AddressBookData updateData(int AddressBookID, AddressBookDTO addressBookDTO) {
        AddressBookData addData = this.getAddressBookDataById(AddressBookID);
        addData.updateData(addressBookDTO);
        return addressBookRepositery.save(addData);
    }

    @Override
    public void DeleteData(int AddressBookID) {
        AddressBookData addData = this.getAddressBookDataById(AddressBookID);
        addressBookRepositery.delete(addData);
    }

    @Override
    public List<AddressBookData> getAddressByCity(String city) {
        return addressBookRepositery.findByCity(city);
    }

    @Override
    public List<AddressBookData> getAddressByPincode(long pincode) {
        return addressBookRepositery.findByPincode(pincode);
    }

    @Override
    public List<AddressBookData> getAddressByName(String name) {
        return addressBookRepositery.findByName(name);
    }
}
