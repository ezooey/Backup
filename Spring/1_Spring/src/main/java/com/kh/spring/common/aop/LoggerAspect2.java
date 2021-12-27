package com.kh.spring.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect2 {
	
	private Logger logger = LoggerFactory.getLogger(LoggerAspect2.class);
	
//	@Pointcut("execution(* com.kh.spring.board..*(..))")
//	public void myPointCut() {} // 무조건 내용이 비어 있어야 함
//	// 포인트컷(""안의 내용)을 부를 이름만 만들어준 것임
//
//	@Around("myPointCut()") // 위에 지정해준 포인트컷의 이름(메소드형식)을 적는다
	@Around("execution(* com.kh.spring.board..*(..))") // 좀 더 간편한 방법
	public /*void*/Object loggerAdvice(/*JoinPoint*/ProceedingJoinPoint joinPoint) throws Throwable {
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
		
//		Object obj = null;
//		try {
//			obj = joinPoint.proceed();
//		} catch (Throwable e) { // 에러가 나야 롤백을 하는데 여기서 잡혀버림
//			e.printStackTrace();
//		}
		
		Object obj = joinPoint.proceed(); // throws를 해야 에러가 그대로 발생하면서 롤백할 상황을 만들어줌
		
		logger.debug("[After]" + componentName + type + "." + methodName + "()");
		
		return obj;
		
	}
}
