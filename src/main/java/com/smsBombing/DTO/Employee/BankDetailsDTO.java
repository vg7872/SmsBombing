package com.smsBombing.DTO.Employee;
import lombok.Data;

@Data
public class BankDetailsDTO {
    private Long bankDetailsId;
    private Long accountNumber;
    private String bankName;
    private String bankAddress;
    private String ifscCode;
    private Long cifNumber;
}
