package edu.ycp.cs320.team6.chess.servlet;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs320.team6.chess.model.Login;
public class GamesServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Games Servlet: doGet");
		Login model = new Login();
		
		HttpSession mySession = req.getSession();
		
		System.out.println(mySession.getCreationTime());
		
		String mySessionId = mySession.getId();
		String smySessionId = req.getRequestedSessionId();
		String username = model.getUserName();
		
		long lastTime = mySession.getLastAccessedTime();
		//req.getSession().setAttribute("username", username);
		System.out.println(mySessionId);
		System.out.println(smySessionId);
		System.out.println("lastTime: '"+lastTime);
		if(mySession.isNew()) {
			System.out.println("Client hasn't joined server?");
		}else {
			System.out.println("Old nws");
		}
		//this is potentially useless, the session info might be the thing that passes username to this page
		req.setAttribute("username", username);
		System.out.println(username);
		
		req.getRequestDispatcher("/_view/games.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		System.out.println("Games Servlet: doPost");
		
		req.getRequestDispatcher("/_view/games.jsp").forward(req, resp);
	}

}
