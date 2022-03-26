package edu.ycp.cs320.team6.chess.model;

public class Queen extends Piece{
	
	public Queen(int X, int Y, boolean hasMoved) {
		super(X, Y, hasMoved);
		
	}
	
	public boolean sees(int lookX, int lookY) {
		if (X - lookX == 0) {
			return true;
		}
		else if (Y - lookY == 0) {
			return true;
		}
		else if (abs(X - lookX) == abs(Y - lookY)) {
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