package edu.ycp.cs320.team6.chess.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import edu.ycp.cs320.team6.chess.controller.Game;
import edu.ycp.cs320.team6.chess.model.Piece;
import edu.ycp.cs320.team6.chess.model.Board;
public class GameServlet extends HttpServlet{
	
private static final long serialVersionUID = 1L;
//Board board = new Board();

	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Game Servlet: doGet");
		
		//board.addPieceToBoard("Images/Chess_black_pawn.png", 1, 3);
		//req.setAttribute("image", board.getPiece(1, 3));
		
		
		req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("Game Servlet: doPost");
		
		
		String from = req.getParameter("start");
		String to = req.getParameter("end");
		String filePath = req.getParameter("imgsrc");
		
		
		if(from != "$(start)") {
		System.out.println(from);
		}
		
		if(to != "$(end)") {
		System.out.println(to);
		}
		
		
		System.out.println(filePath);
//		req.setAttribute("image", );
		
		//Piece piece = new Piece(xPosPiece, yPosPiece, hasMoved);
		//controller.setModel(piece);
		
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
}
