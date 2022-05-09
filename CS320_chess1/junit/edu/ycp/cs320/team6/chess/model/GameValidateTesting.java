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
		assertEquals(true, game.validateCheck(2, 7, 3, 8));
	}
}
