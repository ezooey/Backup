package com.kh.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.vo.Member;

public class BoardEnterInterceptor implements HandlerInterceptor{
	
	private Logger logger = LoggerFactory.getLogger(BoardEnterInterceptor.class);
	
	// 로그인을 하지 않으면 게시판에 접근조차 불가해야 하기 때문에 전처리 이용
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		if(loginUser == null) {
			request.setAttribute("msg", "로그인 후 이용하세요");
			request.getRequestDispatcher("WEB-INF/views/home.jsp").forward(request, response);
			
			return false;
			// 이걸 안 걸어주면 로그인을 안 했는데도 컨트롤러로 넘어가게 돼버림 -> 에러 발생 9시 25분
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
