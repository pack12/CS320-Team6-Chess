package edu.ycp.cs320.team6.chess.model;

import static org.junit.Assert.*;
import edu.ycp.cs320.team6.chess.chessdb.persist.ChessDerbyDatabase;
import org.junit.Before;
import org.junit.Test;


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
		
		@Test
		public void testRook() {
			assertEquals(false, rook.checkPathOpen(1, 2));
			assertEquals(false, rook.checkPathOpen(1, 3));
			assertEquals(false, rook.checkPathOpen(2, 1));
			assertEquals(false, rook.checkPathOpen(3, 1));
			Rook roo = new Rook(7, 1, false, "White");
			assertEquals(true, roo.checkPathOpen(7, 2));
			assertEquals(false, roo.checkPathOpen(7, 3));
			Rook roob = new Rook(7, 8, false, "White");
			assertEquals(true, roob.checkPathOpen(7, 7));
			assertEquals(false, roob.checkPathOpen(7, 6));
		
}
		@Test
		public void testQueen() {
			assertEquals(false, queen.checkPathOpen(2, 5));
			assertEquals(false, queen.checkPathOpen(2, 4));
			assertEquals(false, queen.checkPathOpen(2, 6));
			assertEquals(false, queen.checkPathOpen(3, 5));
			assertEquals(false, queen.checkPathOpen(3, 7));
			assertEquals(false, queen.checkPathOpen(3, 3));
			Queen queeen = new Queen(5, 5, false, "White");
			assertEquals(true, queeen.checkPathOpen(3, 3));
			assertEquals(true, queeen.checkPathOpen(5, 8));
			assertEquals(true, queeen.checkPathOpen(7, 5));
			assertEquals(true, queeen.checkPathOpen(7, 7));
			assertEquals(false, queeen.checkPathOpen(8, 8));
			assertEquals(false, queeen.checkPathOpen(8, 5));
		}
		@Test
		public void testKnight() {
			assertEquals(false, knight.checkPathOpen(2, 4));
			assertEquals(true, knight.checkPathOpen(3, 3));
			assertEquals(true, knight.checkPathOpen(3, 1));
			Knight knigh = new Knight(6, 5, false, "White");
			assertEquals(true, knigh.checkPathOpen(8, 6));
			assertEquals(true, knigh.checkPathOpen(8, 4));
			assertEquals(true, knigh.checkPathOpen(4, 6));
			assertEquals(true, knigh.checkPathOpen(4, 4));
			assertEquals(true, knigh.checkPathOpen(5, 7));
			assertEquals(true, knigh.checkPathOpen(5, 3));
		}
		@Test
		public void testPawn() {
			assertEquals(true, pawn.checkPathOpen(3, 4));
			assertEquals(true, pawn.checkPathOpen(5, 4));
			assertEquals(false, pawn.checkPathOpen(3, 5));
			assertEquals(false, pawn.checkPathOpen(1, 5));
			Pawn p = new Pawn(6, 5, false, false, "White");
			assertEquals(false, p.checkPathOpen(7, 5));
			assertEquals(false, p.checkPathOpen(8, 5));
			assertEquals(true, p.checkPathOpen(7, 6));
			assertEquals(true, p.checkPathOpen(7, 4));
		}
		@Test
		public void testKing() {
			assertEquals(false, king.checkPathOpen(1, 3));
			assertEquals(false, king.checkPathOpen(1, 5));
			assertEquals(false, king.checkPathOpen(2, 4));
			assertEquals(false, king.checkPathOpen(2, 3));
			King kigg = new King(6, 5, false, "White");
			assertEquals(true, king.checkPathOpen(7, 4));
			assertEquals(true, king.checkPathOpen(7, 5));
			assertEquals(true, king.checkPathOpen(6, 4));
			assertEquals(true, king.checkPathOpen(5, 6));
		}
			
		
}
