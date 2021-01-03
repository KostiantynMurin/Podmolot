package com.a.k.podmolot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class PodmolotApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PodmolotApplication.class, args).registerShutdownHook();
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PodmolotApplication.class);
	}

}
