package com.example.toyrobot.utils;

import com.example.toyrobot.model.command.BaseCommand;
import com.example.toyrobot.model.command.PlaceCommand;

public class Utils {

	private static final String PLACE_REGEX = "^(PLACE)\\s\\d+,\\d+,(NORTH|WEST|EAST|SOUTH)$";
	
	public static BaseCommand getCommand(String commandString) {
		if(commandString.matches(PLACE_REGEX)) {
			return new PlaceCommand(commandString);
		}else {
			return null;
		}
		
	}
}
