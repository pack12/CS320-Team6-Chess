package edu.ycp.cs320.team6.chess.model;

public class Pawn extends Piece{
	
	private boolean hasLeaped;
	
	public Pawn(int X, int Y, boolean hasMoved, boolean hasLeaped) {
		super(X, Y, hasMoved);
		this.hasLeaped = false;
	}
	
	public boolean sees(int lookX, int lookY) {
		if (abs(X - lookX) == 1 && (lookY - Y) == 1) {
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