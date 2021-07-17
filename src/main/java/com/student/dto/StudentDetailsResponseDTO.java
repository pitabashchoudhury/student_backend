package com.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetailsResponseDTO {



    private String fullName;

    private String email;

    private String phoneNo;

    public StudentDetailsResponseDTO(StudentDetailDTO dto) {
        this.fullName=dto.getFullName();
        this.email=dto.getEmail();
        this.phoneNo=dto.getPhoneNo();

    }




    @Override
    public String toString() {
        return "StudentDetailsResponseDTO{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
