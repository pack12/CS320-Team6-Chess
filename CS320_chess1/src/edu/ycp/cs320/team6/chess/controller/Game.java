package edu.ycp.cs320.team6.chess.controller;

import edu.ycp.cs320.team6.chess.model.Piece;
import edu.ycp.cs320.team6.chess.model.Player;
import edu.ycp.cs320.team6.chess.model.Board;
import edu.ycp.cs320.team6.chess.model.Login;

public class Game{
	private Board board;
	private Player player;
	private Player opponent;
	private Piece playerPiece;
	
	
	 
	
	public Game() {
		board = new Board();
	}
	
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	
	public void validateMove(int prevX, int prevY, int newX, int newY) {
		
		
//		if(board.getSpot(prevX, prevY)== 0) 
//		{
//			player.updatePiece(newX, newY);
//		}
//		else {
//			//Else the position remains the same for the piece
//			player.updatePiece(prevX, prevY);
//		}
		
		
		
		
		
	}
	
	
}