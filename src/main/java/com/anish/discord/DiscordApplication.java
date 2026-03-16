package com.anish.discord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DiscordApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscordApplication.class, args);
	}

}
