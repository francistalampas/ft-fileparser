package com.ft.fileparser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FileParserApp implements CommandLineRunner {

	@Autowired
	FileParser fileParser;

	public static void main(String[] args) {
		SpringApplication.run(FileParserApp.class, args);
	}

	@Override
	public void run(String... args) throws IOException, InterruptedException {
		fileParser.parseFiles(args[0]);
//		fileParser.parseFilesMonitorMode(args[0]);
	}
}
