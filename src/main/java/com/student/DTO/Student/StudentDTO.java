package com.student.DTO.Student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {

    @JsonProperty("Roll Number")
    private Long rollNumber;

    @JsonProperty("First Name")
    private String firstName;

    @JsonProperty("Last Name")
    private String lastName;

    @JsonProperty("Mobile Number")
    private String mobileNumber;

    @JsonProperty("Class Name")
    private String className;

    @JsonProperty("Email Id")
    private String emailAddress;

    @JsonProperty("Address")
    private String addressDetails;

    @JsonProperty("Madhyamic Marks")
    private Long madhyamicMarks;

    @JsonProperty("HS Marks")
    private Long hsMarks;
}
