package com.fonyou.evaluator;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.fonyou.evaluator.evaluator"})
public class EvaluatorApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(EvaluatorApplication.class, args);
	}
	
}
