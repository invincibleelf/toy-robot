package com.example.toyrobot.model.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.toyrobot.model.Report;
import com.example.toyrobot.model.Robot;

public class ReportCommand extends BaseCommand{
	
	public final Logger logger = LoggerFactory.getLogger(ReportCommand.class);

	@Override
	public void execute(Robot robot, Report report) {
		
		// Check if is placed on the table. If not, ignore the command
		if(!robot.isOnTable()) {
			logger.info("Ignore report command");
		}else {
			report.setOutput(robot.getCurrentStatus());
		}
		
	}

}
