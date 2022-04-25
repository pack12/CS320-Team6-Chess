package ecu.ycp.cs320.tem6.chess.chessdb.dbTests;

import edu.ycp.cs320.team6.chess.chessdb.persist.ChessDerbyDatabase;
import edu.ycp.cs320.team6.chess.chessdb.model.DBPiece;
import edu.ycp.cs320.team6.chess.chessdb.model.DBUser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DBReturnTests {
	
	private ChessDerbyDatabase db;
	private DBPiece pieceStart;
	private DBPiece pieceFinish;
	
	@Before
	public void setup() {
		db = new ChessDerbyDatabase();
		pieceStart = new DBPiece("Rook", "N", "White", 1, 1);
		pieceFinish = new DBPiece("Rook", "N", "White", 5, 5);
	}

	@Test
	public void testUpdatePiecePosition() {
		DBPiece init = db.findPieceByPosition(1, 1);
		assertEquals(init, pieceStart);
		db.updatePiecePosition(1, 1, 5, 5);
		DBPiece finish = db.findPieceByPosition(5, 5);
		assertEquals(finish, pieceFinish);
	}
	
}
