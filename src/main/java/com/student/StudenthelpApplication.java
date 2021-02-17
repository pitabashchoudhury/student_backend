package com.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableScheduling
@EnableTransactionManagement
public class StudenthelpApplication {

		public static void main(String[] args) {


			System.out.println("Wel Come");
			SpringApplication.run(StudenthelpApplication.class, args);



	}


}
