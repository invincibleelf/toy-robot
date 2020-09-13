package com.example.toyrobot.model.command;

import com.example.toyrobot.model.Report;
import com.example.toyrobot.model.Robot;

/**
 * Abstract class for all the command to be executed
 */
public abstract class BaseCommand {

	public abstract void execute(Robot robot, Report report);
}
