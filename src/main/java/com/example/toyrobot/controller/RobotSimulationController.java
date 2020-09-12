package com.example.toyrobot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.toyrobot.model.Report;
import com.example.toyrobot.model.RobotSimulation;
import com.example.toyrobot.service.RobotSimulationService;

/**
 * Controller to handle request for robot simulation 
 */
@Controller
public class RobotSimulationController {

	@Autowired
	private RobotSimulationService robotSimulationService;

	/**
	 * @param robotSimulation list of simulation commands
	 * @return {@link Report}
	 */
	public Report simulate(RobotSimulation robotSimulation) {
		return robotSimulationService.simulate(robotSimulation);

	}

}
