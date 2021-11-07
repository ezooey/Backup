package notice.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;
import notice.model.vo.Notice;
import notice.service.NoticeService;

/**
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet("/insert.no")
public class InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 제목, 작성자, 작성일, 내용
		String title = request.getParameter("title");
		String writer = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		String date = request.getParameter("date"); // 2021-11-05 or ""
		String content = request.getParameter("content");
		
		Date noticeDate = null;
		if(date.equals("")) {
			noticeDate = new Date(new GregorianCalendar().getTimeInMillis());
		} else {
			String[] splitDate = date.split("-");
			int year = Integer.parseInt(splitDate[0]);
			int month = Integer.parseInt(splitDate[1])-1; // 컴퓨터에서는 월 +1로 인식하기 때문에 하나 빼준다
			int day = Integer.parseInt(splitDate[2]);
			
			noticeDate = new Date(new GregorianCalendar(year, month, day).getTimeInMillis()); 
		}
		
		Notice n = new Notice(0, title, content, writer, null, 0, noticeDate, null);
		
		int result = new NoticeService().insertNotice(n);
		
		if(result > 0) { // 공지사항 목록(list.no)
			response.sendRedirect("list.no"); // 요청을 가지고 돌아감 - response
			// 공지사항 목록으로 보낼 데이터는 없음(sendRedirect)
		} else {
			request.setAttribute("msg", "공지사항 등록 실패"); // 에러 요청을 에러페이지로 전달 - request
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
