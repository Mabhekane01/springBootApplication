package com.assessment.grad001.bheki.ngwenya.restful;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("com.assessment.grad001.bheki.ngwenya.restful.models")
@EnableJpaRepositories("com.assessment.grad001.bheki.ngwenya.restful.repositories")
@ComponentScan(basePackages = "com.assessment.grad001.bheki.ngwenya.restful")
@SpringBootApplication(scanBasePackages = {"com.assessment.grad001.bheki.ngwenya.controller"})
public class RestfulApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestfulApplication.class, args);
		System.out.println("nnn");
	}

}
