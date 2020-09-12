package com.example.toyrobot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.toyrobot.model.Report;
import com.example.toyrobot.model.Robot;
import com.example.toyrobot.model.RobotSimulation;


@Service
public class RobotSimulationService {

	private final static Logger logger = LoggerFactory.getLogger(RobotSimulationService.class);

	/** Method to handle robot simulation logic
	 * @param robotSimulation list of simulation commands
	 * @return {@link Report}
	 */
	public Report simulate(RobotSimulation robotSimulation) {

		for (String commandString : robotSimulation.getCommands()) {
			logger.info(commandString);
		}

		return new Report("Test");
	}
}
