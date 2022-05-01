package edu.ycp.cs320.team6.chess.model;

import static org.junit.Assert.*;
import edu.ycp.cs320.team6.chess.chessdb.persist.ChessDerbyDatabase;
import edu.ycp.cs320.team6.chess.chessdb.model.DBPiece;
import edu.ycp.cs320.team6.chess.chessdb.model.DBUser;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import edu.ycp.cs320.team6.chess.model.*;

public class PiecesInTheWayTest {
	
	private Bishop bishop;
	private King king;
	private Rook rook;
	private Queen queen;
	private Pawn pawn;
	private Knight knight;
	private ChessDerbyDatabase db;
	
	@Before
	public void setUp() {
		
		bishop = new Bishop(1, 3, false, "White");
		king = new King(1, 4, false, "White");
		rook = new Rook(1, 1, false, "White");
		queen = new Queen(1, 5, false, "White");
		pawn = new Pawn(2, 4, false, false, "White");
		knight = new Knight(1, 2, false, "White");
		db = new ChessDerbyDatabase();
		
	}
	
	@Test
	public void testBishop() {
		assertEquals(false, bishop.checkPathOpen(2,  4));
		assertEquals(false, bishop.checkPathOpen(3,  5));
		assertEquals(false, bishop.checkPathOpen(4,  6));
		Bishop bish = new Bishop(3, 1, false, "White");
		assertEquals(true, bish.checkPathOpen(7,  5));
		assertEquals(false, bish.checkPathOpen(8,  6));
		
}
}