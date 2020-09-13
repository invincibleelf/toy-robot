package com.example.toyrobot.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.toyrobot.model.Report;
import com.example.toyrobot.model.Robot;
import com.example.toyrobot.model.RobotSimulation;

@RunWith(SpringRunner.class)

@ActiveProfiles("test")
public class RobotSimulationServiceTest {

	@Test
	public void missingRobotTest() {
		Report report = new Report();

		RobotSimulation robotSimulation = new RobotSimulation();
		robotSimulation.addCommand("MOVE");
		robotSimulation.addCommand("REPORT");
		RobotSimulationService service = new RobotSimulationService(new Robot(), report);

		Assert.assertEquals(service.simulate(robotSimulation), report);

	}

	@Test
	public void robotSimulationReportTest() {
		Report report = new Report();
		RobotSimulation robotSimulation = new RobotSimulation();

		report.setOutput("0,1,NORTH");
		robotSimulation.addCommand("PLACE 0,0,NORTH");
		robotSimulation.addCommand("MOVE");
		robotSimulation.addCommand("REPORT");

		RobotSimulationService service = new RobotSimulationService(new Robot(), new Report());

		Assert.assertEquals(service.simulate(robotSimulation).getOutput(), report.getOutput());

		report.setOutput("0,0,WEST");

		robotSimulation = new RobotSimulation();
		robotSimulation.addCommand("PLACE 0,0,NORTH");
		robotSimulation.addCommand("LEFT");
		robotSimulation.addCommand("REPORT");

		service = new RobotSimulationService(new Robot(), new Report());

		Assert.assertEquals(service.simulate(robotSimulation).getOutput(), report.getOutput());

		report.setOutput("3,3,NORTH");

		robotSimulation = new RobotSimulation();
		robotSimulation.addCommand("PLACE 1,2,EAST");
		robotSimulation.addCommand("MOVE");
		robotSimulation.addCommand("MOVE");
		robotSimulation.addCommand("LEFT");
		robotSimulation.addCommand("MOVE");
		robotSimulation.addCommand("REPORT");

		service = new RobotSimulationService(new Robot(), new Report());

		Assert.assertEquals(service.simulate(robotSimulation).getOutput(), report.getOutput());

	}
	
	@Test
	public void wrongCommandIgnoreTest() {
		Report report = new Report();
		RobotSimulation robotSimulation = new RobotSimulation();
		
		report.setOutput("0,0,NORTH");
		robotSimulation.addCommand("PLACE 0,0,NORTH");
		robotSimulation.addCommand("MOVEEE");
		robotSimulation.addCommand("LEFTT");
		robotSimulation.addCommand("REPORT");
		
		RobotSimulationService service = new RobotSimulationService(new Robot(), new Report());
		Assert.assertEquals(service.simulate(robotSimulation).getOutput(), report.getOutput());
	}

}
