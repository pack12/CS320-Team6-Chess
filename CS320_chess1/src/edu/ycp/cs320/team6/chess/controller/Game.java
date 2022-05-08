package edu.ycp.cs320.team6.chess.controller;

import edu.ycp.cs320.team6.chess.model.*;
import edu.ycp.cs320.team6.chess.model.Piece;
import edu.ycp.cs320.team6.chess.model.Player;
import edu.ycp.cs320.team6.chess.model.Board;
import edu.ycp.cs320.team6.chess.model.Login;
import edu.ycp.cs320.team6.chess.chessdb.persist.ChessDerbyDatabase;
import edu.ycp.cs320.team6.chess.chessdb.model.DBPiece;

public class Game{
	private Board board;
	private Player player;
	private Player opponent;
	private Piece playerPiece;
	private ChessDerbyDatabase db;
	
	
	 
	
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
	
	public boolean validateMove(int prevX, int prevY, int newX, int newY) {
		
		DBPiece translator = db.findPieceByPosition(prevX, prevY);
		if(translator == null) {
			return false;
		}
		
		String type = translator.getType();
		
		boolean leap;
		boolean move;
		
		if(translator.getHasMoved() == "L") {
			move = true;
			leap = true;
		}
		else if(translator.getHasMoved() == "Y") {
			move = true;
			leap = false;
		}
		else {
			leap = false;
			move = false;
		}
		
		Piece piece = new Pawn(translator.getX(), translator.getY(), move, leap, translator.getColor());
		
		if(type.equals("Pawn")) {
			
		}
		else if(type.equals("Bishop")) {
			piece = new Bishop(translator.getX(), translator.getY(), move, translator.getColor());
		}
		else if(type.equals("King")) {
			piece = new King(translator.getX(), translator.getY(), move, translator.getColor());
		}
		else if(type.equals("Queen")) {
			piece = new Queen(translator.getX(), translator.getY(), move, translator.getColor());
		}
		else if(type.equals("Knight")) {
			piece = new Knight(translator.getX(), translator.getY(), move, translator.getColor());
		}
		else {
			piece = new Rook(translator.getX(), translator.getY(), move, translator.getColor());
		}
		
		
		
		
		
		
		
		
		return true;
	}
	
	
}