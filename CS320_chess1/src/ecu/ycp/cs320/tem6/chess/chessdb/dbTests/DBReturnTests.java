package ecu.ycp.cs320.tem6.chess.chessdb.dbTests;

import edu.ycp.cs320.team6.chess.chessdb.persist.ChessDerbyDatabase;
import edu.ycp.cs320.team6.chess.chessdb.model.DBPiece;
import edu.ycp.cs320.team6.chess.chessdb.model.DBUser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DBReturnTests {

		private DBPiece piece1;
		private DBPiece piece2;
		private DBUser user1;
		private DBUser user2;
		private ChessDerbyDatabase db;
		
		@Before
		public void setup() {
			db = new ChessDerbyDatabase();
			piece1 = new DBPiece("Rook", "N", "White", 1, 1, "N");
			piece2 = new DBPiece("Rook", "N", "White", 1, 1, "N");
			user1 = new DBUser("Bean", "dog", 3000);
			user2 = new DBUser("John", "RunRunRun", 3);
		}
		
		@Test
		public void testFindUserByUsernameAndPassword() {
			DBUser user = db.findUserByUsernameAndPassword("Bean", "dog");
			System.out.println(user);
			DBUser userNull = db.findUserByUsernameAndPassword("Yoddley", "HeeHoo");
			assertEquals(user.getPassword(), user1.getPassword());
			assertEquals(user.getRanking(), user1.getRanking());
			assertEquals(user.getUsername(), user1.getUsername());
			assertEquals(userNull, null);
			
		}
		@Test
		public void testFindPieceByPosition() {
			DBPiece piece11Rook = db.findPieceByPosition(1, 1);
			DBPiece noPiece = db.findPieceByPosition(5, 5);
			assertEquals(piece1.getColor(), piece11Rook.getColor());
			assertEquals(piece1.getType(), piece11Rook.getType());
			assertEquals(piece1.getX(), piece11Rook.getX());
			assertEquals(piece1.getY(), piece11Rook.getY());
			assertEquals(piece1.getHasMoved(), piece11Rook.getHasMoved());
			assertEquals(piece1.getCaptured(), piece11Rook.getCaptured());
			assertEquals(null, noPiece);
		}
		
	}

