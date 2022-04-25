package ecu.ycp.cs320.tem6.chess.chessdb.dbTests;

import edu.ycp.cs320.team6.chess.chessdb.persist.ChessDerbyDatabase;
import edu.ycp.cs320.team6.chess.chessdb.model.DBPiece;
import edu.ycp.cs320.team6.chess.chessdb.model.DBUser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DBUpdateTests {

		private DBPiece piece1;
		private DBPiece piece2;
		private DBUser user1;
		private DBUser user2;
		private ChessDerbyDatabase db;
		
		@Before
		public void setup() {
			db = new ChessDerbyDatabase();
			piece1 = new DBPiece("Rook", "N", "White", 1, 1);
			piece2 = new DBPiece("Rook", "N", "White", 1, 1);
			user1 = new DBUser("BrandonStinson", "PassTheWord", 3000);
			user2 = new DBUser("John", "RunRunRun", 3);
		}
		
		@Test
		public void testFindUserByUsernameAndPassword() {
			DBUser user = db.findUserByUsernameAndPassword("BrandonStinson", "PassTheWord");
			DBUser userNull = db.findUserByUsernameAndPassword("Yoddley", "HeeHoo");
			assertEquals(user, user1);
			assertEquals(userNull, null);
			
		}
		@Test
		public void testFindPieceByPosition() {
			DBPiece piece11Rook = db.findPieceByPosition(1, 1);
			DBPiece noPiece = db.findPieceByPosition(5, 5);
			assertEquals(piece1, piece11Rook);
			assertEquals(null, noPiece);
		}
		@Test
		public void testUpdatePiecePosition() {
			
		}
		
	}

