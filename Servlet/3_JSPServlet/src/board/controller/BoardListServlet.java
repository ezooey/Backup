package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.PageInfo;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/list.bo")
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
		// 페이징 처리에 필요한 변수
		int listCount;		// 총 게시글 개수(556개)
		int currentPage;	// 현재 페이지
		int pageLimit;		// 한 페이지에서 보일 페이지 수(최대 10페이지)
		int boardLimit;		// 한 페이지에서 보일 게시글 수(최대 10개)
		int maxPage;		// 가장 마지막 페이지(56)
		int startPage;		// 페이징이 된 페이지 중 시작 페이지(1, 11, 21, 51)
		int endPage;		// 페이징이 된 페이지 중 마지막 페이지(10, 20, 30, 40, 50, 56)
		
		BoardService bService = new BoardService();
		// 페이징처리 1단계 : 몇 페이지가 나오는지 계산하기 위한 전체 게시글 개수 조회
		listCount = bService.getListCount();
		
		// 페이징처리 2단계 : 현재 페이지 설정
		currentPage = 1; // 처음 들어가면 무조건 1페이지이기 때문에 1로 초기 설정해줌
		if(request.getParameter("currentPage") != null) { 
			// currentPage가 null이 아니다 -> 파라미터로 currentPage가 들어왔다 -> 페이징 처리가 된 버튼을 눌렀다 
			// currentPage가 null이다 -> 처음 페이지에 들어왔다 -> currentPage = 1
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		// 페이징처리 3단계 : boardLimit과 pageLimit 설정
		pageLimit = 10;
		boardLimit = 10;
		
		// 페이징처리 4단계 : 각 변수에 알맞은 계산식 작성
		maxPage = (int)Math.ceil(listCount/(double)boardLimit);
		// 나머지가 생기도록 둘 중 하나를 double로 형변환(나머지가 있어야 다음 페이지가 생김 ex.글 개수 11개 -> 2페이지로 넘어감)
		
		startPage = ((currentPage - 1) / pageLimit) * pageLimit + 1;
		// 시작페이지는 01, 11, 21,... 가 되어야 함 -> 10n + 1
		// n을 만들기 위해서 currentPage / pageLimit을 해주는데 currentPage가 10이면 나눈 값이 1이 되어버림
		// => currentPage - 1을 먼저 해준다
		
		endPage = startPage + pageLimit - 1; // pageLimit을 다 못 채울 경우 문제됨
		if(endPage < maxPage) { // 만약 endPage가 maxPage보다 작으면 endPage를 maxPage로 대체한다.
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Board> list = bService.selectList(pi);
		
		String page = null;
		if(list != null) {
			page = "WEB-INF/views/board/boardList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 조회 실패");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
