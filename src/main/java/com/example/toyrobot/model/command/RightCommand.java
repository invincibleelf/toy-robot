package com.example.toyrobot.model.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.toyrobot.model.CardinalDirection;
import com.example.toyrobot.model.Report;
import com.example.toyrobot.model.Robot;

public class RightCommand extends BaseCommand {

	private final Logger logger = LoggerFactory.getLogger(RightCommand.class);

	@Override
	public void execute(Robot robot, Report report) {
		// Check if is placed on the table. If not, ignore the command
		if (!robot.isOnTable()) {
			logger.info("Ignore move command");
		} else {
			logger.info("Rotating robot right");
			switch (robot.getCardinalDirection()) {
			case EAST:
				robot.setCardinalDirection(CardinalDirection.SOUTH);
				break;
			case NORTH:
				robot.setCardinalDirection(CardinalDirection.EAST);
				break;
			case SOUTH:
				robot.setCardinalDirection(CardinalDirection.WEST);
				break;
			case WEST:
				robot.setCardinalDirection(CardinalDirection.NORTH);
				break;
			default:
				break;

			}
		}

	}

}
