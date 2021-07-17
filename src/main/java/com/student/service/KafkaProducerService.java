package com.student.service;

import com.student.dto.StudentDetailDTO;
import org.omg.CORBA.UserException;

public interface KafkaProducerService {


    public void publishMessage(StudentDetailDTO dto) throws UserException;
}
