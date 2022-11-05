package edu.ycp.TBH.dbPersist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.ycp.TBH.dbPersist.DB_Util;
import edu.ycp.TBH.model.DB_GVal;


public class Database{
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
	
	public ArrayList<DB_GVal> findTrials(){
		return executeTransaction(new Transaction<ArrayList<DB_GVal>>() {
			@Override
			public ArrayList<DB_GVal> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					// Retrieve all attributes from piece table
					
					
					stmt = conn.prepareStatement(
							"select trials.*" +
							"  from trials"
					);
						
						
					
					ArrayList<DB_GVal> result = new ArrayList<DB_GVal>();
					
					resultSet = stmt.executeQuery();
					
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						DB_GVal add = new DB_GVal();
						
						loadTrial(add, resultSet, 1);
						
						result.add(add);
					
					}
					
					// check if the title was found
					if (!found) {
						System.out.println("There are no trials");
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
	
	private void loadTrial(DB_GVal trial, ResultSet resultSet, int index) throws SQLException {
		trial.setID(resultSet.getInt(index++));
		trial.setDate(resultSet.getString(index++));
		trial.setForceVal(resultSet.getString(index++));
	}

	
	
	// will have to replace sql logic
	
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				
				try {
					stmt1 = conn.prepareStatement(
						"create table trials ("+
						"	id integer primary key " +
						"	generated always as identity (start with 1, increment by 1), " + 
						"	date varchar(10)," +
						"	force varchar(10)," +
						")"
					);	
					stmt1.executeUpdate();
					
					return true;
				} finally {
					DB_Util.closeQuietly(stmt1);
				}
			}
		});
	}
	
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<DB_GVal> trialList; 
				
				try {
					trialList = InitiateData.getTrials();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}
				
				PreparedStatement insertTrial = null;

				try {
					//populate pieces table
					insertTrial = conn.prepareStatement("insert into trials (ID, date, force) values (?, ?, ?)");
					for (DB_GVal trial : trialList) {
						insertTrial.setInt(1, trial.getID());
						insertTrial.setString(2, trial.getDate());
						insertTrial.setString(3, trial.getForceVal());
						insertTrial.addBatch();
					}
					insertTrial.executeBatch();
					
					
					return true;
				} finally {
					DB_Util.closeQuietly(insertTrial);
				}
			}
		});
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		Database db = new Database();
		db.createTables(); 
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Success!");
	}
}
