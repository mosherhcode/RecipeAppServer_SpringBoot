package com.mosherhcode.RecipeAppServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class})
public class RecipeAppServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeAppServerApplication.class, args);
	}

}
