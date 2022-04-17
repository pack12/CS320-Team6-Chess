import edu.ycp.cs320.team6.chess.model.Board;
import edu.ycp.cs320.team6.chess.model.Piece;
import edu.ycp.cs320.team6.chess.model.King;
import edu.ycp.cs320.team6.chess.model.Bishop;


public class test {

	public static void main(String[] args) {
		System.out.println("Why hello there");
		Piece piece;
		Piece bishop = new Bishop(1,1,false);
		
		int age;
		age = 18;
		Board board = new Board();
		
		
		King king = new King(3,4,false);
		board.addPieceToBoard(king, 3, 4);
		
//		 piece = board.getPiece(3, 4);
		
		int something = board.getSpot(3, 4);
		System.out.println(something);
		//System.out.println(piece);

	}

}
