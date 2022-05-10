package edu.ycp.cs320.team6.chess.model;


import static org.junit.Assert.*;
import edu.ycp.cs320.team6.chess.chessdb.persist.ChessDerbyDatabase;
import org.junit.Before;
import org.junit.Test;
import edu.ycp.cs320.team6.chess.controller.Game;

public class GameValidateTesting {
	
	private Game game;
	private ChessDerbyDatabase db;
	
	@Before
	public void setup() {
		game = new Game();
		db = new ChessDerbyDatabase();
	}
	
	@Test
	public void testValidateCompletely() {
		assertEquals(true, game.validateCheck(4, 2, 4, 3));
		assertEquals(true, game.validateCheck(5, 7, 5, 6));
		assertEquals(true, game.validateCheck(6, 8, 2, 4));
		assertEquals(true, game.validateEach(2, 4, 5, 1));
		assertEquals(false, game.validateCheck(8, 2, 8, 3));
		assertEquals(true, game.validateCheck(3, 1, 4, 2));
	}
}
