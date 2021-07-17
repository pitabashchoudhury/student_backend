package com.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.student.dto.StudentDetailsResponseDTO;
import com.student.dto.UserDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;



@Service
public class KafkaService {




   /* @KafkaListener(topics = "bubu", groupId = "group_id",containerFactory = "kafkaListenerContainerFactory")
    public void consume(String sai) {
        System.out.println("yessss->" + sai);
    }*/
   @Autowired
   private Gson gson;
    @KafkaListener(topics =  "bubu1",groupId = "group")
    public void getTopics(@RequestBody String emp) {
        System.out.println("Kafka event consumed is: " + emp);
        UserDTO model = gson.fromJson(emp, UserDTO.class);
        System.out.println("Model converted value: " + model.toString());
    }
}
