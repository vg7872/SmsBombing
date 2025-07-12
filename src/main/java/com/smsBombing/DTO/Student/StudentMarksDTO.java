package com.smsBombing.DTO.Student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentMarksDTO {

    @JsonProperty("Roll Number")
    private Long rollNumber;

    @JsonProperty("Madhyamic Marks")
    private Long madhyamicMarks;

    @JsonProperty("HS Marks")
    private Long hsMarks;

}
