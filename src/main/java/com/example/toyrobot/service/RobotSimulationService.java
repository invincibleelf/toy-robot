package com.example.toyrobot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.toyrobot.model.Report;
import com.example.toyrobot.model.Robot;
import com.example.toyrobot.model.RobotSimulation;
import com.example.toyrobot.model.command.BaseCommand;
import com.example.toyrobot.utils.Utils;

@Service
public class RobotSimulationService {

	private final static Logger logger = LoggerFactory.getLogger(RobotSimulationService.class);

	private Robot robot;

	private Report report;
	
	@Autowired
	public RobotSimulationService(Robot robot, Report report) {
		this.robot = robot;
		this.report = report;
	}

	/**
	 * Method to handle robot simulation logic
	 * 
	 * @param robotSimulation list of simulation commands
	 * @return {@link Report}
	 */
	public Report simulate(RobotSimulation robotSimulation) {

		for (String commandString : robotSimulation.getCommands()) {
			logger.info(commandString);
			BaseCommand command = Utils.getCommand(commandString);

			if (command != null) {
				command.execute(robot, report);
			} else {
				logger.info("Wrong Command " + commandString);
			}

		}
		return report;
	}
}
