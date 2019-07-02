package com.hgh.spidernewcode;

import com.hgh.spidernewcode.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class SpidernewcodeApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpidernewcodeApplication.class, args);
	}


}
