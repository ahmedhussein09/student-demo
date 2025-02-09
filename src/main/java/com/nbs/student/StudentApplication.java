package com.nbs.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.net.URI;


@SpringBootApplication
public class StudentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Override
	public void run(String... args) {
		String swaggerUrl = "http://localhost:8080/api/swagger-ui/index.html";
		openSwaggerUiInBrowser(swaggerUrl);
	}

	private void openSwaggerUiInBrowser(String url) {
		try {
			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().browse(new URI(url));
			} else {
				// Fallback for Linux headless environments
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
