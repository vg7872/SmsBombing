package com.student.DTO.Employee;

import lombok.Data;

@Data
public class EmployeeAddressDTO {
    private Long addressId;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String pinCode;
    private String country;
}

