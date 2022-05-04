package edu.ycp.cs320.team6.chess.model;

import edu.ycp.cs320.team6.chess.chessdb.model.DBPiece;
import edu.ycp.cs320.team6.chess.chessdb.persist.ChessDerbyDatabase;

public class Pawn extends Piece implements PieceInterface{
	
	private boolean hasLeaped;
	
	public Pawn(int X, int Y, boolean hasMoved, boolean hasLeaped, String color) {
		super(X, Y, hasMoved, color);
		this.hasLeaped = false;
	}
	
	public boolean sees(int lookX, int lookY) {
		if ((lookX-X) == 1 && abs(lookY - Y) == 1) {
			return true;
		}else if(abs(X - lookX) == 1 && (lookY - Y) == 0 || abs(X - lookX) == 2 && (lookY - Y) == 0 && !hasLeaped) {
			return true;
		}
		else {
			System.out.print("here");
			return false;
		}		
	}
	
	@Override
	public boolean checkPathOpen(int lookX, int lookY) {
		ChessDerbyDatabase db = new ChessDerbyDatabase();
		DBPiece checktake = db.findPieceByPosition(lookX, lookY);
		
		int incrementX = lookX-X;
		int incrementY = lookY-Y;
		
		if(incrementY == 0) {
		incrementX = 1;
		int i=X+incrementX; 
		while (i!=lookX){
			DBPiece check = db.findPieceByPosition(i, lookY);
			if (check != null && check.getCaptured().equals("N")) {
				return false;
			}
			i=i+incrementX;
		}
		if (checktake == null || checktake != null && checktake.getCaptured() == "Y") {
			return true;
		} 
		else {
				return false;
			}
		}
		else {
			if(checktake != null && !checktake.getColor().equals(color)) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
}