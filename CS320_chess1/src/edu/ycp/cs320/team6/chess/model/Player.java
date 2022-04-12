package edu.ycp.cs320.team6.chess.model;

import java.util.ArrayList;

import edu.ycp.cs320.team6.chess.model.Piece;

public class Player{
	private Piece[] piece;
	private Piece playerPiece;
	private ArrayList<Piece> offBoard;
	
	public Player(){
		piece = new Piece[16];
		offBoard = new ArrayList<>();
	}
	
	
	
	//MK3 of setPiece
	public void setPiece(int i) {
		this.playerPiece = this.piece[i];
	}
	
	
	public Piece getPiece() {
		return playerPiece;
	}

//Bean: 
	//I slightly changed some of the methods in the player class. Let me know what you think. 
	//I kept your og methods in just in case you want to revert to them. I'm going to commit these, so hopefully it's okay. 
	
//MK1 of getPIece
//	
//	public Piece getPiece(int i) {
//		return piece[i];
//	}

//MK1 of setPiece
//	public void setPiece(int i, Piece piece) {
//		this.piece[i] = piece;
//	}

	
	//MK2
//	public void setPiece(int i) {
//		this.piece[i] = this.playerPiece;
//	}
	
	
	
	public void pieceTaken(int i) {
		offBoard.add(piece[i]);
	}
	
	public void updatePiece(int newX, int newY) {
		playerPiece.move(newX, newY);
		
	}
}