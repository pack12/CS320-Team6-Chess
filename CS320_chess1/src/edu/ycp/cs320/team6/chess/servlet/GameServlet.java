package edu.ycp.cs320.team6.chess.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs320.team6.chess.controller.Game;
import edu.ycp.cs320.team6.chess.model.Piece;
import edu.ycp.cs320.team6.chess.model.Board;


public class GameServlet extends HttpServlet{
	
private static final long serialVersionUID = 1L;
Board board = new Board();
Game game = new Game();
private int timesVisit = 0;
private int row; 
private int col;
private int squareX;
private int squareY;
private int rowNumber;
private String colNumber;
private boolean playerOne;
private boolean playerTwo;
private int squares = 64;
private int secondaryI = 1;
private ArrayList<Integer> numbers;
private ArrayList<String> squaresList = new ArrayList<String>();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Game Servlet: doGet");
		
		board.fillBoardImage();
		board.fillBoardSql();
		for(int i=0; i<8;i++) {
			for(int j=0; j<8;j++) {
//				System.out.println("I:" + i+ "J: " + j+ board.getBoardImage(i, j));
			}
		}
		int jj = 0;
		//originally this was i<square
		for(int i=0; i<=squares; i++) {
//			System.out.println(i);
			
			String boardCol = getColFromNumber(i);
			int boardRow = getRowFromNumber(i);
			
			String square = boardCol + boardRow;
			squaresList.add(square);
//			System.out.println("SQUARE" + square);

			
			
			
			//Following was attempting to use if-statemetn to controll for the fact that 
			//the array exception kept going off
			//I think it's because we have i is less than squares when it should be 
			//Origianl code now has if statemtn equaling i=8 thagt breaks, else it sets square to file src from board
			//jj++ increments manually 
			
			
			
			
		
			
			
		}
		
		if(squaresList.get(0).equals("a0")) {
			squaresList.remove(0);
		}
		
		System.out.println(squaresList);
		int x = 0; 
		int y = 0;
		
		for(int i=0; i<squaresList.size(); i++) {
//			System.out.println("SQUARE: "+ squaresList.get(i)+" "+"X:" + x+ "Y: " + y+ board.getBoardImage(x, y));
			
			
			x = getXFromSquare(squaresList.get(i));
			y = getYFromSquare(squaresList.get(i));
			
			
			req.setAttribute(squaresList.get(i)+"Image", board.getBoardImage(x, y));
			
			
			
		}	
		

		String username  = (String) req.getSession().getAttribute("username");
		System.out.println("Who is this? " + username);
		timesVisit+=1;
		
		
		
		if (timesVisit==1 && req.getSession().getAttribute("playerColor") == null) {
			req.getSession().setAttribute("playerColor", "Black");
			playerOne = true;
		}else if(timesVisit==2 && req.getSession().getAttribute("playerColor") == null) {
			req.getSession().setAttribute("playerColor", "White");
			playerTwo = true;
		}
		
		if(playerOne == true && playerTwo ==true) {
			System.out.println("These requiremnets are fufilled");
		}
		
		
		
		System.out.println(username + " is" + req.getSession().getAttribute("playerColor") );
		req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("Game Servlet: doPost");
		
		
		String from = req.getParameter("start");
		String to = req.getParameter("end");
		
		//from.charAt(0)
		
		//game.validateCheck(oX, oY, nX, nY)
		
		String filePath = req.getParameter("src");
		

		System.out.println("donde"+req.getSession().getAttribute("playerColor"));
		
		
		
		int oldX = getXFromSquare(from);
		int oldY = getYFromSquare(from);
		int newX = getXFromSquare(to); 
		int newY = getYFromSquare(to);
		
		
		board.translatePieceImage(oldX, oldY);
		
		
		
		
		//board.updateBoardImage(oldX, oldY, newX, newY);
		
		int x;
		int y;
		for(int i=0; i<squaresList.size(); i++) {
//			System.out.println("SQUARE: "+ squaresList.get(i)+" "+"X:" + x+ "Y: " + y+ board.getBoardImage(x, y));
			
			
			x = getXFromSquare(squaresList.get(i));
			y = getYFromSquare(squaresList.get(i));
			
			
			req.setAttribute(squaresList.get(i)+"Image", board.getBoardImage(x, y));
			
			
			
		}
//		req.setAttribute(to+"Image", board.getBoardImage(newX, newY));
		
		

		
		// Forward to view to render the result HTML document
				req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
		
	}


