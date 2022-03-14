package edu.ycp.cs320.team6.chess.model;

//model class for each piece

public class Piece{

	private String type;
	private boolean blockCheck;
	private int xLocation;
	private int yLocation;
	private String color;
	private boolean onBoard;
	
public Piece(String type, boolean blockCheck, int xLocation, int yLocation, String color, boolean onBoard) {
	this.blockCheck = blockCheck;
	this.type = type;
	this.color = color; 
	this.xLocation = xLocation;
	this.yLocation = yLocation;
	this.onBoard = onBoard;
}

public int getX() {
	return xLocation;
}

public void setX(int xLocation) {
	this.xLocation = xLocation;
}

public int getY() {
	return yLocation;
}

public void setY(int yLocation) {
	this.yLocation = yLocation;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public boolean isOnBoard() {
	return onBoard;
}

public void setOnBoard(boolean onBoard) {
	this.onBoard = onBoard;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public boolean getBlockCheck() {
	return blockCheck;
}

public void setBlockCheck(boolean blockCheck) {
	this.blockCheck = blockCheck;
}


}