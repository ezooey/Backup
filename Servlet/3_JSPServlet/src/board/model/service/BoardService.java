package board.model.service;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.Attachment;
import board.model.vo.Board;
import board.model.vo.PageInfo;

public class BoardService {
	
	private BoardDAO bDAO = new BoardDAO();

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = bDAO.getListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Board> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = bDAO.selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int insertBoard(Board b) {
		Connection conn = getConnection();
		
		int result = bDAO.insertBoard(conn, b);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public Board selectBoard(int bId, String upd) {
		Connection conn = getConnection();
		
		int result = 0;
		if(!(upd != null && upd.equals("Y"))) { // upd가 있을 때만 조회수 업데이트를 하는 조건
			result = bDAO.updateCount(conn, bId);
		}
		
		Board b = null;
		
		b = bDAO.selectBoard(conn, bId);
		if(result > 0 && b != null) {
				commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return b;
	}

	public int updateBoard(Board b) {
		Connection conn = getConnection();
		
		int result = bDAO.updateBoard(conn, b);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int deleteBoard(int bId) {
		Connection conn = getConnection();
		
		int result = bDAO.deleteBoard(conn, bId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public ArrayList selectTList(int i) { // 여러 타입으로 가져올 것이기 때문에 ArrayList타입 정하지 않음
		Connection conn = getConnection();
		
		ArrayList list = null;
		
		if(i == 1) {
			list = bDAO.selectBList(conn);
		} else {
			list = bDAO.selectFList(conn);
		}
		
		close(conn);
		
		return list;
	}

	public int insertThumbnail(Board b, ArrayList<Attachment> fileList) {
		Connection conn = getConnection();
		
		int result1 = bDAO.insertBoard(conn, b);
		int result2 = bDAO.insertAttachment(conn, fileList);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result1 + result2; // 둘 중 아무거나 보내도 상관은 없음
	}

}
