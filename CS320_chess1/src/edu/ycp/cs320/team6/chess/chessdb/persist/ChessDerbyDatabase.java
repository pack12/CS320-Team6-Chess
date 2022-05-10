package edu.ycp.cs320.team6.chess.chessdb.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.team6.chess.chessdb.persist.DB_Util;
import edu.ycp.cs320.team6.chess.chessdb.model.DBPiece;
import edu.ycp.cs320.team6.chess.chessdb.model.DBUser;
import edu.ycp.cs320.team6.chess.chessdb.model.DBGame;


public class ChessDerbyDatabase{
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;
	
	
	
	
	
	
	
	public DBPiece findPieceByPosition(final int x, final int y) {
		return executeTransaction(new Transaction<DBPiece>() {
			@Override
			public DBPiece execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					// Retrieve all attributes from piece table
					stmt = conn.prepareStatement(
							"select pieces.*" +
							"  from pieces" +
							" where pieces.x = ? " +
							"   and pieces.y = ? and pieces.captured = 'N'"
					);
					stmt.setInt(1, x);
					stmt.setInt(2,  y);
					
					DBPiece result = new DBPiece();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						// load piece into result
						// retrieve attributes from resultSet starting with index 1
						loadPiece(result, resultSet, 1);
					
					}
					
					// check if the title was found
					if (!found) {
					
						result = null;
					}
					
					return result;
				} finally {
					DB_Util.closeQuietly(resultSet);
					DB_Util.closeQuietly(stmt);
				}
			}
		});
	}
	
	public DBPiece findKingByColor(final String color) {
		return executeTransaction(new Transaction<DBPiece>() {
			@Override
			public DBPiece execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					// Retrieve all attributes from piece table
					stmt = conn.prepareStatement(
							"select pieces.*" +
							"  from pieces" +
							" where pieces.type = 'King'" +
							"   and pieces.color = ?"
					);
					stmt.setString(1, color);
					
					
					DBPiece result = new DBPiece();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned

					
					while (resultSet.next()) {						
						// load piece into result
						// retrieve attributes from resultSet starting with index 1
						loadPiece(result, resultSet, 1);
					}
					
					// check if the title was found

					
					return result;

				} finally {
					DB_Util.closeQuietly(resultSet);
					DB_Util.closeQuietly(stmt);
				}
			}
		});
	}
	
	public String findColorByPosition(final int x, final int y) {
		return executeTransaction(new Transaction<String>() {
			@Override
			public String execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					// Retrieve all attributes from piece table
					stmt = conn.prepareStatement(
							"select pieces.*" +
							"  from pieces" +
							" where pieces.x = ? " +
							"   and pieces.y = ?"
					);
					stmt.setInt(1, x);
					stmt.setInt(2,  y);
					
					DBPiece result = new DBPiece();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						// load piece into result
						// retrieve attributes from resultSet starting with index 1
						loadPiece(result, resultSet, 1);
					
					}
					
					String string = result.getColor();
					
					// check if the title was found
					if (!found) {

						result = null;
					}
					
					return string;
				} finally {
					DB_Util.closeQuietly(resultSet);
					DB_Util.closeQuietly(stmt);
				}
			}
		});
	}
	
	public void updateCapturedByPosition(final int x, final int y, final String cap) {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				
				
				try {
					// Replace the x and y for the initial position with the final position
					stmt = conn.prepareStatement(
							"update pieces" +
							" set pieces.captured = ? " +
							" where pieces.x = ? and pieces.y = ?"
					);
					stmt.setString(1, cap);
					stmt.setInt(2, x);
					stmt.setInt(3, y);
					
					stmt.execute();
					
					return true;
				} finally {
					DB_Util.closeQuietly(stmt);
				}
			}
		});
	}
	
	public void undoTempCaptured() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				
				
				try {
					// Replace the x and y for the initial position with the final position
					stmt = conn.prepareStatement(
							"update pieces" +
							" set pieces.captured = 'N'" +
							" where pieces.captured = 'T'"
					);
					
					
					stmt.execute();
					
					return true;
				} finally {
					DB_Util.closeQuietly(stmt);
				}
			}
		});
	}
	
	public void finalizeTemp() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				
				
				try {
					// Replace the x and y for the initial position with the final position
					stmt = conn.prepareStatement(
							"update pieces" +
							" set pieces.captured = 'Y'" +
							" where pieces.captured = 'T'"
					);
;
					
					stmt.execute();
					
					return true;
				} finally {
					DB_Util.closeQuietly(stmt);
				}
			}
		});
	}
	
	public ArrayList<DBPiece> findCaptured(final String color){
		return executeTransaction(new Transaction<ArrayList<DBPiece>>() {
			@Override
			public ArrayList<DBPiece> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					// Retrieve all attributes from piece table
					stmt = conn.prepareStatement(
							"select pieces.*" +
							"  from pieces" +
							" where pieces.captured = 'Y' and pieces.color = ?"
					);
						stmt.setString(1, color);
					
					ArrayList<DBPiece> result = new ArrayList<DBPiece>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						DBPiece add = new DBPiece();
						
						loadPiece(add, resultSet, 1);
						
						result.add(add);
					
					}
					
					// check if the title was found
					if (!found) {
						System.out.println("There are no captured pieces");
						result = null;
					}
					
					return result;
				} finally {
					DB_Util.closeQuietly(resultSet);
					DB_Util.closeQuietly(stmt);
				}
			}
		});
	}
	
	public ArrayList<DBPiece> findUnCaptured(final String color){
		return executeTransaction(new Transaction<ArrayList<DBPiece>>() {
			@Override
			public ArrayList<DBPiece> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					// Retrieve all attributes from piece table
					stmt = conn.prepareStatement(
							"select pieces.*" +
							"  from pieces" +
							" where pieces.captured = 'N' and pieces.color = ?"
					);
						stmt.setString(1, color);
					
					ArrayList<DBPiece> result = new ArrayList<DBPiece>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						DBPiece add = new DBPiece();
						
						loadPiece(add, resultSet, 1);
						
						result.add(add);
					
					}
					
					// check if the title was found
					if (!found) {
						System.out.println("There are no uncaptured pieces");
						result = null;
					}
					
					return result;
				} finally {
					DB_Util.closeQuietly(resultSet);
					DB_Util.closeQuietly(stmt);
				}
			}
		});
	}
	
	public ArrayList<DBGame> findGamesByPlayer(final String player){
		return executeTransaction(new Transaction<ArrayList<DBGame>>() {
			@Override
			public ArrayList<DBGame> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					// Retrieve all attributes from piece table
					
					System.out.print("FGBP A");
					
					stmt = conn.prepareStatement(
							"select games.*" +
							"  from games" +
							" where games.player1 = ?" +
							" or games.player2 = ?"
					);
					
						System.out.print("FGBP B");
					
						stmt.setString(1, player);
						stmt.setString(2, player);
						
						
						System.out.print("FGBP B");
					
					ArrayList<DBGame> result = new ArrayList<DBGame>();
					
					resultSet = stmt.executeQuery();
					
					System.out.print("FGBP C");
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						DBGame add = new DBGame();
						
						loadPiece(add, resultSet, 1);
						
						result.add(add);
					
					}
					
					// check if the title was found
					if (!found) {
						System.out.println("This player has no games");
						result = null;
					}
					
					System.out.print("FGBP D");
					
					return result;
				} finally {
					DB_Util.closeQuietly(resultSet);
					DB_Util.closeQuietly(stmt);
				}
			}
		});
	}
	
	public void updatePiecePosition(final int startx, final int starty, final int endx, final int endy) {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				
				
				try {
					// Replace the x and y for the initial position with the final position
					stmt = conn.prepareStatement(
							"update pieces" +
							" set pieces.x = ?, pieces.y = ?" +
							" where pieces.x = ? and pieces.y = ? and pieces.captured = 'N'"
					);
					stmt.setInt(1, endx);
					stmt.setInt(2, endy);
					stmt.setInt(3, startx);
					stmt.setInt(4, starty);
					
					stmt.execute();
					
					return true;
				} finally {
					DB_Util.closeQuietly(stmt);
				}
			}
		});
	}
	
	public void addGameToGames(final String player1, final int change1, final String player2, final int change2) {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				
				
				try {
					// Replace the x and y for the initial position with the final position
					stmt = conn.prepareStatement(
							"insert into games (player1, player2, victor, change) values (?, ?, ?, ?)"
					);
					stmt.setString(1, player1);
					stmt.setInt(2, change1);
					stmt.setString(3, player2);
					stmt.setInt(4, change2);
					
					stmt.execute();
					
					return true;
				} finally {
					DB_Util.closeQuietly(stmt);
				}
			}
		});
	}
	
	
	
	public DBUser findUserByUsernameAndPassword(final String username, final String password) {
		return executeTransaction(new Transaction<DBUser>() {
			@Override
			public DBUser execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					// Retrieve all attributes from piece table
					stmt = conn.prepareStatement(
							"select *" +
							"  from users" +
							" where users.username = ? " +
							"   and users.password = ?"
					);
					stmt.setString(1, username);
					stmt.setString(2,  password);
					
					DBUser result = new DBUser();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						// load piece into result
						// retrieve attributes from resultSet starting with index 1
						loadUser(result, resultSet, 1);
					
					}
					
					// check if the title was found
					if (!found) {
						System.out.println("The user " + username + " does not exist, or the password is incorrect");
						result = null;
					}
					
					return result;
				} finally {
					DB_Util.closeQuietly(resultSet);
					DB_Util.closeQuietly(stmt);
				}
			}
		});
	}
	
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					
					result = txn.execute(conn);
				
					conn.commit();
					
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DB_Util.closeQuietly(conn);
		}
	}

	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:test.db;create=true");
		
		// Set autocommit to false to allow execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	private void loadUser(DBUser user, ResultSet resultSet, int index) throws SQLException {
		user.setUsername(resultSet.getString(index++));
		user.setPassword(resultSet.getString(index++));
		user.setRanking(resultSet.getInt(index++));
	}
	
	private void loadPiece(DBPiece piece, ResultSet resultSet, int index) throws SQLException {
		piece.setType(resultSet.getString(index++));
		piece.setColor(resultSet.getString(index++));
		piece.setHasMoved(resultSet.getString(index++));
		piece.setX(resultSet.getInt(index++));
		piece.setY(resultSet.getInt(index++));	
		piece.setCaptured(resultSet.getString(index++));
	}
	
	private void loadPiece(DBGame game, ResultSet resultSet, int index) throws SQLException {
		game.setGameID(resultSet.getInt(index++));
		game.setPlayer1(resultSet.getString(index++));
		game.setChange1(resultSet.getInt(index++));
		game.setPlayer2(resultSet.getString(index++));
		game.setChange2(resultSet.getInt(index++));
	}
	
	// will have to replace sql logic
	
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				
				try {
					stmt1 = conn.prepareStatement(
						"create table pieces (" +									
						"	type varchar(10)," +
						"	color varchar(10)," +
						"   hasMoved varchar(1)," +
						"   x integer," +
						"   y integer," +
						"   captured varchar(1)" +
						")"
					);	
					stmt1.executeUpdate();
					
					stmt2 = conn.prepareStatement(
							"create table users (" +
							"	username varchar(40)," +
							"	password varchar(15)," +
							"   ranking integer" +
							")"
					);
					stmt2.executeUpdate();
					
					stmt3 = conn.prepareStatement(
							"create table games (" +
							"	game_id integer primary key " +
							"	generated always as identity (start with 1, increment by 1), " +
							"	player1 varchar(40)," +
							"   Player_One_Change integer," +
							"	player2 varchar(40)," +
							"	Player_Two_Change integer" +
							")"
					);
					
					stmt3.executeUpdate();
					return true;
				} finally {
					DB_Util.closeQuietly(stmt1);
					DB_Util.closeQuietly(stmt2);
				}
			}
		});
	}
	
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<DBPiece> pieceList; 
				List<DBUser> userList; 
				List<DBGame> gameList;
				
				try {
					pieceList = InitiateData.getPieces();
					userList = InitiateData.getUsers();
					gameList = InitiateData.getGames();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertPiece = null;
				PreparedStatement insertUser  = null;
				PreparedStatement insertGame = null;

				try {
					//populate pieces table
					insertPiece = conn.prepareStatement("insert into pieces (type, color, hasmoved, x, y, captured) values (?, ?, ?, ?, ?, ?)");
					for (DBPiece piece : pieceList) {
						insertPiece.setString(1, piece.getType());
						insertPiece.setString(2, piece.getColor());
						insertPiece.setString(3, piece.getHasMoved());
						insertPiece.setInt(4, piece.getX());
						insertPiece.setInt(5, piece.getY());
						insertPiece.setString(6, piece.getCaptured());
						insertPiece.addBatch();
					}
					insertPiece.executeBatch();
					
					//populate the users table
					insertUser = conn.prepareStatement("insert into users (username, password, ranking) values (?, ?, ?)");
					for (DBUser user : userList) {
						insertUser.setString(1, user.getUsername());
						insertUser.setString(2, user.getPassword());
						insertUser.setInt(3, user.getRanking()); 
						insertUser.addBatch();
					}
					insertUser.executeBatch();
					
					insertGame = conn.prepareStatement("insert into games (player1, Player_One_Change, player2, Player_Two_Change) values (?, ?, ?, ?)");
					for (DBGame game : gameList) {
						insertGame.setString(1, game.getPlayer1());
						insertGame.setInt(2, game.getChange1());
						insertGame.setString(3, game.getPlayer2());
						insertGame.setInt(4, game.getChange2());
						insertGame.addBatch();
					}
					insertGame.executeBatch();
					
					return true;
				} finally {
					DB_Util.closeQuietly(insertPiece);
					DB_Util.closeQuietly(insertUser);
				}
			}
		});
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		ChessDerbyDatabase db = new ChessDerbyDatabase();
		db.createTables(); 
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Success!");
	}
}
