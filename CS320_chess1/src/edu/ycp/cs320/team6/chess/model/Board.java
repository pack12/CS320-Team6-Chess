package edu.ycp.cs320.team6.chess.model;

import edu.ycp.cs320.team6.chess.model.Player;
import edu.ycp.cs320.team6.chess.model.Piece;
import java.util.ArrayList;

public class Board{
	
	//I am changing this from int to string, if it doesn't work, I will change it back
	private String[][] board;
	
	private Piece[][] board1;
	
	private Piece piece;
	ArrayList<Piece> pieces = new ArrayList<Piece>();
	
	public Board(){
		board = new String[8][8];
//		board1 = new Piece[8][8];
	}
	
	
	//This method may potentially be useless
	//I want this method to return an array position of board, so if I pass in 3 4, I want the return to be "[3][4]
	
//	public int getSpot(int x, int y) {
//		
//		return board[x][y];
//	}
	
	public Piece getspot(int x, int y) {
		return board1[x][y];
	}
	
	//Board is going to be able to get a piece depending on the location data inputed in
	//BUT WHAT do we need? I need to be able to access pieces and their location data, and see if they match up with the Board array location. 
	public void addPieceToBoard(String fileName, int x, int y) {
		board[x][y] = fileName;
		
	}
	public String getPiece(int x, int y) {
		return board[x][y];
	}
	public void fillBoard() {
		
		//Creating the White Colored pieces
		piece = new Rook(7,0,false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Knight(7,1,false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Bishop(7,2,false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Queen(7,3,false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new King(7,4,false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Bishop(7,5,false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Knight(7,6,false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Rook(7,7,false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Pawn(6,0,false, false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Pawn(6,1,false, false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Pawn(6,2,false, false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Pawn(6,3,false, false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Pawn(6,4,false, false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Pawn(6,5,false, false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Pawn(6,6,false, false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Pawn(6,7,false, false);
		this.board1[piece.X][piece.Y] = piece;
		//END OF WHITE PIECES
		
		//Creating the Black Colored Pieces
		piece = new Rook(0,0,false);
		this.board1[piece.X][piece.Y] = piece;
	
		piece = new Knight(0,1,false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Bishop(0,2,false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Queen(0,3,false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new King(0,4,false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Bishop(0,5,false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Knight(0,6,false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Rook(0,7,false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Pawn(1,0,false, false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Pawn(1,1,false, false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Pawn(1,2,false, false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Pawn(1,3,false, false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Pawn(1,4,false, false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Pawn(1,5,false, false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Pawn(1,6,false, false);
		this.board1[piece.X][piece.Y] = piece;
		
		piece = new Pawn(1,7,false, false);
		this.board1[piece.X][piece.Y] = piece;
		
		
		
		
		
	}
	
	public void createConsoleBoard() {
		System.out.println("  01234567");
		for(int i=0; i<3;i++) {
			
			for(int j=0; j<board1.length;j++) {
				if (j==0) {
					System.out.print(i+":");
				}
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	public Piece getPieces(int posX, int posY) {
		System.out.println("  01234567");
		for(int i=0; i<board1.length;i++) {
			
			for(int j=0; j<board1.length;j++) {
				if (j==0) {
					System.out.print(i+":");
				}
				if(board1[i][j]!=null) {
					System.out.print(board1[i][j]);
				}
				System.out.print("*");
			}
			
			System.out.println();
		}
		return board1[posX][posY];
	}
	
	public ArrayList <Piece> piece(){
		for(int i=0; i<board1.length; i++) {
			for(int j =0; j<board1.length; j++) {
				if(board1[i][j]!=null) {
					pieces.add(board1[i][j]);
				}
			}
		}
		return pieces;
		
	}
	
	
	//Potentially don't need this
//	public void getPiece() {
//		//null
//	}
}