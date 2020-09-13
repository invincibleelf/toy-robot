package com.example.toyrobot.model.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.toyrobot.model.CardinalDirection;
import com.example.toyrobot.model.Report;
import com.example.toyrobot.model.Robot;

public class PlaceCommand extends BaseCommand {
	
	public final Logger logger = LoggerFactory.getLogger(PlaceCommand.class);
	
	private String commandString;
	
	public PlaceCommand(String commandString) {
		this.commandString = commandString;
	}

	@Override
	public void execute(Robot robot, Report report) {
		int start = commandString.indexOf(CommandType.PLACE.name()) + CommandType.PLACE.name().length();
		String argsPlace = commandString.substring(start, commandString.length());
		
		// Split command string to get arrays of place command parameters
		String[] args = argsPlace.split(",");
		
		Integer xPosition = Integer.parseInt(args[0].trim());
		Integer yPosition = Integer.parseInt(args[1].trim());
		
		// Check if Robot position is at edges of the grid and if true, ignore the move command	
		if (xPosition <= Robot.MAX_POSITION && xPosition >= Robot.MIN_POSITION
                && yPosition <= Robot.MAX_POSITION && yPosition >= Robot.MIN_POSITION) {
			robot.setxPosition(xPosition);
			robot.setyPosition(yPosition);
			robot.setCardinalDirection(CardinalDirection.valueOf(args[2].trim()));
			logger.info("Robot has been placed at " + robot.getCurrentStatus() );
			
		}else {
			logger.info("Place command ignored");
		}
		
	}

}
