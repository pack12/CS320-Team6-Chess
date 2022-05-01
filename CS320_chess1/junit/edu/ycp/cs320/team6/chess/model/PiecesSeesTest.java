package edu.ycp.cs320.team6.chess.model;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import org.junit.Test;
import edu.ycp.cs320.team6.chess.model.*;
public class PiecesSeesTest {

	@Test
	public void seeIfBishopKnowsToMoveDiagonally() {
		
		Bishop bishop = new Bishop(2,0,false, "White");
		assertEquals(true, bishop.sees(3, 1));
		assertEquals(false, bishop.sees(10, 8));
//		assertEquals(false, bishop.sees(0, 0));
		
	}
	@Test
	public void seeIfBishopKnowsToNOtMoveHorizontally() {
		Bishop bishop = new Bishop(1,0,false, "White");
		assertEquals(false, bishop.sees(0, 0));
	}
	
	@Test
	public void seeIfBishopKnowsToNotMoveVertically() {
		Bishop bishop = new Bishop(1,0,false, "White");
		assertEquals(false, bishop.sees(1, 1));
	}
	
	
	@Test
	public void seeIfKnightKnowsMove() {
		Knight knght = new Knight(1,0,false, "White");
		assertEquals(true,knght.sees(2, 2));
		System.out.println(knght.X);
		assertEquals(true, knght.sees(3, 1));
		
		
		//KnightVerticalTests
		assertEquals(false, knght.sees(1, 1));
		
		//KnightDiagonallTEsts
		assertEquals(false, knght.sees(2, 1));
		
		//KnightHorizonatla
		assertEquals(false, knght.sees(2, 0));
	}
	
	@Test
	public void seeIfRookKnowsMove() {
		Rook rook = new Rook(0,0,false, "White");
		
		//Legit Moves
		assertEquals(true, rook.sees(0, 1));
		assertEquals(true, rook.sees(1, 0));
		
		//Incorrect Moves
		assertEquals(false, rook.sees(1, 1));
		assertEquals(false, rook.sees(2, 3));
	
	}
	

	@Test
	public void seeIfQueenkKnowsMove() {
		Queen queen = new Queen(3,0,false, "White");
		Queen queen2 = new Queen(3,4,false, "White");
		//Legit Moves
		
		//Vertical
		assertEquals(true, queen.sees(3, 4));
		assertEquals(true, queen.sees(3, 1));
		assertEquals(true, queen2.sees(3,0));
		
		
		//Horizontal
		assertEquals(true, queen.sees(5, 0));
		assertEquals(true, queen2.sees(0, 4));
		
		//diagonally
		assertEquals(true, queen.sees(4, 1));
		
		//Incorrect Moves
		assertEquals(false, queen.sees(4, 2));
		assertEquals(false, queen.sees(5, 1));
	
	}
	
	@Test
	public void seeIfKingKnowsMove() {
		King king = new King(4,0,false, "White");
		
		//Horizontal by ONe move
		assertEquals(true, king.sees(5, 0));
		
		//Vertical by One move
		assertEquals(true, king.sees(4, 1));
		
		//Diagonal by one move
		assertEquals(true, king.sees(5, 1));
		
		
		//Incorrect MOves
		assertEquals(false, king.sees(5, 2));
		assertEquals(false, king.sees(4, 2));
		assertEquals(false, king.sees(6, 2));
	}
	
	@Test
	public void seeIfPawnKnowsMove() {
		Pawn pawn = new Pawn(2,1,false,false, "White");
		
		//Up by one
		assertEquals(true, pawn.sees(2, 2));
		
		//Up by two
		assertEquals(true, pawn.sees(2, 3));
		
		//Up one over one (ignoring validation)
		assertEquals(true, pawn.sees(3, 2));
		
		//Invorrect moves
		assertEquals(false, pawn.sees(2, 4));
		assertEquals(false, pawn.sees(4, 3));
		assertEquals(false, pawn.sees(3, 1));
	}
	
}
