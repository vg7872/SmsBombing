package com.student.Repository;


import com.student.Entity.Student.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @Query("SELECT s FROM StudentEntity s WHERE s.rollNumber = :rollNumber")
    StudentEntity findByRollNumber(@Param("rollNumber") Long rollNumber);



}
