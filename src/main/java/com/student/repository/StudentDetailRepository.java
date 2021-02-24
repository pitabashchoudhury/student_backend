package com.student.repository;

import com.student.entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDetailRepository extends JpaRepository<StudentDetails,String> {



    public StudentDetails findByEmail(String email);

    public StudentDetails findByPhoneNo(String phoneNo);
}
