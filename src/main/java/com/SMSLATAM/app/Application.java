package com.SMSLATAM.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spark.Spark;

@SpringBootApplication
public class Application {

	static int getHerokuAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
			return Integer.parseInt(processBuilder.environment().get("PORT"));
		}

		return 4567; // return default port if heroku-port isn't set (i.e. on localhost)
	}

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
		Spark.port(getHerokuAssignedPort());
	}

}
