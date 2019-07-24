package com.mindtree.configserverapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@EnableConfigServer
@SpringBootApplication
public class ConfigserverappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigserverappApplication.class, args);
	}

}
