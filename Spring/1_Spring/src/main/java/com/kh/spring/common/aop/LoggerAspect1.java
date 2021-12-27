package com.kh.spring.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerAspect1 {
	
	private Logger logger = LoggerFactory.getLogger(LoggerAspect1.class);
	
	public /*void*/Object loggerAdvice(/*JoinPoint*/ProceedingJoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		logger.debug("signature : " + signature); // 실행하려는 메소드 정보
		
		String type = signature.getDeclaringTypeName(); // 메소드가 있는 클래스 이름
		String methodName = signature.getName(); // 메소드 이름 자체
		logger.debug("type : " + type);
		logger.debug("methodName : " + methodName);
		
		String componentName = null;
		if(type.indexOf("Controller") > -1) { // 타입 이름 안에 Controller가 있으면
			componentName = "Controller  \t: ";
		} else if(type.indexOf("Service") > -1) {
			componentName = "ServiceImpl  \t: ";
		} else if(type.indexOf("DAO") > -1) {
			componentName ="DAO  \t\t: ";
		}
		
		logger.debug("[Before]" + componentName + type + "." + methodName + "()");
		
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		logger.debug("[After]" + componentName + type + "." + methodName + "()");
		
		return obj;
		
	}
}
