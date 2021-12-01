package com.bridgelabz.addressbookspring.controller;


import com.bridgelabz.addressbookspring.dto.AddressBookDTO;
import com.bridgelabz.addressbookspring.dto.ResponseDTO;
import com.bridgelabz.addressbookspring.model.AddressBookData;
import com.bridgelabz.addressbookspring.services.IAddressBookService;
import com.bridgelabz.addressbookspring.dto.AddressBookDTO;
import com.bridgelabz.addressbookspring.dto.ResponseDTO;
import com.bridgelabz.addressbookspring.model.AddressBookData;
import com.bridgelabz.addressbookspring.services.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @RequestMapping(value={"","/","/get"})
    public ResponseEntity<ResponseDTO> getAddressBook(){
//    AddressBookData addressBookData = new AddressBookData(1,new AddressBookDTO("Raghav", 554));
        List<AddressBookData> addressBookData = addressBookService.getAddressBookData();
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Success",addressBookData), HttpStatus.OK);
    }

    @GetMapping("/get/{addressid}")
    public ResponseEntity<ResponseDTO> getAddressBook(@PathVariable("addressid")  int addressId)
    {
        //  AddressBookData addressBookData = new AddressBookData(addressId,new AddressBookDTO("Raghav", 554));
        AddressBookData addressBookData = addressBookService.getAddressBookDataById(addressId);
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Success",addressBookData), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddressBook(@RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = addressBookService.createData(addressBookDTO);
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Created Data",addressBookData),HttpStatus.OK);
    }

    @PutMapping("/update/{addressId}")
    public ResponseEntity<ResponseDTO> updateAddressBook(@PathVariable("addressId") int addressId,
                                                         @RequestBody AddressBookDTO addressBookDTO){
        AddressBookData addressBookData = addressBookService.updateData(addressId,addressBookDTO);
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Updated",addressBookData),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<ResponseDTO> deleteAddressBook(@PathVariable("addressId") int addressId){
        addressBookService.DeleteData(addressId);
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Deleted",addressId),HttpStatus.OK);
    }
    @GetMapping("/address/{city}")
    public ResponseEntity<ResponseDTO> getAdressByCity(@PathVariable String city){

        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getAddressByCity(city);
        ResponseDTO response = new ResponseDTO("Get Call for city Successful", addressBookDataList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
    @GetMapping("/address/{name}")
    public ResponseEntity<ResponseDTO> getAdressByName(@PathVariable String name){

        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getAddressByCity(name);
        ResponseDTO response = new ResponseDTO("Get Call for city Successful", addressBookDataList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
    @GetMapping("/address/{pincode}")
    public ResponseEntity<ResponseDTO> getAdressByPincode(@PathVariable long pincode){

        List<AddressBookData> addressBookDataList = null;
        addressBookDataList = addressBookService.getAddressByPincode(pincode);
        ResponseDTO response = new ResponseDTO("Get Call for city Successful", addressBookDataList);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
}

