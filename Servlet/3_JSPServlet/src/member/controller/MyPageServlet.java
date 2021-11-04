package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/myPage.me")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. DB에 저장되어 있는 내 정보를 select 해오는 방법
//		HttpSession session = request.getSession();
//		Member loginUser = (Member)session.getAttribute("loginUser"); // 로그인 한 정보를 loginUser에 담았었음
//		String userId = loginUser.getUserId();
//		
//		Member member = new MemberService().selectMember(userId);
//		
//		request.setAttribute("member", member);
//		// 한 번 담아둘 거니까 일회용인 request에 담아도 됨
//		request.getRequestDispatcher("WEB-INF/views/member/myPage.jsp").forward(request, response);
		
		// 2. 로그인 하면서 session에 저장된 내 정보 불러오는 방법
		request.getRequestDispatcher("WEB-INF/views/member/myPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
