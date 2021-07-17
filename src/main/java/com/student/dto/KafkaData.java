package com.student.dto;

public class KafkaData {

    String name;
    String emailid;
    String mobile;



    public KafkaData(){

    }

    public KafkaData(StudentDetailDTO dto) {
        this.name=dto.getFullName();
        this.emailid=dto.getEmail();
        this.mobile=dto.getPhoneNo();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
