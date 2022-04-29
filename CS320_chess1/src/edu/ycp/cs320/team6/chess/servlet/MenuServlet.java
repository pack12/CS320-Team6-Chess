package edu.ycp.cs320.team6.chess.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Menu Servlet: doGet");
		
		HttpSession mySession = req.getSession();
		if(mySession.isNew()) {
			System.out.println("Client hasn't joined server?");
		}else {
			System.out.println("Old nws");
		}
		req.getRequestDispatcher("/_view/menu.jsp").forward(req, resp);
	}
}