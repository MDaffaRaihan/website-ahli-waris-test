package com.infinatum.web_ahli_waris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class WebAhliWarisApplication {

	public static void main(String[] args) throws IOException {
		Path uploadPath = Paths.get("uploads");
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
			System.out.println("Folder 'uploads' dibuat otomatis ✅");
		}

		SpringApplication.run(WebAhliWarisApplication.class, args);
	}

}
