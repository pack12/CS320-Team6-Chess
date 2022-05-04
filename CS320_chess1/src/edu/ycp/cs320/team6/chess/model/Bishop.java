package edu.ycp.cs320.team6.chess.model;
import edu.ycp.cs320.team6.chess.chessdb.persist.ChessDerbyDatabase;
import edu.ycp.cs320.team6.chess.chessdb.model.DBPiece;

public class Bishop extends Piece implements PieceInterface{
	
	public Bishop(int X, int Y, boolean hasMoved, String color) {
		super(X, Y, hasMoved, color);
		
	}
	
	public boolean sees(int lookX, int lookY) {
		if (abs(X - lookX) == abs(Y - lookY)) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	public boolean checkPathOpen(int lookX, int lookY) {
		ChessDerbyDatabase db = new ChessDerbyDatabase();
		
		
		int incrementX = lookX-X;
		int incrementY = lookY-Y;
		
		if(incrementX!=0) {
		incrementX = incrementX/(abs(incrementX));
		}
		if(incrementY!=0) {
		incrementY = incrementY/(abs(incrementY));
		}
		
		int i=X+incrementX;
		int j=Y+incrementY; 
		
		while (i!=lookX){
			DBPiece check = db.findPieceByPosition(i, j);
			
			if (check != null && check.getCaptured().equals("N")) {
				return false;
			}
			i=i+incrementX;
			j=j+incrementY;
		}
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