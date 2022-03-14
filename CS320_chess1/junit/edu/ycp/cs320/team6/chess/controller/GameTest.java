package edu.ycp.cs320.team6.chess.controller;

import edu.ycp.cs320.team6.chess.model.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
	
	private Board model;
	private Game controller;
	
	@Before
	public void setup() {
		model = new Board();
		controller = new Game();
		
		controller.startGame();
		
	}
	
	@Test
	public void testValidateMove() {
		assertTrue(controller.validateMove(1, 1, 1, 2));
		assertFalse(controller.validateMove(7, 7, 7, 6));
		assertTrue(controller.validateMove(0, 0, 7, 7));
	}
	
	@Test
	public void testMakeMove() {
		
	}
}
