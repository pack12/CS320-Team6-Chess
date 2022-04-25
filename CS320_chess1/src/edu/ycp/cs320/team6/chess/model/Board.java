package edu.ycp.cs320.team6.chess.model;

import edu.ycp.cs320.team6.chess.model.Player;
import edu.ycp.cs320.team6.chess.model.Piece;
import java.util.ArrayList;

public class Board{
	
	//I am changing this from int to string, if it doesn't work, I will change it back
	private String[][] board;
	
	private Piece[][] board1;
	
	private Piece piece;
	
	
	public Board(){
		board = new String[8][8];

	}
	
	
	
	
	//Board is going to be able to get a piece depending on the location data inputed in
	//BUT WHAT do we need? I need to be able to access pieces and their location data, and see if they match up with the Board array location. 
	public void addPieceToBoard(String fileName, int x, int y) {
		board[x][y] = fileName;
		
	}
	public String getPiece(int x, int y) {
		return board[x][y];
	}
	
	
	
	
}