package com.student.dto;


public class UserDTO {

     String name;

     String emailid;

     String mobile;

    public UserDTO(String name, String emailid, String mobileNo) {
        name = name;
        this.emailid = emailid;
        this.mobile = mobileNo;
    }

    public UserDTO(){

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

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", emailid='" + emailid + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
