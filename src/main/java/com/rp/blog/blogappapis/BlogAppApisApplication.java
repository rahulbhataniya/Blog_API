package com.rp.blog.blogappapis;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogAppApisApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
		System.out.println("project is working fine");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
