package edu.ycp.cs320.team6.chess.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import edu.ycp.cs320.team6.chess.controller.GameController;
import edu.ycp.cs320.team6.chess.model.Piece;
public class GameServlet extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Game Servlet: doGet");
		
		req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("Game Servlet: doPost");
		
		String errorMessage = null;
		int xPosPiece = getIntfromParam(req.getParameter("PosX"));
		int yPosPiece = getIntfromParam(req.getParameter("PosY"));
		boolean hasMoved = getBoolFromParam(req.getParameter("hasMoved"));
		try {
			String piece = req.getParameter("piece");
		}catch(Exception e) {
			errorMessage = "Error";
		}
		
		GameController controller = new GameController();
		
		
		//Piece piece = new Piece(xPosPiece, yPosPiece, hasMoved);
		//controller.setModel(piece);
		
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
