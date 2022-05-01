package ecu.ycp.cs320.tem6.chess.chessdb.dbTests;

import edu.ycp.cs320.team6.chess.chessdb.persist.ChessDerbyDatabase;
import edu.ycp.cs320.team6.chess.chessdb.model.DBPiece;
import edu.ycp.cs320.team6.chess.chessdb.model.DBUser;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DBUpdateTests {
	
	private ChessDerbyDatabase db;
	private DBPiece pieceStart;
	private DBPiece pieceFinish;
	
	@Before
	public void setup() {
		db = new ChessDerbyDatabase();
		pieceStart = new DBPiece("Rook", "N", "White", 1, 1, "N");
		pieceFinish = new DBPiece("Rook", "N", "White", 5, 5, "N");
	}

	@Test
	public void testUpdatePiecePosition() {
		DBPiece init = db.findPieceByPosition(1, 1);
		assertEquals(init.getX(), pieceStart.getX());
		db.updatePiecePosition(1, 1, 5, 5);
		DBPiece finish = db.findPieceByPosition(5, 5);
		assertEquals(finish.getX(), pieceFinish.getX());
		assertEquals(finish.getY(), pieceFinish.getY());
	}
	
	@Test
	public void testUpdateCaptured() {
		db.updateCapturedByPosition(2, 2, "Y");
		DBPiece check1 = db.findPieceByPosition(2, 2);
		assertEquals(check1.getCaptured(), "Y");
		db.updateCapturedByPosition(8, 8, "Y");
		DBPiece check2 = db.findPieceByPosition(8, 8);
		assertEquals(check2.getCaptured(), "Y");
	}
	
	 @Test
	public void testCapturedPieces() {
		ArrayList<DBPiece> whitecap = db.findCaptured("White");			
		assertEquals(whitecap.get(0).getCaptured(), "Y");
		assertEquals(whitecap.get(0).getColor(), "White");
		ArrayList<DBPiece> blackcap = db.findCaptured("Black");			
		assertEquals(blackcap.get(0).getCaptured(), "Y");
		assertEquals(blackcap.get(0).getColor(), "Black");
	} 
}
