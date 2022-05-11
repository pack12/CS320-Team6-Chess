package edu.ycp.cs320.team6.chess.model;



import edu.ycp.cs320.team6.chess.model.Player;
import edu.ycp.cs320.team6.chess.model.Piece;
import edu.ycp.cs320.team6.chess.chessdb.persist.ChessDerbyDatabase;
import edu.ycp.cs320.team6.chess.chessdb.model.DBPiece;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Board{

ChessDerbyDatabase db = new ChessDerbyDatabase();

private String[][] board;

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



		if(col ==8) {

			break;

}



if(line.equals("")) {

line = inputFile.nextLine();



}

board[row][col] = line;



row++;



if(row == 8) {



row=0;

col++;



if(col==2) {

//6

row=0;

col=6;

}

}



}















}



public void fillBoardSql() {



int row = 0; 

int col = 0;



ArrayList<DBPiece> piece = db.findUnCaptured("White");



ArrayList<DBPiece> blackPieces = db.findUnCaptured("Black");




for(int i=0; i<piece.size(); i++) {


String filePath = translatePieceImage(piece.get(i).getX(), piece.get(i).getY());


board[row][col] = filePath;

row++;


if(row == 8) {

row = 0;

col++;



}

if(col==3) {

break;

}

}



for(int i=0; i<board.length; i++) {

for(int j=0; j<board.length; j++) {

System.out.println("WRONG X: "+ i+ "Y" + j+ "  "+getBoardImage(i,j));

}

}



row = 0;

col = 7;







for(int i=0; i<blackPieces.size(); i++) {

String filePath = translatePieceImage(blackPieces.get(i).getX(), blackPieces.get(i).getY());





board[row][col] = filePath;

row++;





if(row == 8) {

row = 0;

col-=1;

}

}


}


public String translatePieceImage(int x, int y) {


DBPiece piece = db.findPieceByPosition(x, y);


String src = getBoardImage(piece.getX()-1, piece.getY()-1);



return src;

}

public String getImageFromPosition(int x, int y) {

	String filePath = "";
	
	DBPiece piece = db.findPieceByPosition(x, y);
	
	if(piece!=null) {
	String color = piece.getColor().toLowerCase();
	String type = piece.getType().toLowerCase();
	
	filePath = "Images/Chess_" + color + "_" + type + ".png";
	}

	return filePath;	
}



public String getBoardImage(int x, int y) {

return board[x][y];

}


}

