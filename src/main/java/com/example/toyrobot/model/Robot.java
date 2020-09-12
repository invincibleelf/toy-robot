package com.example.toyrobot.model;

public class Robot {
	// Maximum and minimum positions a robot can be placed to represent 5 by 5 grid
	public static final Integer MAX_POSITION = 4;
    public static final Integer MIN_POSITION = 0;
    
    private Integer xPosition;
    private Integer yPosition;

	private CardinalDirection cardinalDirection;
    
    public Robot() {}
    
    public Robot(Integer xPosition, Integer yPosition , CardinalDirection cardinalDirection) {
    	this.xPosition = xPosition;
    	this.yPosition = yPosition;;
    	this.cardinalDirection = cardinalDirection;
    }

    public Integer getxPosition() {
		return xPosition;
	}

	public void setxPosition(Integer xPosition) {
		this.xPosition = xPosition;
	}

	public Integer getyPosition() {
		return yPosition;
	}

	public void setyPosition(Integer yPosition) {
		this.yPosition = yPosition;
	}

	public CardinalDirection getCardinalDirection() {
		return cardinalDirection;
	}

	public void setCardinalDirection(CardinalDirection cardinalDirection) {
		this.cardinalDirection = cardinalDirection;
	}
	
	public String getCurrentStatus() {
		return String.join(",", xPosition.toString(), yPosition.toString(), cardinalDirection.toString());
	}
}
