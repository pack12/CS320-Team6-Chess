package edu.ycp.cs320.team6.chess.chessdb.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.team6.chess.chessdb.model.DBPiece;
import edu.ycp.cs320.team6.chess.chessdb.model.DBUser;
import edu.ycp.cs320.team6.chess.chessdb.model.DBGame;

public class InitiateData {
	public static List<DBPiece> getPieces() throws IOException {
		List<DBPiece> pieceList = new ArrayList<DBPiece>();
		ReadCSV readpieces = new ReadCSV("pieces.csv");
		try {
			
			while (true) {
				List<String> tuple = readpieces.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				DBPiece piece = new DBPiece();
				piece.setType(i.next());
				piece.setColor(i.next());
				piece.setHasMoved(i.next());
				piece.setX(Integer.parseInt(i.next()));
				piece.setY(Integer.parseInt(i.next()));
				piece.setCaptured(i.next());
				pieceList.add(piece);
			}
			return pieceList;
		} finally {
			readpieces.close();
		}
	}
	
	public static List<DBUser> getUsers() throws IOException {
		List<DBUser> userList = new ArrayList<DBUser>();
		ReadCSV readUsers = new ReadCSV("users.csv");
		try {
			 
			while (true) {
				List<String> tuple = readUsers.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				DBUser user = new DBUser();
				user.setUsername(i.next());
				user.setPassword(i.next());
				user.setRanking(Integer.parseInt(i.next()));
				userList.add(user);
			}
			return userList;
		} finally {
			readUsers.close();
		}
	}
	
	public static List<DBGame> getGames() throws IOException {
		List<DBGame> gameList = new ArrayList<DBGame>();
		ReadCSV readGames = new ReadCSV("games.csv");
		try {
			Integer game_ID = 1;
			while (true) {
				List<String> tuple = readGames.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				DBGame game = new DBGame();
				game.setGameID(game_ID++);
				game.setPlayer1(i.next());
				game.setChange1(Integer.parseInt(i.next()));
				game.setPlayer2(i.next());
				game.setChange2(Integer.parseInt(i.next()));
				gameList.add(game);
			}
			return gameList;
		} finally {
			readGames.close();
		}
	}
}


