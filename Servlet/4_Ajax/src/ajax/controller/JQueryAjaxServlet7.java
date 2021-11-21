package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import ajax.model.vo.User;

/**
 * Servlet implementation class JQueryAjaxServlet7
 */
@WebServlet("/jQueryAjax7.do")
public class JQueryAjaxServlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JQueryAjaxServlet7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User(1, "박신우", "한국"));
		userList.add(new User(2, "타일러 라쉬", "미국"));
		userList.add(new User(3, "쯔위", "중국"));
		userList.add(new User(4, "모모", "일본"));
		userList.add(new User(5, "리사", "태국"));
		userList.add(new User(6, "알베르토 몬디", "이탈리아"));
		userList.add(new User(7, "샘 해밍턴", "호주"));
		
		String userNo = request.getParameter("userNo"); // 12,1,3 이런 식으로 들어갈 수 있으니 String
		String[] ids = userNo.split(",");
		
		JSONArray userArr = new JSONArray();
		for(String id : ids) {
			for(int i = 0; i < userList.size(); i++) {
				if(Integer.parseInt(id) == userList.get(i).getUserNo()) {
					User user = userList.get(i);
					
					JSONObject userObj = new JSONObject();
					userObj.put("userNo", user.getUserNo());
					userObj.put("userName", user.getUserName());
					userObj.put("userNation", user.getUserNation());
					
					userArr.add(userObj);
				}
			}
		}
		
		JSONObject result = new JSONObject();
		result.put("list", userArr); // 배열을 여러 개 보내야 될 때? 10시 40분
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
