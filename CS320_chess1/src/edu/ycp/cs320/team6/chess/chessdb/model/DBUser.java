package edu.ycp.cs320.team6.chess.chessdb.model;

public class DBUser {
	
	private String username;
	private String password;
	private int ranking;
	
	public DBUser() {
		
	}
	
	public DBUser(String username, String password, int ranking) {
		this.username = username;
		this.password = password;
		this.ranking = ranking;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	public int getRanking() {
		return ranking;
	}
}
