package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // post에서 넘어온 get방식이라 인코딩 필요
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		Member loginUser = new MemberService().loginMember(userId, userPwd);
		
		System.out.println(loginUser);
		// 1. SELECT COUNT(*)를 사용하지 않은 이유: 계정이 있다/없다만 판별하는 게 아니라 계정 정보를 이용하기 위해서
		// 2. 계정 정보 이용에 첫 번째는 가지고 온 데이터를 메인 화면에 뿌리기 : forward()
		// 3. 로그인 후 다른 서비스를 이용할 때 계속해서 추가적인 로그인을 하지 않음 : session영역 활용
		
		if(loginUser != null) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(600); // 10분 뒤 세션 종료 (10분 뒤 자동 로그아웃)
			session.setAttribute("loginUser", loginUser);
//			response.sendRedirect("index.jsp") // 주소에 파일 이름이 뜨는 것도 권장x
//			request.getRequestDispatcher("index.jsp").forward(request, response);
			// forward를 쓰면 url이 계속 login.me가 돼서 권장되지 않음
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("msg", "로그인 실패");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
			view.forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); // get을 호출해서 post로 넘어와도 get으로 가게 설정
	}

}
