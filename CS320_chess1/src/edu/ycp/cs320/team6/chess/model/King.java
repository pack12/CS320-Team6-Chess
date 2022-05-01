package edu.ycp.cs320.team6.chess.model;

import edu.ycp.cs320.team6.chess.chessdb.model.DBPiece;
import edu.ycp.cs320.team6.chess.chessdb.persist.ChessDerbyDatabase;

public class King extends Piece implements PieceInterface{
	
	
	public King(int X, int Y, boolean hasMoved, String color) {
		super(X, Y, hasMoved, color);
		
		
	}
	
	public boolean sees(int lookX, int lookY) {
		if (abs(X - lookX) < 2 && abs(Y - lookY) < 2) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	public boolean validateMove(int Xgoing, int Ygoing, int[][] board) {
		return true;
	}

	
	public boolean checkPathOpen(int lookX, int lookY) {
		
			ChessDerbyDatabase db = new ChessDerbyDatabase();
			DBPiece checktake = db.findPieceByPosition(lookX, lookY);
			if (checktake == null || checktake != null && checktake.getCaptured() == "Y") {
				return true;
			} 
			else {
				if (checktake.getColor().equals(color)) {
					return false;
				}
				else{
					return true;
				}
			}
		}
}