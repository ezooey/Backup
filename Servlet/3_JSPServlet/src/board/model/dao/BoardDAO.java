package board.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import board.model.vo.Board;
import board.model.vo.PageInfo;

public class BoardDAO {
	
	private Properties prop = null;
	
	public BoardDAO() {
		prop = new Properties();
		String filePath = BoardDAO.class.getResource("/sql/board/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getListCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null; // select 할 거니까 ResultSet
		int result = 0;
		
		String query = prop.getProperty("getListCount");
		// getListCount = SELECT COUNT(*) FROM BOARD WHERE STATUS = 'Y' AND BOARD TYPE = 1
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				result = rset.getInt(1); // 12시 3분
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return result;
	}
//		BEGIN
//		    FOR I IN 1..97
//		    LOOP
//		        INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, 1, 10, I, 100 + I, 'admin', DEFAULT, SYSDATE, SYSDATE, DEFAULT);
//		    END LOOP;
//		END;
//		/
//	
//		COMMIT;
	
	
	public ArrayList<Board> selectList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("selectList");
		// selectList = SELECT * FROM BLIST WHERE RNUM BETWEEN ? AND ?
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1; // 10n + 1
		int endRow = startRow + pi.getBoardLimit() - 1;
		// 4시 20분쯤?
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board(rset.getInt("board_id"),
									rset.getInt("board_type"),
									rset.getString("cate_name"),
									rset.getString("board_title"),
									rset.getString("board_content"),
									rset.getString("board_writer"),
									rset.getString("nickName"),
									rset.getInt("board_count"),
									rset.getDate("create_date"),
									rset.getDate("modify_date"),
									rset.getString("status"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		// insertBoard = INSERT INTO BOARD VALUES(SEQ_BID.NEXTVAL, ?, ?, ?, ?, ?, DEFAULT, SYSDATE, SYSDATE, DEFAULT)
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b.getBoardType());
			pstmt.setInt(2, Integer.parseInt(b.getCategory()));
			pstmt.setString(3, b.getBoardTitle());
			pstmt.setString(4, b.getBoardContent());
			pstmt.setString(5, b.getBoardWriter());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Board selectBoard(Connection conn, int bId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		
		String query = prop.getProperty("selectBoard");
		// selectBoard = SELECT * FROM BDETAIL WHERE BOARD_ID = ?
		/*
		CREATE OR REPLACE VIEW BDETAIL
		AS
		SELECT BOARD_ID, BOARD_TYPE, CATE_NAME, BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER,
		       NICKNAME, BOARD_COUNT, CREATE_DATE, B.MODIFY_DATE, B.STATUS
		FROM BOARD B
		     JOIN MEMBER M ON(USER_ID = BOARD_WRITER)
		     JOIN CATEGORY C USING(CATE_ID)
		WHERE B.STATUS = 'Y';
		 */
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board(rset.getInt("BOARD_ID"),
							  rset.getInt("BOARD_TYPE"),
							  rset.getString("CATE_NAME"),
							  rset.getString("BOARD_TITLE"),
							  rset.getString("BOARD_CONTENT"),
							  rset.getString("BOARD_WRITER"),
							  rset.getString("NICKNAME"),
							  rset.getInt("BOARD_COUNT"),
							  rset.getDate("CREATE_DATE"),
							  rset.getDate("MODIFY_DATE"),
							  rset.getString("STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}

	public int updateCount(Connection conn, int bId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		// updateCount = UPDATE BOARD SET BOARD_COUNT = BOARD_COUNT + 1 WHERE BOARD_ID = ?
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBoard");
		// updateBoard = UPDATE BOARD SET CATE_ID = ?, BOARD_TITLE = ?, BOARD_CONTENT = ? WHERE BOARD_ID = ?
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(b.getCategory()));
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setInt(4, b.getBoardId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBoard(Connection conn, int bId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBoard");
		// deleteBoard = UPDATE BOARD SET STATUS = 'N' WHERE BOARD_ID = ?
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
