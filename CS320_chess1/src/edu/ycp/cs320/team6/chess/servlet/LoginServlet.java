package edu.ycp.cs320.team6.chess.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.team6.chess.model.Login;

public class LoginServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Login Servlet: doGet");
		
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		System.out.println("Login Servlet: doPost");
		
		Login model = new Login();
		
		String errorMessage = null;
		
		try {
			String userName = req.getParameter("username");
			String passWord = req.getParameter("password");
			
			model.setUserName(userName);
			model.setPassword(passWord);
			
			System.out.println(userName + passWord);
			System.out.println(model.getUserName() + model.getPassword());
			
		} catch(Exception e) {
			errorMessage = "Invalid Username";
		}
		System.out.println(model.getUserName());
	req.getRequestDispatcher("/_view/fullmenu.jsp").forward(req, resp);	
	}


}
