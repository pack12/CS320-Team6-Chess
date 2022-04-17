package edu.ycp.cs320.team6.chess.model;

import edu.ycp.cs320.team6.chess.model.Player;
import edu.ycp.cs320.team6.chess.model.Piece;

public class Board{
	private int[][] board;
	private Piece[][] board1;
	private Piece piece;
	
	public Board(){
		board = new int[8][8];
		board1 = new Piece[8][8];
	}
	
	
	//This method may potentially be useless
	//I want this method to return an array position of board, so if I pass in 3 4, I want the return to be "[3][4]
	
	public int getSpot(int x, int y) {
		
		return board[x][y];
	}
	
	public Piece getspot(int x, int y) {
		return board1[x][y];
	}
	
	//Board is going to be able to get a piece depending on the location data inputed in
	//BUT WHAT do we need? I need to be able to access pieces and their location data, and see if they match up with the Board array location. 
	public void addPieceToBoard(Piece piece, int x, int y) {
		this.board1[x][y] = piece;
		
	}
	
	public Piece getPiece(int posX, int posY) {
		for(int i=0; i<board.length;i++) {
			System.out.print(i+":");
			for(int j=0; j<board.length;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		return piece;
	}
	
	
	//Potentially don't need this
//	public void getPiece() {
//		//null
//	}
}