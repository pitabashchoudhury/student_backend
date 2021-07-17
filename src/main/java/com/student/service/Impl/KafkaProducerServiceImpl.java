package com.student.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.student.dto.KafkaData;
import com.student.dto.StudentDetailDTO;
import com.student.dto.StudentDetailsResponseDTO;
import com.student.dto.UserDTO;
import com.student.entity.StudentDetails;
import com.student.entity.converter.StudentDetailsConverter;
import com.student.repository.StudentDetailRepository;
import com.student.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class KafkaProducerServiceImpl implements KafkaProducerService {


    @Autowired
    private StudentDetailRepository studentDetailRepository;

    @Autowired
    private KafkaTemplate<String, String> template;

   /* @Autowired
    private KafkaTemplate<String, String> templates;*/
   @Autowired
   private Gson gson;

    private String topic = "bubu1";

    @Override
    public void publishMessage(StudentDetailDTO dto){






KafkaData kafkaData=new KafkaData(dto);


        template.send(topic,gson.toJson(kafkaData));

    }

}
