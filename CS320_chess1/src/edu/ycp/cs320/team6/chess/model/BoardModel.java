package edu.ycp.cs320.team6.chess.model;

import java.util.ArrayList;

public class BoardModel{
	
	private Piece[][] board;
	private ArrayList<Piece> offBoard;
	


public BoardModel() {
	
	board = new Piece[8][8];
	offBoard = new ArrayList<Piece>();
	
}

public boolean hasPiece(int i, int j) {
	if (board[i][j] != null) {
		return true;
	}
	else {
		return false;
	}
}
 
public void addCapture(Piece p) {
	offBoard.add(p);
	p.setOnBoard(false);
}

public Piece getPiece(int x, int y) {
	return board[x][y];
}

public void removePiece(int x, int y) {
	board[x][y] = null;
}


public void movePiece(int xinit, int yinit, int xnew, int ynew) {
	board[xnew][ynew]=board[xinit][yinit];
}

public void fillBoard() {
	for(int i=0; i<2; i++) {
		for(int j=0; j<2; j++) {
			board[i][j] = new Piece("pawn", false, i, j, "white", true);
		}
	}
	
	for(int i=5; i<8; i++) {
		for(int j=0; j<2; j++) {
			board[i][j] = new Piece("pawn", false, i, j, "black", true);
		}
	}
}

public void clearBoard() {
	for(int i=0; i<8; i++) {
		for(int j=0; j<8; j++) {
			board[i][j] = null;
		}
	}
}

}