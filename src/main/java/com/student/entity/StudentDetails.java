package com.student.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "rec_studentdetails")

public class StudentDetails extends AuditEntity {

    @Id
    @Column(name = "student_id")
    private String studentId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name="password")
    private String password;



    public StudentDetails(String studentId,String fullName,String email,String phoneNo,String password){
        this.studentId=studentId;
        this.fullName=fullName;
        this.email=email;
        this.phoneNo=phoneNo;
        this.password=password;
    }

    public StudentDetails(){

    }



}
