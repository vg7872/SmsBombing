package com.student.Entity.Employee;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "EMPLOYEE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    @Id
    @Column(name = "EMP_ID")
    private Long empId;

    @Column(name = "EMP_FIRST_NAME", length = 20)
    private String firstName;

    @Column(name = "EMP_LAST_NAME", length = 20)
    private String lastName;

    @Column(name = "EMP_SALARY")
    private Integer salary;

    @Column(name = "EMP_DESIGNATION", length = 50)
    private String designation;

    @Column(name = "EMP_CONTACT", length = 10)
    private String contact;

    @Column(name = "GENDER", length = 1)
    private String gender;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeAddressEntity> employeeAddressEntityList;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BankDetailsEntity> bankDetailsEntityList;
}


