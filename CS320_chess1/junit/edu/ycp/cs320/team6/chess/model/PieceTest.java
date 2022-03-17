package edu.ycp.cs320.team6.chess.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.team6.chess.model.Piece;

class PieceTest {

	private Piece piece;
	
	@Before
	public void setUp() {
		piece = new Piece("pawn", false, 1, 1, "white", true);
	}
	
	@Test
	public void testGetX() {
		assertEquals(piece.getX(), 1);
		piece.setX(2);
		assertEquals(piece.getX(), 2);
	}

	@Test
	public void testGetY() {
		assertEquals(piece.getY(), 1);
		piece.setY(2);
		assertEquals(piece.getY(), 2);
	}
	
	@Test
	public void testGetColor() {
		assertEquals(piece.getColor(), "white");
	}
	
	@Test
	public void testIsOnBoard() {
		assertTrue(piece.isOnBoard());
	}
	
	@Test
	public void testGetType() {
		assertEquals(piece.getType(), "pawn");
	}
}
