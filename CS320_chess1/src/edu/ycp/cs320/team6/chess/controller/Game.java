package edu.ycp.cs320.team6.chess.controller;

import edu.ycp.cs320.team6.chess.model.Board;


public class Game{
	
	private static Board board;
	private static int turn;
	private static int clock;
	
	public Game() {
		board = new Board();
		turn = 1;
		clock = 600;
	}
	
	public void startGame() {
		board.fillBoard();
	}
	
	public void clearGame() {
		board.clearBoard();
	}
	
	//check color with turn to see if it is the player's turn
	
	public static boolean isPlayersTurn(int x, int y) {
		if (board.getPiece(x, y).getColor() == "white" && turn == 1) {
			return true;
		}
		else if (board.getPiece(x, y).getColor() == "black" && turn == 2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//check to see if the destination is on the board
	
	public static boolean isOnBoard(int x, int y) {
		if (x<0 || x>7) {
			return false;
		}
		else if (y<0 || y>7) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//check to see if the move is legal
	//ONLY INCLUDES: testing to see if the move is on the board and if it is the player's turn
	
	public boolean validateMove(int xinit, int yinit, int xfinal, int yfinal) {
		if(Game.isPlayersTurn(xinit, yinit) && Game.isOnBoard(xfinal, yfinal) ) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	public static void updateTurn() {
		if(turn == 1) {
			turn = 2;
		}
		else if (turn == 2) {
			turn = 1;
		}
	}
	
	public void makeMove(int xinit, int yinit, int xfinal, int yfinal) {
		board.movePiece(xinit, yinit, xfinal, yfinal);
		Game.updateTurn();
	}
}