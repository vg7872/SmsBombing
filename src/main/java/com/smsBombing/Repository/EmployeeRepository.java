package com.smsBombing.Repository;

import com.smsBombing.Entity.Employee.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Query("SELECT e FROM EmployeeEntity e WHERE e.empId = :empId")
    EmployeeEntity findByEmployeeId(@Param("empId") Long empId);

    @Query("SELECT e FROM EmployeeEntity e WHERE e.salary > 60000")
    List<EmployeeEntity> getEmployeeDetailsAboveSixtyThouSalary();




   /* @Query("SELECT e FROM Employee e JOIN e.address a WHERE a.city = :city")
    List<Employee> findByCity(@Param("city") String city);
*/
}
