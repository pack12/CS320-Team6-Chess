package edu.ycp.cs320.team6.chess.model;

public class Pawn extends Piece{
	
	private boolean hasLeaped;
	
	public Pawn(int X, int Y, boolean hasMoved, boolean hasLeaped, String color) {
		super(X, Y, hasMoved, color);
		this.hasLeaped = false;
	}
	
	public boolean sees(int lookX, int lookY) {
		if (abs(X - lookX) == 1 && (lookY - Y) == 1) {
			return true;
		}else if(abs(X - lookX) == 0 && (lookY - Y) == 1 || abs(X - lookX) == 0 && (lookY - Y) == 2 ) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	public boolean validateMove(int Xgoing, int Ygoing, int[][] board) {
		return true;
	}
	
}