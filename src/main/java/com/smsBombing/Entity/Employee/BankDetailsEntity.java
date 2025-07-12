package com.smsBombing.Entity.Employee;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BANK_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BANK_DETAILS_ID")
    private Long bankDetailsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMP_ID")
    private EmployeeEntity employee;

    @Column(name = "BANK_ACCOUNT_NUMBER")
    private Long accountNumber;

    @Column(name = "BANK_NAME", length = 50)
    private String bankName;

    @Column(name = "BANK_ADDRESS", length = 50)
    private String bankAddress;

    @Column(name = "IFSC_CODE", length = 50)
    private String ifscCode;

    @Column(name = "CIF_NUMBER")
    private Long cifNumber;
}
