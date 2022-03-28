package edu.ycp.cs320.team6.chess.model;

import edu.ycp.cs320.team6.chess.model.Player;
import edu.ycp.cs320.team6.chess.model.Piece;

public class Board{
	private int[][] board;
	
	public Board(){
		board = new int[8][8];
	}
	
	public int getSpot(int x, int y) {
		
		return board[x][y];
	}
	
	
	public void getPiece() {
		//null
	}
}