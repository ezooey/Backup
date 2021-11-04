package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;

/**
 * Servlet implementation class UpdateFormServlet
 */
@WebServlet("/updateForm.me")
public class UpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFormServlet() {
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
		// view에서 값이 없었던 항목들은 "null"값으로 넘어옴(String)
		String myPhone = request.getParameter("myPhone");
		String myEmail = request.getParameter("myEmail");
		String myAddress = request.getParameter("myAddress");
		String myInterest = request.getParameter("myInterest");
		
		Member myInfo = new Member(myId, null, myName, myNickName, myPhone, myEmail, myAddress, myInterest, null, null, null);
		
		request.setAttribute("myInfo", myInfo);
		request.getRequestDispatcher("WEB-INF/views/member/memberUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
