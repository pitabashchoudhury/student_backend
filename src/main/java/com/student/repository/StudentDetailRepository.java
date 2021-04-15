package com.student.repository;

import com.student.entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDetailRepository extends JpaRepository<StudentDetails,String> {



   // public StudentDetails findByEmail(String email);

   // public StudentDetails findByPhoneNo(String phoneNo);

    @Query(value = "SELECT student_id FROM rec_studentdetails WHERE email= :#{#email}", nativeQuery = true)
    public String findByEmail(String email);

    @Query(value = "SELECT password FROM rec_studentdetails WHERE student_id= :#{#studentId}", nativeQuery = true)
    public String findByPassword(String studentId);

    @Query(value = "SELECT full_name from rec_studentdetails  WHERE full_name LIKE %:#{#name}% order by full_name asc ",nativeQuery = true)
    public List<String> getStudentName(String name);

}
