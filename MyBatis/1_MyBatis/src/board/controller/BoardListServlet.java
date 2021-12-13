package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.exception.BoardException;
import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.PageInfo;
import common.Pagination;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/selectList.bo")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardService();
		
		int currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		try {
			int listCount = service.getListCount();
			// 중복되는 코드를 줄이기 위해서 계산식을 담아놓은 pagination클래스를 이용해서 필요할 때마다 호출해서 사용
			// 최종적으로 계산된 코드를 pageInfo에 담아 반환하는 과정
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Board> list = service.selectBoardList(pi);
			
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("WEB-INF/views/board/boardList.jsp").forward(request, response);
			
		} catch (BoardException e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
