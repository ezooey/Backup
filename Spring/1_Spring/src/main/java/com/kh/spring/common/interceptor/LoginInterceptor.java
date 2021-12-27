package com.kh.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring.member.model.vo.Member;

public class LoginInterceptor implements HandlerInterceptor{
	
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		if(loginUser != null) {
			logger.info(loginUser.getId());
		}
	}
	// 이 인터셉터를 통해 로그파일에 로그인 기록과 회원가입 기록이 분리되어 로그인 기록만 남을 수 있게 됨
	// 21-12-27 10:20:28 [INFO] LoginInterceptor.afterCompletion{25} - dd
	// 더 이상 컨트롤러를 통해 로그 기록이 남지 않고 인터셉터를 통한 기록만 남는 것을 확인 가능
}
