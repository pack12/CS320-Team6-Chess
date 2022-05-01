package edu.ycp.cs320.team6.chess.model;
import edu.ycp.cs320.team6.chess.chessdb.persist.ChessDerbyDatabase;
import edu.ycp.cs320.team6.chess.chessdb.model.DBPiece;

public class Rook extends Piece implements PieceInterface{
	
	public Rook(int X, int Y, boolean hasMoved, String color) {
		super(X, Y, hasMoved, color);
		
	}
	
	public boolean sees(int lookX, int lookY) {
		if (X - lookX == 0) {
			return true;
		}
		else if (Y - lookY == 0) {
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
		
		if(!(incrementX==0)) {
		incrementX = incrementX/(abs(incrementX));
		incrementY = 0;
		}
		else {
		incrementY = incrementY/(abs(incrementY));
		incrementX = 0;
		}
		
		int i=X+incrementX;
		int j=Y+incrementY; 
	
	
		while (i!=lookX || j!=lookY){ 
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
	
	public boolean validateMove(int Xgoing, int Ygoing, int[][] board) {
		return true;
	}
	
}