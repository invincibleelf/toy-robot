package com.example.toyrobot.model.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.toyrobot.model.CardinalDirection;
import com.example.toyrobot.model.Report;
import com.example.toyrobot.model.Robot;

public class LeftCommand extends BaseCommand {

	private final Logger logger = LoggerFactory.getLogger(LeftCommand.class);

	@Override
	public void execute(Robot robot, Report report) {
		// Check if is placed on the table. If not, ignore the command
		if (!robot.isOnTable()) {
			logger.info("Ignore move command");
		}else {
			logger.info("Rotating robot left");
			switch(robot.getCardinalDirection()) {
			case EAST:
				robot.setCardinalDirection(CardinalDirection.NORTH);
				break;
			case NORTH:
				robot.setCardinalDirection(CardinalDirection.WEST);
				break;
			case SOUTH:
				robot.setCardinalDirection(CardinalDirection.EAST);
				break;
			case WEST:
				robot.setCardinalDirection(CardinalDirection.SOUTH);
				break;
			default:
				break;
			
			}
		}

	}

}
