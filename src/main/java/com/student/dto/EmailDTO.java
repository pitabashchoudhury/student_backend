package com.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO implements Serializable {
    @Email(message = "{registration.validation.email}")
    private String email;

    @NotEmpty(message = "{registration.validation.password}")
    private String password;


}
