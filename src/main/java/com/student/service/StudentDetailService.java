package com.student.service;

import com.student.dto.StudentDetailDTO;
import java.util.List;

public interface StudentDetailService {

    public String createUser(StudentDetailDTO dto);

    public List<StudentDetailDTO>getStudent();
}
