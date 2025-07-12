package com.smsBombing.Entity.Student;

import com.smsBombing.Entity.Employee.EmployeeAddressEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "COLLEGE_STUDENTS")  // this is to map this entity class[StudentEntity] with table in data base
@Data
@Getter //This will create all the getter
@Setter //This will create all the setter
@NoArgsConstructor //This will be used to create Default constructor
@AllArgsConstructor //This will be used to create parameterized constructor
public class StudentEntity {

//    @Id       //this is mention to identify to primari key as a roll no
//    @Column(name = "ROLL_NUMBER")  //this is to map with DB coloum name
//    private Long rollNumber;
//
//    @Column(name = "STUDENT_FIRST_NAME")
//    private String firstName;
//
//    @Column(name = "STUDENT_LAST_NAME")
//    private String lastName;
//
//    @Column(name = "STUDENT_MOBILE_NUMBER")
//    private String mobileNumber;
//
//    @Column(name = "STUDENT_CLASS")
//    private String className;
//
//    @Column(name = "STUDENT_EMAIL_NUMBER")
//    private String emailAddress;
//
//    @Column(name = "STUDENT_ADDRESS")
//    private String addressDetails;

//    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
//    private StudentMarksEntity studentMarks;

//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @OneToMany(mappedBy = "Student", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<StudentMarksEntity> StudentMarksEntityList;

    @Id
    @Column(name="roll_number")
   private Long rollNumber;

   @Column(name="first_name")
   private String firstName;

   @Column(name="last_name")
   private String lastName;

   @Column(name="email")
   private String email;

   @Column(name="mobile_number")
    private String mobileNumber;


}


    /*CREATE TABLE STUDENT (
        ROLL_NUMBER            NUMBER(10) PRIMARY KEY,
    STUDENT_FIRST_NAME     VARCHAR2(50),
    STUDENT_LAST_NAME      VARCHAR2(50),
    STUDENT_MOBILE_NUMBER  VARCHAR2(50),
    STUDENT_CLASS          VARCHAR2(50),
    STUDENT_EMAIL_NUMBER   VARCHAR2(50),
    STUDENT_ADDRESS        VARCHAR2(50)
);*/
