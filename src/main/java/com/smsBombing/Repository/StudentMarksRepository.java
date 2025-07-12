package com.smsBombing.Repository;

import com.smsBombing.Entity.Student.StudentEntity;
import com.smsBombing.Entity.Student.StudentMarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentMarksRepository extends JpaRepository<StudentMarksEntity, Long> {
}
