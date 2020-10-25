package com.rga.springwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringWebAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringWebAppApplication.class, args);
	}
}
