package com.smsBombing.Impl;

import com.smsBombing.DTO.Employee.BankDetailsDTO;
import com.smsBombing.DTO.Employee.EmployeeAddressDTO;
import com.smsBombing.DTO.Employee.EmployeeDTO;
import com.smsBombing.Entity.Employee.EmployeeEntity;
import com.smsBombing.Entity.Employee.EmployeeAddressEntity;
import com.smsBombing.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<EmployeeEntity>  getEmployeeDetailsAboveSixtyThouSalary(){
        return employeeRepository.getEmployeeDetailsAboveSixtyThouSalary();
    }

   /* public EmployeeDTO getEmployeeById(Long id) {
        EmployeeDTO employeeDTO = null;
//        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        EmployeeEntity employeeEntity = employeeRepository.findByEmployeeId(id);
        System.out.println("Employee entity fetched from DB :  "+ employeeEntity);



        if (employeeEntity != null){
            employeeDTO = new EmployeeDTO();
            employeeDTO.setEmpId(employeeEntity.getEmpId());
            employeeDTO.setFirstName(employeeEntity.getFirstName());

            List<EmployeeAddressDTO> employeeAddressesDTOList = null;
            if (employeeEntity.getAddresses() != null){
                 employeeAddressesDTOList = new ArrayList<>();
                for (EmployeeAddressEntity employeeAddressEntity: employeeEntity.getAddresses()){
                    EmployeeAddressDTO employeeAddressDTO = new EmployeeAddressDTO();
                    employeeAddressDTO.setAddress1(employeeAddressEntity.getAddress1());
                    employeeAddressDTO.setAddress2(employeeAddressEntity.getAddress2());
                    employeeAddressesDTOList.add(employeeAddressDTO);
                }
            }
            employeeDTO.setAddresses(employeeAddressesDTOList);

            List<BankDetailsDTO> employeBankListDTO = null;
            if (employeeEntity.getBankDetails() != null){
                employeBankListDTO = new ArrayList<>();
                for (BankDetailsEntity bankDetailsEntity: employeeEntity.getBankDetails()){
                    BankDetailsDTO bankDetailsDTO = new BankDetailsDTO();
                    bankDetailsDTO.setBankName(bankDetailsEntity.getBankName());
                    bankDetailsDTO.setAccountNumber(bankDetailsEntity.getAccountNumber());
                    employeBankListDTO.add(bankDetailsDTO);
                }

            }
            employeeDTO.setBankDetails(employeBankListDTO);
        }
        return employeeDTO;
    }*/

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeDTO employeeDTO = new EmployeeDTO();

        //fetch data  from DB
        EmployeeEntity employeeEntity = employeeRepository.findByEmployeeId(id);

        //Now My aim is to get the data from Entity object[employeeEntity] and set the data to DTO Object[EmployeeDTO]
        employeeDTO.setFirstName(employeeEntity.getFirstName());


        List<EmployeeAddressDTO> employeeAddressDTOList = new ArrayList<>();


        for (EmployeeAddressEntity employeeAddressFromDB :employeeEntity.getEmployeeAddressEntityList()){
            EmployeeAddressDTO employeeAddressDTO = new EmployeeAddressDTO();
            employeeAddressDTO.setAddress1(employeeAddressFromDB.getAddress1());

            employeeAddressDTOList.add(employeeAddressDTO);
        }
        employeeDTO.setAddresses(employeeAddressDTOList);



        List<BankDetailsDTO> bankDetailsDTOList = new ArrayList<>();
        employeeDTO.setBankDetails(bankDetailsDTOList);

        return employeeDTO;
    }

    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        // Because of CascadeType.ALL, address and bank details will be saved automatically
        /*employee.getAddress().setEmployee(employee);
        employee.getBankDetails().setEmployee(employee);*/
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

