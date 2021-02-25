package com.student.service.Impl;

import com.student.dto.StudentDetailDTO;
import com.student.entity.StudentDetails;
import com.student.entity.converter.StudentDetailsConverter;
import com.student.repository.StudentDetailRepository;
import com.student.service.StudentDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class StudentDetailServiceImpl implements StudentDetailService {

    @Autowired
    private StudentDetailRepository studentDetailRepository;


    @Override
    public String createUser(StudentDetailDTO dto){

        StudentDetails studentDetails= new StudentDetails();



        //log.info("Creating User");
        StudentDetailsConverter.getStudentDetailsEntityFromDto(dto,studentDetails);
        studentDetails.setStudentId(UUID.randomUUID().toString());

       // studentDetails.setPassword(EncryptionUtils.encrypt(dto.getPassword()));
        studentDetails.setCreatedAt(new Date());
        studentDetails.setUpdatedAt(new Date());
        studentDetailRepository.save(studentDetails);
        return studentDetails.getStudentId();


    }


    @Override
    public List<StudentDetailDTO> getStudent(){

        List<StudentDetails> studentDetails = studentDetailRepository.findAll();
        return StudentDetailsConverter.getListStudentDetailsDtoFromEntityList(studentDetails);


    }
}
