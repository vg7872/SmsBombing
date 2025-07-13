package com.student.Repository;

import com.student.Entity.Student.StudentMarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentMarksRepository extends JpaRepository<StudentMarksEntity, Long> {
}
