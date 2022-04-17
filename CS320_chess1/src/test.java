import edu.ycp.cs320.team6.chess.model.Board;
import edu.ycp.cs320.team6.chess.model.Piece;
import edu.ycp.cs320.team6.chess.model.King;
import edu.ycp.cs320.team6.chess.model.Bishop;

import java.util.ArrayList;
 
public class test {

	public static void main(String[] args) {
		System.out.println("Why hello there");
		Piece piece;
		Piece bishop = new Bishop(1,1,false);
		
		
		Board board = new Board();
		
		
		King king = new King(3,4,false);
		//piece = king;
		
		//board.addPieceToBoard(king, king.getX(), king.getY());
		
		board.fillBoard();
		piece = bishop;

		Piece getPiece = board.getPieces(3, 4);
		System.out.println(getPiece);
		//System.out.println(piece);
		
		ArrayList <Piece> piece1 = board.piece();
		
		System.out.println(piece1);
		
	}

}
