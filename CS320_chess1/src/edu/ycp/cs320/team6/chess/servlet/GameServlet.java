package edu.ycp.cs320.team6.chess.servlet;

import java.io.IOException;

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
private int timesVisit = 0;
private int row; 
private int col;
private boolean playerOne;
private boolean playerTwo;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Game Servlet: doGet");
		
		board.fillBoardImage();
		//board.addPieceToBoard("Images/Chess_black_pawn.png", 1, 3);
		//req.setAttribute("image", board.getPiece(1, 3));
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
		String filePath = req.getParameter("img");
		

		System.out.println("donde"+req.getSession().getAttribute("playerColor"));
		
		if(from != "$(start)") {
		System.out.println(from);
		}
		
		if(to != "$(end)") {
		System.out.println(to);
		}
		
//		req.setAttribute("image", "Images/Chess_black_pawn.png");
		System.out.println(filePath);
//		req.setAttribute("image", );
		
		//Piece piece = new Piece(xPosPiece, yPosPiece, hasMoved);
		//controller.setModel(piece);
		
		getRowFromParam(from);
		
		System.out.println("FROM col: "+" "+getColFromParam(from));
		
		board.updateBoardImage(1, 1, 2, 2);
		
		
		// Forward to view to render the result HTML document
				req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
		
	}
private int getIntfromParam(String s) {
	if(s == null || s.equals("")) {
		return (Integer) null;
	}else {
		return Integer.parseInt(s);
	}
}

private boolean getBoolFromParam(String s) {
	if(s == null || s.equals("")) {
		return (Boolean) null;
	}else {
		return Boolean.parseBoolean(s);
	}
}


private int getRowFromParam(String s) {
	String str[] = s.split("");
//	System.out.println("FROM row: "+" "+str[1]);
	return getIntfromParam(str[1])-1;
		
	}
	



private int getColFromParam(String s) {
	String str[] = s.split("");
	System.out.println(str[0]+" "+ str[1]);
	System.out.println("Col" + str[0]);
	
	String testStr = str[0];
	if (testStr.equals("a")) {
		col = 0;
	} else if(testStr.equals("b")) {
		col = 1;
	}
	else if(testStr.equals("c")) {
		col = 2;
	}else if(testStr.equals("d")) {
		col = 3;
	}else if(testStr.equals("e")) {
		col = 4;
	}else if(testStr.equals("f")) {
		col = 5;
	}else if(testStr.equals("g")) {
		col = 6;
	}else if(testStr.equals("h")) {
		col = 7;
	}
	
	return col;
}

}