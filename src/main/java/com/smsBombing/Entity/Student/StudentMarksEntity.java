package com.smsBombing.Entity.Student;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="MARKS")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentMarksEntity {

    @Id
    @Column(name="ROLL_NUMBER")
    private Long rollNumber;

    @Column(name="MADHYAMIC_MARKS")
    private Long madhyamicMarks;

    @Column(name="HS_MARKS")
    private Long hsMarks;

//    @OneToOne
//    @JoinColumn(name = "ROLL_NUMBER", referencedColumnName = "ROLL_NUMBER", insertable = false, updatable = false)
//    private StudentEntity student;



}
