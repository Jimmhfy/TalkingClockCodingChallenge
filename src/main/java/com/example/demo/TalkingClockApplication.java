package com.example.demo;

import com.example.demo.Model.Clock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.util.Scanner;

@SpringBootApplication
public class TalkingClockApplication {
	private static final String CURRENT_TIME_OPTION = "1";
	private static final String USER_INPUT_OPTION = "2";
	private static final String REST_API_OPTION = "3";
	private static final String QUIT_OPTION = "q";
	private static Scanner scanner;

	public static void main(String[] args){
		System.out.println("Welcome to Talking Clock");
		scanner = new Scanner(System.in);
		Clock clock;
		while(true){
			String option = showObjectiveOptionCommand();
			switch (option){
				case CURRENT_TIME_OPTION:
					LocalDateTime timeNow = LocalDateTime.now();
					clock = new Clock(timeNow);
					System.out.println(clock);
					break;
				case USER_INPUT_OPTION:
					String inputCommand;
					System.out.println("Please input time, e.g 15:30");
					System.out.println("Input e to return to main menu");
					do {
						inputCommand = scanner.nextLine();
						if(Clock.validate(inputCommand)) {
							clock = new Clock(inputCommand);
							System.out.println(clock);
						}
						else
							System.out.println("Invalid input");
					} while(!inputCommand.equals("e"));
					break;
				case REST_API_OPTION:
					ConfigurableApplicationContext springApplication = SpringApplication.run(TalkingClockApplication.class, args);
					String restCommand = "";
					while(restCommand.isEmpty()) {
						System.out.println("-----------------------------------------------------------");
						System.out.println("GET Method from: http://localhost:8080/getTime?time=<time>");
						System.out.println("e.g. http://localhost:8080/getTime?time=12:30");
						System.out.println("No request body needed");
						System.out.println("OR");
						System.out.println("GET Method from: http://localhost:8080/getTimeWithBody");
						System.out.println("Example of resquest: 12:30");
						System.out.println("Input any key to return to main menu");
						restCommand = scanner.nextLine();
					}
					springApplication.close();
					break;
				case QUIT_OPTION:
					return;
			}
		}
	}

	public static String showObjectiveOptionCommand(){
		System.out.println("\nPlease select 1-3 option. To exit, input q");
		System.out.println("-----------------------------------------------------------");
		System.out.println("Objective 1: Print out current time");
		System.out.println("Objective 2: Covert time by user input");
		System.out.println("Objective 3: Start Spring and get convert time by Restful API");
		System.out.println("-----------------------------------------------------------");
		String userInput = scanner.nextLine();
		return userInput;
	}
}
