package com.student.Controller;
import com.student.DTO.Employee.EmployeeDTO;
import com.student.Entity.Employee.EmployeeEntity;
import com.student.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    // 🔍 2. Get one employee
    @GetMapping("/fetch/employee/{id}")
    public EmployeeDTO getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }


    // 🔍 1. Get All Employees with address and bank details
    @GetMapping("/fetch/employees")
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/fetch/employee/highSalry")
    public List<EmployeeEntity> getEmployeeDetailsAboveSixtyThouSalary() {
        return employeeService.getEmployeeDetailsAboveSixtyThouSalary();
    }


    // ✏️ 3. Create or Update an employee
    @PostMapping
    public EmployeeEntity createOrUpdate(@RequestBody EmployeeEntity employee) {
        return employeeService.saveEmployee(employee);
    }

    // ❌ 4. Delete an employee
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}

