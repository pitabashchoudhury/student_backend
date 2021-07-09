package com.student.service;

import com.student.dto.EmailDTO;
import com.student.dto.StudentDetailDTO;
import com.student.dto.StudentDetailsResponseDTO;

import javax.mail.MessagingException;
import java.util.List;

public interface StudentDetailService {

    public String createUser(StudentDetailDTO dto) throws MessagingException;

    public List<StudentDetailsResponseDTO>getStudent();

    public String signIn(String email, String password);
    public String logIn(EmailDTO dto);

    public List<String> getName(String name);
}
