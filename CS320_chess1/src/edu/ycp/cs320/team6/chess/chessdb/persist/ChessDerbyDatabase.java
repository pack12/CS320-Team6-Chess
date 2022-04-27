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
					
					// check if the title was found
					if (!found) {
						System.out.println("There is no piece at <" + x + "> and <" + y + ">");
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
	
	
	
	public Boolean updatePiecePosition(final int startx, final int starty, final int endx, final int endy) {
		return executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				
				try {
					// Replace the x and y for the initial position with the final position
					stmt = conn.prepareStatement(
							"update pieces" +
							" set pieces.x = ?, pieces.y = ?" +
							" where pieces.x = ? and pieces.y = ?"
					);
					stmt.setInt(1, endx);
					stmt.setInt(2,  endy);
					stmt.setInt(3, startx);
					stmt.setInt(4,  starty);
					
					stmt.executeQuery();
					
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
	
	// will have to replace sql logic
	
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				
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
				
				try {
					pieceList = InitiateData.getPieces();
					userList = InitiateData.getUsers();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertPiece = null;
				PreparedStatement insertUser  = null;

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
