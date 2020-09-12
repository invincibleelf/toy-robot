package com.example.toyrobot.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent different commands for robot object
 */
public class RobotSimulation {

	private List<String> commands = new ArrayList<>();

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }
}
