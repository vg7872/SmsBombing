package com.student.Entity.Employee;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "EMPLOYEE_ADDRESS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private Long addressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMP_ID")
    private EmployeeEntity employee;

    @Column(name = "ADDRESS_1", length = 50)
    private String address1;

    @Column(name = "ADDRESS_2", length = 50)
    private String address2;

    @Column(name = "CITY", length = 50)
    private String city;

    @Column(name = "STATE", length = 2)
    private String state;

    @Column(name = "PIN_CODE", length = 10)
    private String pinCode;

    @Column(name = "COUNTRY", length = 50)
    private String country;
}

