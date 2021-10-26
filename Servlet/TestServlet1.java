package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Servlet에 도착!");
		
		// HttpServletRequest.getParameter(String name):String
		//		매개변수 name? input의 name속성값 = url(쿼리스트링)에 변수
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height"); // 숫자가 들어가도 String으로 반환(숫자로 쓰려면 parsing필요)
//		String food = request.getParameter("food");
		// HttpServletRequest.getParameterValues(String name):String[]
		// -> 여러 개의 값을 가져올 때 사용
		String[] food = request.getParameterValues("food");
		
		System.out.println(name);
		System.out.println(gender);
		System.out.println(age);
		System.out.println(city);
		System.out.println(height);
		for(String f : food) {
			System.out.println(f);
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개인정보 출력화면</title>");
		out.println("<style>");
		out.println("h2{color: red}");
		out.println("span{font-weight: bold;}");
		out.println("#name{color: orange;}");
		out.println("#gender{color: yellow; background: black;}");
		out.println("age{color: green;}");
		out.println("city{color: blue;}");
		out.println("height{color: navy;}");
		out.println("#food{color: purple;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>개인 취향 테스트 결과(GET)</h2>");
		out.println("<span id='name'>" + name + "</span>님은");
		out.println("<span id='age'>" + age + "</span>이시며, ");
		out.printf("<span id='city'>%s</span>에 사는 ", city);
		out.printf("키 <span id='height'>%s</span>cm인", height);
		out.printf("<span id='gender'>%s</span>입니다.", gender);
		out.print("좋아하는 음식은 <span id='food'>");
		
		for(int i = 0; i < food.length; i++) {
			if(i == 0) {
				out.printf("%s", food[i]);
			} else {
				out.printf(", %s", food[i]);
			}
		}
		
		out.println("</span>입니다.");
		out.println("</body>");
		out.println("</html>");
	}

}
