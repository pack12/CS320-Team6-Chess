package edu.ycp.TBH.servlet;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.TBH.dbPersist.Database;
import edu.ycp.TBH.model.DB_GVal;

import java.util.ArrayList;

public class MainServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private Database db = new Database();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Games Servlet: doGet");
		
		//TODO: set appropriate db method
		
		ArrayList<DB_GVal> trialList = db.findTrials();
		String strpass = " ";
		
		if(trialList!=null) {
			for(DB_GVal trial : trialList) {
				
				strpass += "<li>" +trial.getDate()+ ": " + trial.getForceVal()+ " | " +"</li>";
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
