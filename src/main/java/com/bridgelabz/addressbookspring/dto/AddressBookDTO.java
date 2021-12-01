package com.bridgelabz.addressbookspring.dto;

import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public @ToString
class  AddressBookDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    @NotEmpty(message = "Employee Name can't be null")
    public String name;
    @NotNull(message = "department should not be empty")
    public long contact;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    @NotEmpty(message = "Employee Name can't be null")
    public String lName;

    @NotEmpty(message = "Employee Name can't be null")
    public String address;
    @NotEmpty(message = "Employee Name can't be null")
    public String city;
    @NotEmpty(message = "Employee Name can't be null")
    public long zip;
    @NotEmpty(message = "Employee Name can't be null")
    public String email;

}
