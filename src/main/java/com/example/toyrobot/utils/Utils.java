package com.example.toyrobot.utils;

import com.example.toyrobot.model.command.BaseCommand;
import com.example.toyrobot.model.command.CommandType;
import com.example.toyrobot.model.command.MoveCommand;
import com.example.toyrobot.model.command.PlaceCommand;
import com.example.toyrobot.model.command.ReportCommand;

public class Utils {

	private static final String PLACE_REGEX = "^(PLACE)\\s\\d+,\\d+,(NORTH|WEST|EAST|SOUTH)$";
	
	public static BaseCommand getCommand(String commandString) {
		if(commandString.matches(PLACE_REGEX)) {
			return new PlaceCommand(commandString);
		}else if(commandString.equals(CommandType.MOVE.name())){
			return new MoveCommand();
		}else if(commandString.equals(CommandType.REPORT.name())){
			return new ReportCommand();
		}else {
			return null;
		}
		
	}
}
