package com.smsBombing.Controller;

import com.smsBombing.DTO.Response.EmployeeSaveResponse;
import com.smsBombing.DTO.Student.StudentDTO;
import com.smsBombing.Entity.Student.StudentEntity;
import com.smsBombing.Entity.Student.StudentMarksEntity;
import com.smsBombing.Exception.StudentException;
import com.smsBombing.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller is used to work for student database.........
 */
@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

//fetch data by dto-----------------------------------------------------------------------------------------------------------
 //--------  - ---------------------------------------------------------------------------------------------------------------------------
    @GetMapping("/fetch/student/dto/{rollNumber}")
    public StudentDTO getStudentDTOByRollNo(@PathVariable("rollNumber") Long rollNumber) {

        //Way : 1
       /* StudentDTO studentDTO = studentService.fetchStudentDetailsByRollNumber(rollNumber);
        return studentDTO;*/

        //Way : 2
        return studentService.fetchStudentDetailsByRollNumber(rollNumber);

        //Way : 3
        /*StudentDTO studentDTO = new StudentDTO();
        System.out.println("Roll number is :: "+ rollNumber);
        Optional<StudentEntity> studentEntityOptional= studentRepository.findById(rollNumber);  //after create findById optional will be created
        StudentEntity studentEntity = studentEntityOptional.get();
        System.out.println("Student entity optional :: "+ studentEntity);

        studentDTO.setRollNumber(studentEntity.getRollNumber());
        studentDTO.setFirstName(studentEntity.getFirstName());
        studentDTO.setLastName(studentEntity.getLastName());
        studentDTO.setClassName(studentEntity.getClassName());
        studentDTO.setMobileNumber(studentEntity.getMobileNumber());
        studentDTO.setEmailAddress(studentEntity.getEmailAddress());
        studentDTO.setAddressDetails(studentEntity.getAddressDetails());

        return  studentDTO;*/
    }

//fetch ALL data by entity---------------------------------------------------------------------------------------------------------
    //Ekhane amra jeta DB theke pabo[mane StudentEntity typ er], setakei return korbo
    @GetMapping("/fetch/student/entity")
    public List<StudentEntity> fetchAllStudentDataFromEntity() {
        return studentService.fetchAllStudentDat();
    }

//fetch ALL data by dto------------------------------------------------------------------------------------------------------------
    //Ekhane jeta amra DB theke pabp[Mane studentEntity] setake convert korbo StudentDTO te.
    @GetMapping("/fetch/studentDTO")
    public List<StudentDTO> fetchAllStudentDataOfDTOType() {
        return studentService.fetchAllStudentDto();
    }
 //---------------------------------------------------------------------------------------------------------------------------
//save data bt entity
//-------------------------------------------------------------------------------------------------------------------------------

    @PostMapping("/save/student")
    public String saveStudent(@RequestBody StudentEntity studentEntityFromPayloadBody) {
        return studentService.saveStudentData(studentEntityFromPayloadBody);
    }

    @PostMapping("/save/student/optional")
    public EmployeeSaveResponse saveStudentOptional(@RequestBody StudentEntity studentEntityFromPayloadBody) throws  Exception, StudentException {
        /*EmployeeSaveResponse employeeSaveResponse = studentService.saveStudentDataOptional(studentEntityFromPayloadBody);
        return  employeeSaveResponse;*/
        return studentService.saveStudentDataOptional(studentEntityFromPayloadBody);
        /*EmployeeSaveResponse employeeSaveResponse = new EmployeeSaveResponse();

        if (message.equalsIgnoreCase("Data successfully saved.")) {
            employeeSaveResponse.setMessage(message);
            employeeSaveResponse.setStatus("Success.");
        } else if (message.equalsIgnoreCase("Student data is already exist in DB")){
            employeeSaveResponse.setMessage(message);
            employeeSaveResponse.setStatus("Failed.");
        } else {
            employeeSaveResponse.setStatus("Unknown.");
            employeeSaveResponse.setMessage("Something went wrong.");
        }
        return employeeSaveResponse;*/
    }

//-------------------------------------------------------------------------------------------------------------------------------
// Save data by dto
//--------------------------------------------------------------------------------------------------------------------------------
    @PostMapping("/save/student/dto")
    public String saveStudentDto(@RequestBody StudentDTO studentDtoFromPayloadBody) {
        return studentService.saveStudentData(studentDtoFromPayloadBody);
    }

//delete data-------------------------------------------------------------------------------------------------------------
    @GetMapping("/delete/student/{rollNumber}")
    public String deleteData(@PathVariable("rollNumber") Long rollNumber) {

        return studentService.deleteDataFromDb(rollNumber);
    }
//Update data by link-------------------------------------------------------------------------------------------------------

    @PutMapping("/update/student/firstName/lastName/{rollNumber}")
    public String studentUpdate(@PathVariable("rollNumber") Long rollNumber,
                                @RequestParam("newFristName") String newFristName,
                                @RequestParam("newLastName") String newLastName) {

        return studentService.updateData(rollNumber,newFristName,newLastName);

    }


// Update Data by Dto-------------------------------------------------------------------------------------------------------

    @PostMapping("/update/student/dto")
    public String updateDataByBodyPayload(@RequestBody StudentDTO StudentDTOPay){

        return studentService.updateDataByBody(StudentDTOPay);
    }

//-Save data in Marks table----------------------------------------------------------------------------------------------------------------------------------


   @PostMapping("/save/student/marks")
   public String saveStudentMarksEntity(@RequestBody StudentMarksEntity StudentMarksEntity) {
      return studentService.studentMarksEntity(StudentMarksEntity);
       //return s;
 }

 //-fech data from both table-------------------------------------------------------------------------------------------------------------------

        @GetMapping("/fech/allData/{rollNumber}")
        public StudentDTO getStudentAllDataByDto(@PathVariable("rollNumber") Long rollNumber) {


            return studentService.fechAllDataFromBothTable(rollNumber);
    }
}
