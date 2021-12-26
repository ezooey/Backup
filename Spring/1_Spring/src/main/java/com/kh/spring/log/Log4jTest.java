package com.kh.spring.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTest {
	private Logger logger = LoggerFactory.getLogger(Log4jTest.class); // 현재 이 클래스 안의 Logger를 이용할 것이므로
	// LoggerFactory의 getLogger();이용 -> 매개변수에 꼭 HomeController가 들어갈 필요는 x
	// 대신 매개변수에 쓴 Logger를 불러들이는 것이므로 매개변수에 적은 클래스 안에 Logger를 적어야 함

	public static void main(String[] args) {
		new Log4jTest().test();
		
	}
	
	public void test() {
//		logger.fatal("fatal 로그"); 건드릴 수 없는 영역임. 지원x
		logger.error("error 로그");
		logger.warn("warn 로그");
		logger.info("info 로그");
		logger.debug("debug 로그");
		logger.trace("trace 로그");
	}

}
