package com.student.controller;


import com.student.dto.ResponseDTO;
import com.student.dto.StudentDetailDTO;
import com.student.dto.StudentDetailsResponseDTO;
import com.student.service.StudentDetailService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentDetailService studentDetailService;



    @ApiOperation(value = "creating student")
    @PostMapping(path = "createStudent", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseDTO createStudent(
                                        @RequestParam String name,
                                        @RequestParam String email,
                                        @RequestParam String phoneNo,
                                        @RequestParam String password
    )
            {
            StudentDetailDTO dto = new StudentDetailDTO();
            dto.setFullName(name);
            dto.setEmail(email);
            dto.setPhoneNo(phoneNo);
            dto.setPassword(password);


           String msg=studentDetailService.createUser(dto);

                return new ResponseDTO(HttpStatus.OK.value(),msg);
    }

    @ApiOperation(value = "fetch student")
    @GetMapping(path = "getStudent", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<StudentDetailsResponseDTO> getStudent()
    {
        return studentDetailService.getStudent();

    }


    @ApiOperation(value = "signing in")
    @PostMapping(path = "signin",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDTO signIn (@RequestParam String email,
                               @RequestParam String password)
    {
        String userId= studentDetailService.signIn(email, password);

        return new ResponseDTO(HttpStatus.OK.value(),userId);
    }



    @ApiOperation(value ="finding word")
    @PostMapping(path = "findWord",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> findWord(@RequestParam String sname)
    {
        return  studentDetailService.getName(sname);

    }








}
