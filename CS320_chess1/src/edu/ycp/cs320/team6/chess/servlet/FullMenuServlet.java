package edu.ycp.cs320.team6.chess.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;

import edu.ycp.cs320.team6.chess.model.FullMenu;
import edu.ycp.cs320.team6.chess.model.Login;

public class FullMenuServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Login model = new Login();
		
		
		System.out.println("FullMenu Servlet: doGet");
		
		HttpSession mySession = req.getSession();
		if(mySession.isNew()) {
			System.out.println("Client hasn't joined server?");
		}else {
			System.out.println("Old nws");
		}
//		String username = req.getParameter("username");
//		System.out.println(username);
//		System.out.println(model.getUserName());
//		req.setAttribute("username", username);
		
		req.getRequestDispatcher("/_view/fullmenu.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		System.out.println("FullMenu Servlet: doPost");
		
		FullMenu model = new FullMenu();
		
		
		
		req.getRequestDispatcher("_view/fullmenu.jsp").forward(req, resp);
		
		
		
	}

}
