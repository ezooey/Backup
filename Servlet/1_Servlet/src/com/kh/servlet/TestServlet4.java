package com.kh.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet4 extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		String[] food = request.getParameterValues("food");
		
		String recommendation = null;
		switch(age) {
		case "10대 미만": recommendation = "비눗방울 건"; break;
		case "10대": recommendation = "슬라임"; break;
		case "20대": recommendation = "애플워치"; break;
		case "30대": recommendation = "돈"; break;
		case "40대": recommendation = "지갑"; break;
		case "50대": recommendation = "바디프렌드"; break;
		}
		// 여기까지는 view에서 servlet으로 넘길 데이터를 받아주기만 하고 넘겨주지 않았음
		// 데이터를 넘겨주는 코드가 없으므로 추가해야 함
		// request 영역에 보낼 데이터를 저장
		
		// jsp에게 전달할 데이터 담기 : request
		// -> HttpServletRequest.setAttribute(String name, Object obj):void
		// --> 첫 번째 매개변수 String name : 데이터를 담는 변수
		// --> 두 번째 매개변수 Object obj : 넘길 데이터
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		String foodStr = "";
		for(int i = 0; i < food.length; i++) {
			if(i == 0) {
				foodStr += food[i];
			} else {
				foodStr += ", " + food[i];
			}
		}
		request.setAttribute("food", foodStr);
		request.setAttribute("recommendation", recommendation);
		
		// Servlet에서 결과 화면을 생성하는 것이 아니라 결과 화면을 출력할 곳으로 이동(jsp)
		// 페이지 이동 1. RequestDispatcher.forward()
		//				-> 이동할 페이지에 데이터 전달 가능(request, response 유지)
		//				-> url 변경 x
		// 페이지 이동 2. HttpServletResponse.sendRedirect()
		//				-> 이동할 페이지에 데이터 전달 불가능 (request, response 새로 생성)
		//				-> url 변경
		
		/* 
		   1. 회원가입
		   	회원가입을 마친 후 메인 페이지로 이동(메인페이지로 넘어가면 정보 필요 없음)
		   	=> sendRedirect() (권장)
		   	
		   2. 게시글 상세보기
		   	게시글 목록 중 하나를 누르면 게시글 상세보기로 이동(어느 게시물의 상세페이지를 볼 건지 정보 필요)
		   	=> forward() (권장)
		   	
		   	: 필수는 아님
		*/
		
		RequestDispatcher view = request.getRequestDispatcher("servlet/testServlet4End.jsp");
		view.forward(request, response);
	}

}
