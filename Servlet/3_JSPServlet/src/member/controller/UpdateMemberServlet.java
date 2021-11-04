package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/update.me")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String myId = request.getParameter("myId");
		String myName = request.getParameter("myName");
		String myNickName = request.getParameter("myNickName");
		String myPhone = request.getParameter("myPhone");
		String myEmail = request.getParameter("myEmail");
		String myAddress = request.getParameter("myAddress");
		String[] myInterests = request.getParameterValues("myInterest");
		
		String myInterest = "";
//		if(myInterests != null) {
//			myInterest += String.join(",", myInterests);
//		}
		for(int i = 0; i < myInterests.length; i++) {
			if(i == 0) {
				myInterest += myInterests[i];
			} else {
				myInterest += ", " + myInterests[i];
			}
		}
		
		Member m = new Member(myId, null, myName, myNickName, myPhone, myEmail, myAddress, myInterest, null, null, null);
		
		int result = new MemberService().updateMember(m);
		
		if(result > 0) {
			Member loginUser = new MemberService().selectMember(myId);
			request.getSession().setAttribute("loginUser", loginUser);
			response.sendRedirect("myPage.me"); // myPage.me 앞에 / 넣으면 ContextPath까지 사라짐 그래서 슬래시 삭제
		} else {
			request.setAttribute("msg", "회원정보 수정 실패");
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
