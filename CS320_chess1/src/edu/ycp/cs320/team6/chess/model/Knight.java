package edu.ycp.cs320.team6.chess.model;

public class Knight extends Piece{
	
	public Knight(int X, int Y, boolean hasMoved) {
		super(X, Y, hasMoved);
		
	}
	
	public boolean sees(int lookX, int lookY) {
		if (abs(X - lookX) == 2 && abs(Y - lookY) == 1) {
			return true;
		}
		else if (abs(X - lookX) == 1 && abs(Y - lookY) == 2) {
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