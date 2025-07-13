package com.student.DTO.Employee;
import lombok.Data;
import java.util.List;

@Data
public class EmployeeDTO {
    private Long empId;
    private String firstName;
    private String lastName;
    private Integer salary;
    private String designation;
    private String contact;
    private String gender;
    private List<EmployeeAddressDTO> addresses;
    private List<BankDetailsDTO> bankDetails;
}
