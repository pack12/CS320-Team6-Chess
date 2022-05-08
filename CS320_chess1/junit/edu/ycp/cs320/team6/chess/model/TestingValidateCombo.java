package edu.ycp.cs320.team6.chess.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.team6.chess.chessdb.persist.ChessDerbyDatabase;

public class TestingValidateCombo {

	
	private Bishop bishop;
	private King king;
	private Rook rook;
	private Queen queen;
	private Pawn pawn;
	private Knight knight;
	private ChessDerbyDatabase db;
	
	@Before
	public void setUp() {
		
		bishop = new Bishop(3, 1, false, "White");
		king = new King(4, 1, false, "White");
		rook = new Rook(1, 1, false, "White");
		queen = new Queen(5, 1, false, "White");
		pawn = new Pawn(4, 2, false, false, "White");
		knight = new Knight(2, 1, false, "White");
		db = new ChessDerbyDatabase();
		
	}
	
	@Test
	public void testBishop() {
		assertEquals(false, bishop.validateMove(2,  4));
		assertEquals(false, bishop.validateMove(4,  2));
		assertEquals(false, bishop.validateMove(2,  2));
		Bishop bish = new Bishop(1,3, false, "White");
		assertEquals(true, bish.validateMove(5,  7));
		assertEquals(false, bish.validateMove(6,  8));
	}
		
		@Test
		public void testRook() {
			assertEquals(false, rook.validateMove(2, 1));
			assertEquals(false, rook.validateMove(3, 1));
			assertEquals(false, rook.validateMove(1, 2));
			assertEquals(false, rook.validateMove(1, 3));
			Rook roo = new Rook(1, 7, false, "White");
			assertEquals(true, roo.validateMove(2, 7));
			assertEquals(false, roo.validateMove(3, 7));
			Rook roob = new Rook(7, 8, false, "White");
			assertEquals(true, roob.validateMove(7, 7));
			assertEquals(false, roob.validateMove(6, 7));
		
}
		@Test
		public void testQueen() {
			assertEquals(false, queen.validateMove(5, 2));
			assertEquals(false, queen.validateMove(4, 2));
			assertEquals(false, queen.validateMove(6, 2));
			assertEquals(false, queen.validateMove(5, 3));
			assertEquals(false, queen.validateMove(7, 3));
			assertEquals(false, queen.validateMove(3, 3));
			Queen queeen = new Queen(5, 5, false, "White");
			assertEquals(true, queeen.validateMove(3, 3));
			assertEquals(true, queeen.validateMove(8, 5));
			assertEquals(true, queeen.validateMove(5, 7));
			assertEquals(true, queeen.validateMove(7, 7));
			assertEquals(false, queeen.validateMove(8, 8));
			assertEquals(false, queeen.validateMove(5, 8));
		}
		@Test
		public void testKnight() {
			assertEquals(false, knight.validateMove(4, 2));
			assertEquals(true, knight.validateMove(3, 3));
			assertEquals(true, knight.validateMove(1, 3));
			Knight knigh = new Knight(5, 6, false, "White");
			assertEquals(true, knigh.validateMove(6, 8));
			assertEquals(true, knigh.validateMove(4, 8));
			assertEquals(true, knigh.validateMove(6, 4));
			assertEquals(true, knigh.validateMove(4, 4));
			assertEquals(true, knigh.validateMove(7, 5));
			assertEquals(true, knigh.validateMove(3, 5));
		}
		@Test
		public void testPawn() {
			assertEquals(true, pawn.validateMove(4, 3));
			assertEquals(true, pawn.validateMove(4, 4));
			assertEquals(false, pawn.validateMove(5, 3));
			assertEquals(false, pawn.validateMove(5, 1));
			Pawn p = new Pawn(5, 6, false, false, "White");
			assertEquals(false, p.validateMove(5, 7));
			assertEquals(false, p.validateMove(5, 8));
			assertEquals(true, p.validateMove(6, 7));
			assertEquals(true, p.validateMove(4, 7));
		}
		@Test
		public void testKing() {
			assertEquals(false, king.validateMove(1, 3));
			assertEquals(false, king.validateMove(1, 5));
			assertEquals(false, king.validateMove(2, 4));
			assertEquals(false, king.validateMove(2, 3));
			King kigg = new King(6, 5, false, "White");
			assertEquals(true, kigg.validateMove(7, 4));
			assertEquals(true, kigg.validateMove(7, 5));
			assertEquals(true, kigg.validateMove(6, 4));
			assertEquals(true, kigg.validateMove(5, 6));
		}
			
		
}
