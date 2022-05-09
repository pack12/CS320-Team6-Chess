package edu.ycp.cs320.team6.chess.model;

import edu.ycp.cs320.team6.chess.model.Player;
import edu.ycp.cs320.team6.chess.model.Piece;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Board{
	
	
	
	
	
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
	
	
	public void fillBoardImage() throws FileNotFoundException {
		File myFile = new File("chessBoardImages");
		Scanner inputFile = new Scanner(myFile);
		
		int row =0;
		int col =0;
		while(inputFile.hasNext()) {
			String line = inputFile.nextLine();
			
			if(row ==8) {
				break;
			}
			System.out.println("row:"+row+" "+ "col:" + col+ line);
			if(line.equals("")) {
				line = inputFile.nextLine();
				System.out.println("This is the line that should be skipped"+ line);
				System.out.println("row:"+row+" "+ "col:" + col+ line);
			}
			board[row][col] = line;
			
			col++;
			
			if(col == 8) {

				col=0;
				row++;
				
				if(row==2) {
					row=6;
					col=0;
				}
			}
			
		}

		System.out.println(board);
		
	}
	
	
	
	public void updateBoardImage(int oldX, int oldY, int newX, int newY) {
		System.out.println("This is old position X:"+ oldX+ "Y: " + oldY+board[oldX][oldY]);
		System.out.println("This is new position X: " + newX + "Y: " + newY);
		board[newX][newY] = board[oldX][oldY];
		board[oldX][oldY] = "";
		
		for(int i =0; i<board.length; i++) {
			for(int j =0; j<board.length; j++) {
				System.out.println("X: " +i + " Y: "+ j+board[i][j]);
			}
		}
	}
	
	
	public String getBoardImage(int x, int y) {
		return board[x][y];
	}
	
	
	
	public String getPiece(int x, int y) {
		return board[x][y];
	}
	
	
	
	
}