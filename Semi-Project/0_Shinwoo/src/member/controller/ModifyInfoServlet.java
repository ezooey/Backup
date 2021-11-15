package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class ModifyInfoServlet
 */
@WebServlet("/modify.info")
public class ModifyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String memberPwd = request.getParameter("password");
		String phone = request.getParameter("number1") + request.getParameter("number2");
		String email = request.getParameter("email1") + request.getParameter("email2");
		String address = request.getParameter("address1") + " " + request.getParameter("address2");
		
		Member m = new Member();
		m.setMemberPwd(memberPwd);
		m.setPhone(phone);
		m.setEmail(email);
		m.setAddress(address);
		
		MemberService mService = new MemberService();

		if(memberPwd != null && memberPwd.trim() != "") {
			int PwResult = mService.updatePwd(m);
			
			if(PwResult < 0) {
				request.setAttribute("msg", "비밀번호 수정 실패");
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
			}
		}
		
		int result = mService.updateMember(m);
		
		if(result > 0) {
			// 마이페이지로
		} else {
			request.setAttribute("msg", "정보 수정 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
