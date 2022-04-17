package edu.ycp.cs320.team6.chess.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.team6.chess.model.Board;

public class BoardTest {
	private Board model;

//	@Before
//	public void setUp() {
//		boardModel = new BoardModel();
//        boardModel.fillBoard();
//	}

//	@Test
//    public void testHasPiece() {
//        assertTrue(boardModel.hasPiece(0, 0));
//        assertFalse(boardModel.hasPiece(4, 4));
//    }
//
//    @Test
//    public void testGetPiece() {
//        boardModel.removePiece(3, 0);
//        assertEquals(boardModel.getPiece(3, 0), null);
//    }
//
//    @Test
//    public void testClearBoard() {
//        assertTrue(boardModel.hasPiece(1, 1));
//        boardModel.clearBoard();
//        assertFalse(boardModel.hasPiece(1, 1));
//    }
    
    @Test
   public void testGetSpot() {
    	model = new Board();
//    	assertTrue(model.getSpot(0, 0));
    	//int x = model.getSpot(0, 0);
    	//System.out.println(x);
    	assertEquals(0,model.getSpot(3, 4));
    	
    }

}
