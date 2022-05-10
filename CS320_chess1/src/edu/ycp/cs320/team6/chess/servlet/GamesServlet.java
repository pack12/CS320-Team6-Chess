package edu.ycp.cs320.team6.chess.servlet;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs320.team6.chess.chessdb.model.DBGame;
import edu.ycp.cs320.team6.chess.chessdb.persist.ChessDerbyDatabase;
import java.util.ArrayList;

import edu.ycp.cs320.team6.chess.model.Login;
public class GamesServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private ChessDerbyDatabase db = new ChessDerbyDatabase();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Games Servlet: doGet");
		Login model = new Login();
		
		HttpSession mySession = req.getSession();
		
		System.out.println(mySession.getCreationTime());
		
		String mySessionId = mySession.getId();
		String smySessionId = req.getRequestedSessionId();
		String username = (String) req.getSession().getAttribute("username");
		
		System.out.println("username:" + username);
		
		
		
		long lastTime = mySession.getLastAccessedTime();
		//req.getSession().setAttribute("username", username);
		
		System.out.println("lastTime: '"+lastTime);
		if(mySession.isNew()) {
			System.out.println("Client hasn't joined server?");
		}else {
			System.out.println("Old nws");
		}
		
		
		ArrayList<DBGame> gamelist = db.findGamesByPlayer(username);
		String strpass = " ";
		
		if(gamelist!=null) {
			for(DBGame game : gamelist) {
				String scaleA = "";
				String scaleB = "";
				if(game.getChange1()>0) {
					scaleA = "+";
				}
				if(game.getChange2()>0) {
					scaleB = "+";
				}
				
				strpass += "<li>" +game.getPlayer1()+ ": " + scaleA + game.getChange1() + " | " + game.getPlayer2() + ": " + scaleB + game.getChange2() +"</li>";
			}
			}
		
		
		
		req.setAttribute("innerstuff", strpass);
		
		req.getRequestDispatcher("/_view/games.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		System.out.println("Games Servlet: doPost");
		
		req.getRequestDispatcher("/_view/games.jsp").forward(req, resp);
	}

}
