package com.smsBombing.Repository;


import com.smsBombing.Entity.Student.StudentEntity;
import com.smsBombing.Entity.Student.StudentMarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @Query("SELECT s FROM StudentEntity s WHERE s.rollNumber = :rollNumber")
    StudentEntity findByRollNumber(@Param("rollNumber") Long rollNumber);



}
