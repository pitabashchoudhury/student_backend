package com.student.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentDetailsResponseDTO {

    private String fullName;

    private String email;

    private String phoneNo;
}
