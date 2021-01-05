package com.arolla.bankmgm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BankmgmApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankmgmApplication.class, args);
	}

}
