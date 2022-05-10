package edu.ycp.cs320.team6.chess.controller;

import edu.ycp.cs320.team6.chess.model.*;
import edu.ycp.cs320.team6.chess.model.Piece;
import edu.ycp.cs320.team6.chess.model.Player;
import edu.ycp.cs320.team6.chess.model.Board;
import edu.ycp.cs320.team6.chess.model.Login;
import edu.ycp.cs320.team6.chess.chessdb.persist.ChessDerbyDatabase;
import edu.ycp.cs320.team6.chess.chessdb.model.DBPiece;
import java.util.ArrayList;

public class Game{
	private Board board;
	private Player player;
	private Player opponent;
	private Piece playerPiece;
	private ChessDerbyDatabase db;
	
	
	 
	
	public Game() {
		board = new Board();
		db = new ChessDerbyDatabase();
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
	
	
	public boolean validateEach(int prevX, int prevY, int newX, int newY) {
		
		DBPiece translator = new DBPiece();
		translator = db.findPieceByPosition(prevX, prevY);
		
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
		
		
		

		
		return piece.validateMove(newX, newY);
		
		
		
	}
	
	public boolean validateCheck(int oX, int oY, int nX, int nY) {
		
	String color = db.findColorByPosition(oX, oY);
	
		DBPiece king = db.findKingByColor(color);
	
		
		
		if(color.equals("White")) {
			color = "Black";
		}
		else {
			color = "White";
		}
		
		if(!validateEach(oX, oY, nX, nY)) {
			System.out.print(db.findPieceByPosition(oX, oY).getType() + db.findPieceByPosition(oX, oY).getColor());
			System.out.print("False At A");
			return false;
		}
		else {
			db.updateCapturedByPosition(nX, nY, "T");
			db.updatePiecePosition(oX, oY, nX, nY);
		}
		
		ArrayList<DBPiece> cycle = db.findUnCaptured(color);
		
		
		
		
		
		Boolean end = true;
		Boolean endChanger;
		
		for(DBPiece each : cycle) {
			endChanger = validateEach(each.getX(), each.getY(), king.getX(), king.getY());
			System.out.print("First Piece:" + each.getY() + each.getX() + "King:" +king.getX() + " " + king.getY() + "Bool:" + endChanger);
			if(endChanger) {
				System.out.print("False At B");
				end = false;
			}
		}
		
		System.out.print('\n');
		
		if(!end) {
			db.updatePiecePosition(nX, nY, oX, oY);
			db.undoTempCaptured();
		}
		else {
			db.finalizeTemp();
		}
		
		
		System.out.print("end ret");
		return end;
	}
	
	
}