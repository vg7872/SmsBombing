package com.smsBombing.Impl;

import com.smsBombing.DTO.Response.EmployeeSaveResponse;
import com.smsBombing.DTO.Student.StudentDTO;
import com.smsBombing.Entity.Student.StudentEntity;
import com.smsBombing.Entity.Student.StudentMarksEntity;

//import com.smsBombing.Repository.StudentMarksRepository;
import com.smsBombing.Exception.StudentException;
import com.smsBombing.Repository.StudentMarksRepository;
import com.smsBombing.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl {
    @Autowired
    private StudentRepository studentRepository;  //to creste import ctrl+space+ enter
    @Autowired
    private StudentMarksRepository StudentMarksRepository;


    // Data fetch by Dto------------------------------------------------------------------------------------------------
    public StudentDTO fetchStudentDetailsByRollNumber(Long rollNumber) {
        StudentDTO studentDTO = new StudentDTO();
        System.out.println("Roll number is :: " + rollNumber);
        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(rollNumber);  //after create findById optional will be created
        StudentEntity studentEntity = studentEntityOptional.get();//StudentEntity : eta DB theke peyechi
        System.out.println("Student entity optional :: " + studentEntity);

      //  if(studentEntityOptional.isPresent()){
        //Ekhane niche eta korchi : Entity theke get kore DTO te set korchi
        studentDTO.setRollNumber(studentEntity.getRollNumber());
        studentDTO.setFirstName(studentEntity.getFirstName());
        studentDTO.setLastName(studentEntity.getLastName());
        studentDTO.setClassName(studentEntity.getClassName());
        studentDTO.setMobileNumber(studentEntity.getMobileNumber());
        studentDTO.setEmailAddress(studentEntity.getEmailAddress());
        studentDTO.setAddressDetails(studentEntity.getAddressDetails());


        return studentDTO;
        }
       // else{
         //   return null;
       // }
   // }

    //Table fetch by Entity---------------------------------------------------------------------------------------------
    public List<StudentEntity> fetchAllStudentDat() {
        /*List<StudentEntity> allStudent=new ArrayList<>();

        allStudent= studentRepository.findAll();*/
        return studentRepository.findAll();
    }

    // Table fecth by Dto-----------------------------------------------------------------------------------------------
    public List<StudentDTO> fetchAllStudentDto() {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        List<StudentEntity> listOfStudentEntity = studentRepository.findAll();
        for (StudentEntity studentEntity : listOfStudentEntity) {
            StudentDTO studentDTO = new StudentDTO();

            studentDTO.setRollNumber(studentEntity.getRollNumber());
            studentDTO.setFirstName(studentEntity.getFirstName());
            studentDTO.setLastName(studentEntity.getLastName());
            studentDTO.setClassName(studentEntity.getClassName());
            studentDTO.setMobileNumber(studentEntity.getMobileNumber());
            studentDTO.setEmailAddress(studentEntity.getEmailAddress());
            studentDTO.setAddressDetails(studentEntity.getAddressDetails());


            studentDTOList.add(studentDTO);

        }
        return studentDTOList;
    }

    //data save by Entity------------------------------------------------------------------------------------------------
    public String saveStudentData(StudentEntity studentEntityFromBody) {
        Optional<StudentEntity> studentEntityOptionalFromDB = studentRepository.findById(studentEntityFromBody.getRollNumber());

        StudentEntity studentEntityFromDB = studentEntityOptionalFromDB.isPresent() ? studentEntityOptionalFromDB.get() : null;

        if (null != studentEntityFromDB && !studentEntityFromDB.getMobileNumber().equalsIgnoreCase(studentEntityFromDB.getMobileNumber())) {
            studentRepository.save(studentEntityFromBody);
            return "Data successfully saved.";
        } else {
            return "Student data is already exist in DB";
        }
    }

    //data save by Entity [OPTIONAL]------------------------------------------------------------------------------------------------
    public EmployeeSaveResponse saveStudentDataOptional(StudentEntity studentEntityFromBody) throws Exception, StudentException {
//        Optional<StudentEntity> studentEntityOptionalFromDB = studentRepository.findById(studentEntityFromBody.getRollNumber());

//        StudentEntity studentEntityFromDB = studentEntityOptionalFromDB.isPresent() ? studentEntityOptionalFromDB.get() : null;
//        StudentEntity studentEntityFromDB = studentEntityOptionalFromDB.get();
        //with getter and setter
        /*
         EmployeeSaveResponse employeeSaveResponse = new EmployeeSaveResponse();
        if (null != studentEntityFromDB && !studentEntityFromDB.getMobileNumber().equalsIgnoreCase(studentEntityFromDB.getMobileNumber())) {
            studentRepository.save(studentEntityFromBody);
            employeeSaveResponse.setMessage("Data successfully saved.");
            employeeSaveResponse.setStatus("Success.");
            return employeeSaveResponse;
        } else {
            employeeSaveResponse.setMessage("Student data is already exist in DB");
            employeeSaveResponse.setStatus("Failed.");
            return employeeSaveResponse;
        }*/

        //with builder

        try{
            Optional<StudentEntity> studentEntityOptionalFromDB = studentRepository.findById(studentEntityFromBody.getRollNumber());
            StudentEntity studentEntityFromDB = studentEntityOptionalFromDB.isPresent() ? studentEntityOptionalFromDB.get() : null;
            if (null != studentEntityFromDB && !studentEntityFromDB.getMobileNumber().equalsIgnoreCase(studentEntityFromDB.getMobileNumber())) {
                studentRepository.save(studentEntityFromBody);
           /* EmployeeSaveResponse employeeSaveResponse = EmployeeSaveResponse.builder()
                    .status("Success")
                    .message("Data successfully saved")
                    .build();
             return employeeSaveResponse;
                    */
                return EmployeeSaveResponse.builder()
                        .status("Success")
                        .message("Data successfully saved")
                        .build();

            } else {
                return EmployeeSaveResponse.builder()
                        .status("Failed")
                        .message("Student data is already exist in DB")
                        .build();
            }
        } catch (Exception exception){
            throw new StudentException(exception.getMessage());
        }

    }

    // data save by Dto--------------------------------------------------------------------------------------------------
    public String saveStudentData(StudentDTO studentDtoFromBody) {
        Optional<StudentEntity> studentEntityOptionalFromDB = studentRepository.findById(studentDtoFromBody.getRollNumber());
        StudentEntity studentEntityFromDB = studentEntityOptionalFromDB.isPresent() ? studentEntityOptionalFromDB.get() : null;
        //check if student already exist or not

        //if not exist
        if (null == studentEntityFromDB) {
            //map studentDtoFromBody to StudentEntity type. Karon studentRepository  eta only StudentEntity er jonne kaj kore.. Ami jodi StudentEntity studentRepository etar vetore jai tahole dekhbo StudentEntity lekha ache.
            StudentEntity studentEntityForDbSave = new StudentEntity();
            studentEntityForDbSave.setRollNumber(studentDtoFromBody.getRollNumber());
            studentEntityForDbSave.setFirstName(studentDtoFromBody.getFirstName());
            studentEntityForDbSave.setLastName(studentDtoFromBody.getLastName());
            studentEntityForDbSave.setClassName(studentDtoFromBody.getClassName());
           studentEntityForDbSave.setEmailAddress(studentDtoFromBody.getEmailAddress());
            studentEntityForDbSave.setMobileNumber(studentDtoFromBody.getMobileNumber());
            studentEntityForDbSave.setAddressDetails(studentDtoFromBody.getAddressDetails());

            studentRepository.save(studentEntityForDbSave);
            return "Data is saved";
        } else {
            return "Alreadyt exist";
        }

        // return null;
    }

    //delete data------------------------------------------------------------------------------------------------------

    public String deleteDataFromDb(Long rollNumber) {

        if (studentRepository.existsById(rollNumber)) {
            studentRepository.deleteById(rollNumber);
            return "data is deleted from this table";
        } else {
            return "data is not found in this table";
        }
    }

    //update data--by link-----------------------------------------------------------------------------------------------------
    public String updateData(Long rollNumber, String newFristName, String newLastName) {

        Optional<StudentEntity> studentEntityOptionalFromDB = studentRepository.findById(rollNumber);
        // StudentEntity studentEntityFromDB = studentEntityOptionalFromDB.isPresent() ? studentEntityOptionalFromDB.get(): null;


        if (studentEntityOptionalFromDB.isPresent()) {

            StudentEntity studentEntityFromDB = studentEntityOptionalFromDB.get();
            studentEntityFromDB.setFirstName(newFristName);
            studentEntityFromDB.setLastName(newLastName);


            studentRepository.save(studentEntityFromDB);

            return "Data is updated";

        } else {
            return "date is not updated";
        }

    }

    //  -----------------------------------------------------------------------------------------------------------------
    //update data by Dto ---------------------------------------------------------------------------------------------------------------
    public String updateDataByBody(StudentDTO StudentDTOPay) {

        Optional<StudentEntity> studentEntityOptionalFromDB = studentRepository.findById(StudentDTOPay.getRollNumber());
        //  StudentEntity studentEntityFromDB = studentEntityOptionalFromDB.isPresent() ? studentEntityOptionalFromDB.get() : null;

        if (studentEntityOptionalFromDB.isPresent()) {


            StudentEntity studentEntityFromDB = studentEntityOptionalFromDB.get();

            studentEntityFromDB.setRollNumber(StudentDTOPay.getRollNumber());
            studentEntityFromDB.setFirstName(StudentDTOPay.getFirstName());
            studentEntityFromDB.setLastName(StudentDTOPay.getLastName());
            studentEntityFromDB.setMobileNumber(StudentDTOPay.getMobileNumber());
            studentEntityFromDB.setEmailAddress(StudentDTOPay.getEmailAddress());
            studentEntityFromDB.setAddressDetails(StudentDTOPay.getAddressDetails());


            studentRepository.save(studentEntityFromDB);

            return "Data is Updataed";
        } else {
            return " Student is not present";
        }


    }

    //-Save data in student marks table---------------------------------------------------------------------------------------------------------------------

    public String studentMarksEntity(StudentMarksEntity StudentMarksEntitys) {

        Optional<StudentMarksEntity> studentEntityOptionalFromDB = StudentMarksRepository.findById(StudentMarksEntitys.getRollNumber());
        // StudentMarksEntity StudentMarksEntity = studentEntityOptionalFromDB.isPresent() ? studentEntityOptionalFromDB.get() : null;

        if (studentEntityOptionalFromDB.isEmpty()) {

            StudentMarksEntity ss = new StudentMarksEntity();
            ss.setRollNumber(StudentMarksEntitys.getRollNumber());
            ss.setMadhyamicMarks(StudentMarksEntitys.getMadhyamicMarks());
            ss.setHsMarks(StudentMarksEntitys.getHsMarks());

            StudentMarksRepository.save(ss); //   studentRepository.save(StudentMarksEntitys);
            return "data is saveed";
        } else {
            return "Data olreday present";
        }
    }


//--fech data from both table-------------------------------------------------------------------------------------------------------

        public StudentDTO fechAllDataFromBothTable (Long rollNumber) {


                StudentDTO StudentDTO = new StudentDTO();

                Optional<StudentEntity> studentEntityOptional = studentRepository.findById(rollNumber);
                Optional<StudentMarksEntity> studentEntityOptionalFromDB = StudentMarksRepository.findById(rollNumber);

                if (studentEntityOptional.isEmpty()) {
                    return null;
                }

                StudentEntity StudentEntityData = studentEntityOptional.get();
                StudentMarksEntity StudentMarksEntityData = studentEntityOptionalFromDB.get();

                StudentDTO.setRollNumber(StudentEntityData.getRollNumber());
                StudentDTO.setFirstName(StudentEntityData.getFirstName());
                StudentDTO.setLastName(StudentEntityData.getLastName());
              //  StudentDTO.setClassName(StudentEntityData.getClassName());
                StudentDTO.setMobileNumber(StudentEntityData.getMobileNumber());
             //   StudentDTO.setEmailAddress(StudentEntityData.getEmailAddress());
              //  StudentDTO.setAddressDetails(StudentEntityData.getAddressDetails());

                if (StudentMarksEntityData != null) {

                    StudentDTO.setMadhyamicMarks(StudentMarksEntityData.getMadhyamicMarks());
                    StudentDTO.setHsMarks(StudentMarksEntityData.getHsMarks());
                }

                return StudentDTO;
            }



//----------------------------------------------------------------------------------------------------------------------------------------

}