private String getColFromNumber(int number) {
	
	if(number<=8) {
		colNumber= "a";
		
	}else if(number>8 && number<=16) {
		colNumber="b";
	}else if(number>16 && number<=24) {
		colNumber= "c";
	}else if(number>24 && number<=32) {
		colNumber= "d";
	}else if(number>32 && number<=40) {
		colNumber= "e";
	}else if(number>40 && number<=48) {
		colNumber= "f";
	}else if(number>48 && number<=56) {
		colNumber= "g";
		
	}else if(number>56 && number<=64) {
		colNumber= "h";
		
	}
	return colNumber;
	
	
	
}


private int getXFromSquare(String square) {
	
	String str[] = square.split("");
//	System.out.println("SQuare decoupling!!!"+str[0] + str[1]);
	
	if(str[0].equals("a")) {
		squareX = 0;
		
	}else if(str[0].equals("b")) {
		squareX = 1;
	}else if(str[0].equals("c")) {
		squareX = 2;
	}else if(str[0].equals("d")) {
		squareX = 3;
	}else if(str[0].equals("e")) {
		squareX = 4;
	}else if(str[0].equals("f")) {
		squareX = 5;
	}else if(str[0].equals("g")) {
		squareX = 6;
	}else if(str[0].equals("h")) {
		squareX = 7;
	}
	return squareX;
	
	
}

private int getYFromSquare(String square) {
	if(square.endsWith("1")) {
		squareY = 0;
		
	}else if(square.endsWith("2")) {
		squareY = 1;
	}else if(square.endsWith("3")) {
		squareY = 2;
	}else if(square.endsWith("4")) {
		squareY = 3;
	}else if(square.endsWith("5")) {
		squareY = 4;
	}else if(square.endsWith("6")) {
		squareY = 5;
	}else if(square.endsWith("7")) {
		squareY = 6;
	}else if(square.endsWith("8")) {
		squareY = 7;
	}
	return squareY;
}



private int getRowFromNumber(int number) {
	
	//Creates new array list to hold numbers that are multiples of 1,2,3,4,5,6,7,8
	numbers = new ArrayList<Integer>();
	
	






	
	//Adds multiples of 8 to 1,2,3,4,5,6,7,8
	for(int i=1; i<=8; i++) {
		for(int j=1; j<=8; j++) {
			int number1 = i + (8*j);
			
			if(number1<=64) {
				numbers.add(number1);
			}
		}
	}
	
//	System.out.println("Size " + numbers.size());
//	System.out.println("nUMBERS: " + numbers);
	//Cycles through index, which should be 56 elements long
	numbers.add(0,1);
	numbers.add(8,2);
	numbers.add(16,3);
	numbers.add(24,4);
	numbers.add(32,5);
	numbers.add(40,6);
	numbers.add(48,7);
	numbers.add(56,8);
	for(int i=0; i<numbers.size(); i++) {
		int testNumber = numbers.get(i);
		
//		System.out.println("Index: " + i + " Number: " + testNumber);
		
		
		if(testNumber ==number) {
//			System.out.println("same here");
			
			
			//This grouping here is for Row1
			//
			if(i>=0 && i<=7) {
//				System.out.println("Here lays the problem  "+number);
//				for(int j=1; j<=8;j++) {
//					rowNumber=j;
//					return rowNumber;
//				}
				rowNumber = 1;
				}
			//This is for Row2
			else if(i>=8 && i<=15) {
				rowNumber = 2;
				}
			//Row3
			else if(i>=16 && i<=23) {
					rowNumber  = 3;
				}
			//So on...
			else if(i>=24 && i<=31) {
					rowNumber = 4;
				}else if(i>=32 && i<=40) {
//					System.out.println("THIS IS US" + i);
					if(i==40) {
						rowNumber = 6;
						return rowNumber;
					}
					rowNumber  = 5;
				}else if(i>=41 && i<=48) {
					if(i==48) {
						rowNumber = 7;
						return rowNumber;
					}
					rowNumber  = 6;
				}else if(i>=49 && i<=56) {
					if(i==56) {
						rowNumber = 8;
						return rowNumber;
					}
					rowNumber  = 7;
				}else if(i>=57 && i<=64) {
					//orig 64
					rowNumber  = 8;
				}
		}
	}
//	System.out.println(numbers);
	return rowNumber;
	
}


}