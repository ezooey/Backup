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
}
