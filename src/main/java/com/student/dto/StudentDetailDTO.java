package com.student.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentDetailDTO {

   private String fullName;

   private String email;

   private String phoneNo;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String password;

}
