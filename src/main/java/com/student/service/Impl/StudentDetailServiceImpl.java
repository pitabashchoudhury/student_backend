package com.student.service.Impl;

import com.student.Emailservice;
import com.student.Util.EncryptionUtils;
import com.student.Util.ErrorMessage;
import com.student.Util.SuccessMessage;
import com.student.dto.EmailDTO;
import com.student.dto.StudentDetailDTO;
import com.student.dto.StudentDetailsResponseDTO;
import com.student.entity.StudentDetails;
import com.student.entity.converter.StudentDetailsConverter;
import com.student.repository.StudentDetailRepository;
import com.student.service.StudentDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class StudentDetailServiceImpl implements StudentDetailService {

    @Autowired
    private StudentDetailRepository studentDetailRepository;

    @Autowired
    private Emailservice emailservice;


    @Override
    public String createUser(StudentDetailDTO dto) throws MessagingException {

        StudentDetails studentDetails= new StudentDetails();



        //log.info("Creating User");
       // StudentDetailsConverter.getStudentDetailsEntityFromDto(dto,studentDetails);
        BeanUtils.copyProperties(dto,studentDetails);
        studentDetails.setStudentId(UUID.randomUUID().toString());

        studentDetails.setPassword(EncryptionUtils.encrypt(dto.getPassword()));
        studentDetails.setCreatedAt(new Date());
        studentDetails.setUpdatedAt(new Date());
        studentDetailRepository.save(studentDetails);
         String s=emailservice.sendMail(dto.getEmail(),"testing","wel come to spring backend");

             return SuccessMessage.STUDENT_REGISTERED ;


    }


    @Override
    public List<StudentDetailsResponseDTO> getStudent(){

        List<StudentDetails> studentDetails = studentDetailRepository.findAll();
        return StudentDetailsConverter.getListStudentDetailsDtoFromEntityList(studentDetails);



    }






    @Override
    public String signIn(String email, String password){
        String y;
        String studentId=studentDetailRepository.findByEmail(email);
        if(studentId!=null)

            return y=checkPassword(studentId,password);

        else {
            return ErrorMessage.CHECK_YOUR_MAIL;

        }




    }

    ////////////////////////////////////////////////////

    @Override
    public String logIn(EmailDTO dto){
        String y;
        String studentId=studentDetailRepository.findByEmail(dto.getEmail());
        if(studentId!=null)

            return y=checkPassword(studentId,dto.getPassword());

        else {
            return ErrorMessage.CHECK_YOUR_MAIL;

        }




    }

    String checkPassword(String studentId,String password){
        System.out.println("entry by id"+studentId);
        String pass = studentDetailRepository.findByPassword(studentId);

        System.out.println("entry by password "+password);
        String p= EncryptionUtils.decrypt(pass);
        System.out.println("entry by pass "+p);
        if (p.equals(password))
        {

            return studentId;
        }
        else {
            return ErrorMessage.PASSWORD_CHECK;
        }

    }

    @Override
    public List<String> getName(String name){

        List<String> studentDetails = studentDetailRepository.getStudentName(name);

        //StudentDetailsConverter.getListStudentDetailsDtoFromEntityList(studentDetails);
        System.out.println(studentDetails);
        //return studentDetails.getFullName();
        return studentDetails;

    }
}
