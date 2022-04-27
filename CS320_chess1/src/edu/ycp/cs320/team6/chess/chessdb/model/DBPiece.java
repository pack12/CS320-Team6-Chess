package edu.ycp.cs320.team6.chess.chessdb.model;

public class DBPiece {
	
	private String type;
	private String hasMoved;
	private String color;
	private int x;
	private int y;
	private String captured;
	
	public DBPiece() {
		
	}
	
	public DBPiece(String type, String hasMoved, String color, int x, int y, String captured) {
		this.x = x;
		this.y = y;
		this.hasMoved = hasMoved;
		this.type = type;
		this.color = color;
		this.captured = captured;
	}
	
	public void setHasMoved(String info) {
		this.hasMoved = info;
	}
	
	public String getHasMoved() {
		return hasMoved;
	}
	
	public void setColor(String info) {
		this.color = info;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setType(String info) {
		this.type = info;
	}
	
	public String getType() {
		return type;
	}
	
	public void setX(int info) {
		this.x = info;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int info) {
		this.y = info;
	}
	
	public int getY() {
		return y;
	}
	
	public void setCaptured(String captured) {
		this.captured = captured;
	}
	
	public String getCaptured() {
		return captured;
	}

}
