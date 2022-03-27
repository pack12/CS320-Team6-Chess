package edu.ycp.cs320.team6.chess.model;

import java.util.ArrayList;

import edu.ycp.cs320.team6.chess.model.Piece;

public class Player{
	private Piece[] piece;
	private ArrayList<Piece> offBoard;
	
	public Player(){
		piece = new Piece[16];
		offBoard = new ArrayList<>();
	}
	
	public Piece getPiece(int i) {
		return piece[i];
	}
	
	public void setPiece(int i, Piece piece) {
		this.piece[i] = piece;
	}
	
	public void pieceTaken(int i) {
		offBoard.add(piece[i]);
	}
}