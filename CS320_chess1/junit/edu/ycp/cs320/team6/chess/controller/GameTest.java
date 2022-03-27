package edu.ycp.cs320.team6.chess.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.team6.chess.model.*;
import edu.ycp.cs320.team6.chess.controller.GameController;

public class GameTest {
	private BoardModel model;
    private GameController controller;

	@Before
	public void setUp() throws Exception {
		model = new BoardModel();
        controller = new GameController();

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
        controller.makeMove(1, 1, 1, 2);
        assertTrue(controller.validateMove(7, 7, 7, 6));
        assertFalse(controller.validateMove(0, 0, 7, 7));
    }

}
