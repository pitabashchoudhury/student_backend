package com.student.controller;


import com.student.dto.StudentDetailDTO;
import com.student.service.StudentDetailService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/studentUser")
@Validated
@Slf4j
@Component
public class StudentController {

    @Autowired
    private StudentDetailService studentDetailService;



    @ApiOperation(value = "creating student")
    @PostMapping(path = "createStudent", produces = { MediaType.APPLICATION_JSON_VALUE })
    public void createStudent(
                                        @RequestParam String name,
                                        @RequestParam String email,
                                        @RequestParam String phoneNo,
                                        @RequestParam String password)
            {
            StudentDetailDTO dto = new StudentDetailDTO();
            dto.setFullName(name);
            dto.setEmail(email);
            dto.setPhoneNo(phoneNo);
            dto.setPassword(password);


           studentDetailService.createUser(dto);

    }

    @ApiOperation(value = "fetch student")
    @PostMapping(path = "getStudent", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<StudentDetailDTO> getStudent()
    {
        return studentDetailService.getStudent();

    }







}
