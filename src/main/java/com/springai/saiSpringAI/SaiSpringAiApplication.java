package com.springai.saiSpringAI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaiSpringAiApplication {

	public static void main(String[] args) {


		System.out.println("click on edit configurations and create a environment variable with the name OPENAI_API_KEY" +
				"add the value form open ai "
		);


	SpringApplication.run(SaiSpringAiApplication.class, args);
	}

}
