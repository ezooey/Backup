package com.kh.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.spring.member.model.exception.MemberException;
import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;

@SessionAttributes("loginUser") // 모델 안의 loginUser를 찾아서 세션에 올리는 어노테이션
@Controller // 객체 생성, Controller의 성질을 갖게 생성
// 어노테이션이 있어야 컨트롤러로 등록됨

public class MemberController {
	
	@Autowired // 의존성 주입 어노테이션
	private MemberService mService; 
	// 여기서 객체 생성을 하는 게 아니라 MemberServiceImpl쪽에서 어노테이션을 지정해줌(주도권이 나한테 없게 됨)
	// 필드로만 옮기면 너무 1차원적인 해결방법
	// MemberServiceImpl쪽에서 controller로 객체가 주입되지 않으면(DI가 이루어지지 않으면) null이 뜸
	
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public void login() {
//		System.out.println("로그인 처리합니다.");
//	}
	
	/********** 파라미터 전송 받기 **********/
	
	// 1. HttpServletRequest를 통해 전송받기(JSP/Servlet방식)
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public void login(HttpServletRequest request) {
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
//		
//		System.out.println("id1 : " + id);
//		System.out.println("pwd1 : " + pwd);
//	}
	
	// 2. @RequestParam 방식
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public void login(@RequestParam(value="id", defaultValue="hello") String userId, 
//					  @RequestParam(value="pwd", defaultValue="world") String userPwd,
//					  @RequestParam(value="test", required=false, defaultValue="spring") String test) {
//		// 메뉴바에서 name으로 넘기는 값을 보고 넣는 것임; 
//		// value는 view에서 받아오는 parameter의 name, parameter가 한 개뿐이면 생략 가능
//		// 넣은 값이 있으면 넣은 값이 나오고 값을 넣지 않았으면 defaultValue값이 나옴
//		// required는 필수적으로 받아와야 할 parameter인지 여부를 결정
//		System.out.println("id2 : " + userId);
//		System.out.println("pwd2 : " + userPwd);
//		System.out.println("test : " + test);
//	}
	
	// 3. @RequestParam 생략(비권장)
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public void login(String id, String pwd) {
//		System.out.println("id3 : " + id);
//		System.out.println("pwd3 : " + pwd);
//	}
	
	// 4. @ModelAttribute 방식
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public void login(@ModelAttribute Member m) {
//		System.out.println("id4 : " + m.getId());
//		System.out.println("pwd4 : " + m.getPwd());
//		// getter, setter를 이용해 가져오는 것이기 때문에 이게 없으면 null이 뜸
//	}
	
	// 5. @ModelAttribute 생략(비권장)
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public void login(Member m, HttpSession session) {
//		// 이전에 사용했던 new MemberService() 객체를 만드는 방식은 주도권이 나한테 있으며 결합도가 높아짐
//		// 결합도가 높다는 것을 확인할 수 있는 두 가지 1. 클래스명 변경에 직접적인 영향을 받음 2. 매 요청마다 새로운 service객체 생성
//		
//		Member loginMember = mService.memberLogin(m);
//		
//		if(loginMember != null) {
//			session.setAttribute("loginUser", loginMember);
//		} else {
//			
//		}
//	}
	
	/********** 전달하고자 하는 데이터가 있을 경우에 대한 방법 **********/
	// 1. Model객체 사용
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public String login(Member m, HttpSession session, Model model) {
//		// 지금까지는 메소드 반환값을 void로 했지만 여기서는 String으로 한다.
//		// 반환된 문자열을 ViewResolver가 받아서 경로의 일부분으로 사용해야 하기 때문
//		
//		Member loginMember = mService.memberLogin(m);
//		
//		if(loginMember != null) {
//			session.setAttribute("loginUser", loginMember);
////			return "../home";
//			return "redirect:home.do";
//		} else {
//			model.addAttribute("msg", "로그인에 실패하였습니다.");
//			return "../common/errorPage";
//		}
//	}
	
	// 2. ModelAndView객체 사용
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public ModelAndView login(Member m, HttpSession session, ModelAndView mv) {
//		
//		Member loginMember = mService.memberLogin(m);
//		
//		if(loginMember != null) {
//			session.setAttribute("loginUser", loginMember);
//			mv.setViewName("redirect:home.do"); // view 설정
//		} else {
//			mv.addObject("msg", "로그인에 실패하였습니다."); // 보낼 데이터 설정
//			mv.setViewName("../common/errorPage");
//		}
//		
//		return mv;
//	}
	
//	@RequestMapping("logout.me")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		
//		return "redirect:home.do";
//	}
	
	// 3. session에 저장할 때 @SessionAttributes 사용
	// model객체에 attribute가 추가될 때, 자동으로 키 값을 찾아 세션에 등록
	@RequestMapping(value="login.me", method=RequestMethod.POST)
	public String login(Member m, Model model) {
		
		Member loginMember = mService.memberLogin(m);
		
		if(loginMember != null) {
			model.addAttribute("loginUser", loginMember);
			
			return "redirect:home.do";
		} else {
			throw new MemberException("로그인에 실패하였습니다."); // unchecked exception으로 설정해서 throw해도 에러 안 남
		}
		
	}
	
	@RequestMapping("logout.me")
	public String logout(SessionStatus session) {
		session.setComplete();
		
		return "redirect:home.do";
	}
}
