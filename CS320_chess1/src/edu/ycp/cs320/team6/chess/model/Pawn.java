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
		if ((lookY-Y) == 1 && abs(lookX - X) == 1) {
			return true;
		}else if(abs(X - lookX) == 0 && (lookY - Y) == 1 || abs(X - lookX) == 0 && (lookY - Y) == 2 && !hasLeaped) {
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
		
		if(incrementX == 0) {
		incrementY = 1;
		int i=Y+incrementY; 
		while (i!=lookY){
			System.out.print("looping");
			DBPiece check = db.findPieceByPosition(lookX, i);
			if (check != null && check.getCaptured().equals("N")) {
				return false;
			}
			i=i+incrementY;
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