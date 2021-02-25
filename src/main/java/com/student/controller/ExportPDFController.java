package com.student.controller;

import com.lowagie.text.DocumentException;
import com.student.StudentPDFExporter;
import com.student.dto.StudentDetailDTO;
import com.student.entity.StudentDetails;
import com.student.service.StudentDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/exportPDF")
@Validated
@Slf4j
@Component
public class ExportPDFController {
    @Autowired
    private StudentDetailService studentDetailService;

    @GetMapping("/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=student_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<StudentDetailDTO> studentDetailDTOS = studentDetailService.getStudent();

        StudentPDFExporter exporter = new StudentPDFExporter(studentDetailDTOS);
        exporter.export(response);

    }
}
