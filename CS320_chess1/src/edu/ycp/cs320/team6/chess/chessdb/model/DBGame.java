package edu.ycp.cs320.team6.chess.chessdb.model;

public class DBGame {
	private int gameID;
	private String player1;
	private String player2;
	private int change1;
	private int change2;
	
	
	public DBGame() {
		
	}
	
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	public int getGameID() {
		return gameID;
	}
	public void setPlayer1(String player1) {
		this.player1 = player1;
	}
	
	public String getPlayer1() {
		return player1;
	}
	
	public void setPlayer2(String player2) {
		this.player2 = player2;
	}
	
	public String getPlayer2() {
		return player2;
	}
	
	public void setChange1(int change1) {
		this.change1=change1;
	}
	
	public int getChange1() {
		return change1;
	}
	
	public void setChange2(int change2) {
		this.change2=change2;
	}
	
	public int getChange2() {
		return change2;
	}
	
	
}
