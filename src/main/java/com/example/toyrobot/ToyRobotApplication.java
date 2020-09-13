package com.example.toyrobot;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import com.example.toyrobot.model.Report;
import com.example.toyrobot.model.RobotSimulation;
import com.example.toyrobot.service.RobotSimulationService;

@SpringBootApplication
@Profile("!test")
public class ToyRobotApplication implements CommandLineRunner{
	
	private final static Logger logger = LoggerFactory.getLogger(ToyRobotApplication.class);
	
	@Autowired
	private RobotSimulationService robotSimulationController;

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

		logger.info("Robot Final Position is " + report.getOutput());
		System.out.println("Robot Final Position is " + report.getOutput());
		
	}

}
