package edu.ycp.cs320.team6.chess.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.team6.chess.model.Board;

public class BoardTest {
	private Board model = new Board();
	
	@Test
	public void testGetFilePathByPosition() {
		assertEquals("Images/Chess_black_rook.png", model.getImageFromPosition(8, 8));
	}


}
