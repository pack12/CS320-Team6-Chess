package edu.ycp.cs320.team6.chess.model;


//model class for each piece

public abstract class Piece implements PieceInterface{

	protected int X;
	protected int Y;
	protected boolean hasMoved;
	protected String color;
	 
	
	public Piece(int X, int Y, boolean hasMoved, String color) {
		this.X = X;
		this.Y = Y;
		this.hasMoved = false;
		this.color = color;
	}
	
	public Piece() {
		this.X = 0;
		this.Y = 0;
		this.hasMoved = false;
		this.color = "White";
	}
	
	
	
	
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public boolean getHasMoved() {
		return this.hasMoved;
	}
	
	
	public int abs(int i) {
		if (i<0) {
			return -i;
		}
		else {
			return i;
		}
	}
}