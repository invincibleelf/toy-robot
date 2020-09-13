package com.example.toyrobot.model.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.toyrobot.model.Report;
import com.example.toyrobot.model.Robot;

public class MoveCommand extends BaseCommand {

	public final Logger logger = LoggerFactory.getLogger(MoveCommand.class);

	@Override
	public void execute(Robot robot, Report report) {
		// Check if is placed on the table. If not, ignore the command
		if (!robot.isOnTable()) {
			logger.info("Ignore move command");
		} else {
			switch (robot.getCardinalDirection()) {
			case EAST:
				if (robot.getxPosition() < Robot.MAX_POSITION) {
					robot.increaseXPosition();
					logger.info("The robot is moving "+ robot.getCardinalDirection());
				} else {
					logger.info("Move command ignored");
				}
				break;
			case NORTH:
				if (robot.getyPosition() < Robot.MAX_POSITION) {
					robot.increaseYPosition();
					logger.info("The robot is moving "+ robot.getCardinalDirection());
				} else {
					logger.info("Move command ignored");
				}
				break;
			case SOUTH:
				if (robot.getyPosition() > Robot.MIN_POSITION) {
					robot.decreaseYPosition();
					logger.info("The robot is moving "+ robot.getCardinalDirection());
				} else {
					logger.info("Move command ignored");
				}
				break;
			case WEST:
				if (robot.getxPosition() > Robot.MIN_POSITION) {
					robot.decreaseXPosition();
					logger.info("The robot is moving "+ robot.getCardinalDirection());
				} else {
					logger.info("Move command ignored");
				}
				break;
			default:
				break;

			}
		}

	}

}
