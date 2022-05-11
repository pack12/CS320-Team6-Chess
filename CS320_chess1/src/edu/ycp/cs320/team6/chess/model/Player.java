package edu.ycp.cs320.team6.chess.model;

import java.util.ArrayList;

import edu.ycp.cs320.team6.chess.model.Piece;

public abstract class Player{
	private Piece[] piece;
	private Piece playerPiece;
	private ArrayList<Piece> offBoard;
	private String userName;
	private String color;
	private int numGames;
	
	public Player(){
		piece = new Piece[16];
		offBoard = new ArrayList<>();
	}
	
	
	
	//MK3 of setPiece
	public void setPiece(int i) {
		this.playerPiece = this.piece[i];
	}
	
	//Returns a general piece depending on what integer is inputed into the Pieces[] array. This is general method, NOT based on location.
	//The getPiece() method based on location is in Board.java
	
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

	
	//MK2 of setPiece
//	public void setPiece(int i) {
//		this.piece[i] = this.playerPiece;
//	}
	
	
	
	public void pieceTaken(int i) {
		offBoard.add(piece[i]);
	}
	
	
	
	
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setNumGames(int numgames) {
		this.numGames = numgames;
	}
	
	public int getGames() {
		return numGames;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
}