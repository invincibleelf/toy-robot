package com.example.toyrobot;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.toyrobot.controller.RobotSimulationController;
import com.example.toyrobot.model.Report;
import com.example.toyrobot.model.RobotSimulation;

@SpringBootApplication
public class ToyRobotApplication implements CommandLineRunner{
	
	private final static Logger logger = LoggerFactory.getLogger(ToyRobotApplication.class);
	
	@Autowired
	private RobotSimulationController robotSimulationController;

	public static void main(String[] args) {
		SpringApplication.run(ToyRobotApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Enter Command");
		Scanner scanner = new Scanner(System.in);
		RobotSimulation robotSimulation = new RobotSimulation();

		// Get scanner input and copy each scanner input line to array of simulation commands		
		while (scanner.hasNextLine()) {

			String command = scanner.nextLine();
			if (command.isEmpty()) {
				break;
			}
			robotSimulation.addCommand(command);
		}
		scanner.close();
		
		Report report = robotSimulationController.simulate(robotSimulation);

		logger.info("Robot Position is " + report.getOutput());
		
	}

}
