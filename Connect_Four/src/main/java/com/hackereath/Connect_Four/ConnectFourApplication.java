package com.hackereath.Connect_Four;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@SpringBootApplication
public class ConnectFourApplication {

	public static Logger gameLog = Logger.getLogger("My Log");

	public static void main(String[] args) {

		FileHandler fileHandler;

		try
		{
			fileHandler = new FileHandler("C:\\Users\\Dhirendra\\Desktop\\Packages\\Hackerearth\\Connect_Four\\log\\Log1.log");
			gameLog.addHandler(fileHandler);
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			gameLog.setUseParentHandlers(false);
			gameLog.info("Working **");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SpringApplication.run(ConnectFourApplication.class, args);
	}

}
