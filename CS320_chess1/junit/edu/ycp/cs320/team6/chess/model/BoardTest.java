package edu.ycp.cs320.team6.chess.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.team6.chess.model.Board;

public class BoardTest {
	private Board board;

	@Before
	public void setUp() {
		board = new Board();
        board.fillBoard();
	}

	@Test
    public void testHasPiece() {
        assertTrue(board.hasPiece(0, 0));
        assertFalse(board.hasPiece(4, 4));
    }

    @Test
    public void testGetPiece() {
        board.removePiece(3, 0);
        assertEquals(board.getPiece(3, 0), null);
    }

    @Test
    public void testClearBoard() {
        assertTrue(board.hasPiece(1, 1));
        board.clearBoard();
        assertFalse(board.hasPiece(1, 1));
    }

}
