package com.roncoo.eshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SayHelloServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SayHelloServiceApplication.class, args); 
	}
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/sayHello")
	public String sayHello(String name) {
		return "hello, " + name + " from port: " + port;
	}
	
}
