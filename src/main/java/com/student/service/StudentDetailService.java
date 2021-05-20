package com.student.service;

import com.student.dto.StudentDetailDTO;
import com.student.dto.StudentDetailsResponseDTO;

import java.util.List;

public interface StudentDetailService {

    public String createUser(StudentDetailDTO dto);

    public List<StudentDetailsResponseDTO>getStudent();

    public String signIn(String email, String password);

    public List<String> getName(String name);
}
