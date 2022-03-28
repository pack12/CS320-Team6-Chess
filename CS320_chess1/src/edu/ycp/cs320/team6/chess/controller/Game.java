package edu.ycp.cs320.team6.chess.controller;

import edu.ycp.cs320.team6.chess.model.Piece;
import edu.ycp.cs320.team6.chess.model.Player;
import edu.ycp.cs320.team6.chess.model.Board;
import edu.ycp.cs320.team6.chess.model.Login;

public class Game{
	private Board board;
	private Player player;
	
	 
	
	public Game() {
		board = new Board();
	}
	
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void validateMove(int prevX, int prevY, int newx, int newy) {
//		
//		
//		board [prevx][prevy].getThing() possibly integer >>give us what we need to know
		
		//wehen we put in this ^^ it will return whatever piece is in that pos
		
		
		
		
		
		//^^Will return whatever is there, which will be indictative of piece, will use it directly
		
		//depending on how we store info, it will be integer or string of piece of information 
		//From there, info will be put into playerlogic to store info
		
		
		 //If true, update board, update pieceposition, update if its capturing, update if its captured etc..
		
		
		
		
		board.getSpot(prevX, prevY);
		
		if(board.getSpot(prevX, prevY)== 0) {
			player.updatePiece();
		}
		
		//board[prevX][prevY].getSpot();
		
		
		
	}
	
	
}