package edu.ycp.cs320.team6.chess.chessdb.model;

public class DBGame {
	private int gameID;
	private String whitePlayer;
	private String blackPlayer;
	
	
	public DBGame() {
		
	}
	
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	public int getGameID() {
		return gameID;
	}
	public void setWhitePlayer(String user) {
		this.whitePlayer = user;
	}
	
	public String getWhitePlayer() {
		return whitePlayer;
	}
	
	public void setBlackPlayer(String user) {
		this.whitePlayer = user;
	}
	
	public String getBlackPlayer(String user) {
		return blackPlayer;
	}
	
	
}
