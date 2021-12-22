package com.kh.spring.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
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
//	@RequestMapping(value="login.me", method=RequestMethod.POST)
//	public String login(Member m, Model model) {
//		
//		Member loginMember = mService.memberLogin(m);
//		
//		if(loginMember != null) {
//			model.addAttribute("loginUser", loginMember);
//			
//			return "redirect:home.do";
//		} else {
//			throw new MemberException("로그인에 실패하였습니다."); // unchecked exception으로 설정해서 throw해도 에러 안 남
//		}
//	}
	
	@RequestMapping("logout.me")
	public String logout(SessionStatus session) {
		session.setComplete();
		
		return "redirect:home.do";
	}
	
	@RequestMapping("enrollView.me")
	public String enrollView() {
		
		return "memberJoin";
	}
	
	@RequestMapping("minsert.me")
	public String insertMember(@ModelAttribute Member m, @RequestParam("post") String post,
							   							 @RequestParam("address1") String address1,
							   							 @RequestParam("address2") String address2) {
		
		String address = post + "/" + address1 + "/" + address2;
		m.setAddress(address);
		
		// bcrypt 암호화 방식 : 스프링 시큐리티 모듈에서 제공
		// 암호화 + 랜덤한 salt값
		String encPwd = bcrypt.encode(m.getPwd());
		m.setPwd(encPwd);
		
		System.out.println(m);
		
		int result = mService.insertMember(m);
		
		if(result > 0) {
			return "redirect:home.do";
		} else {
			throw new MemberException("회원 가입에 실패하였습니다.");
		}
	}
	
	@RequestMapping(value="login.me", method=RequestMethod.POST)
	public String login(Member m, Model model) { // 암호화 안 돼 있음
		
//		String encPwd = bcrypt.encode(m.getPwd());
//		m.setPwd(encPwd);
		// 로그인할 때 쓸 비번을 암호화 시도 
		// => 랜덤한 salt값에 의해 매번 암호화가 바뀌어서 암호화된 비번과 로그인 시 입력된 암호화 비번과 같지 않음 
		
		System.out.println(bcrypt.encode(m.getPwd()));
		
		Member loginMember = mService.memberLogin(m); // 암호화 되어 있음
		
		// 입력한 비밀번호와 암호화된 비밀번호를 매개변수로 일치하는지 여부 검사
		if(bcrypt.matches(m.getPwd(), loginMember.getPwd())) {
			model.addAttribute("loginUser", loginMember);
			
			return "redirect:home.do";
		} else {
			throw new MemberException("로그인에 실패하였습니다.");
		}
		
//		if(loginMember != null) {
//			model.addAttribute("loginUser", loginMember);
//			return "redirect:home.do";
//		} else {
//			throw new MemberException("로그인에 실패하였습니다.");
//		}
	}
	
	@RequestMapping("myinfo.me")
	public String myInfoView() {
		return "mypage";
	}
	
	@RequestMapping("mupdateView.me")
	public String updateFormView() {
		return "memberUpdateForm";
	}
	
	@RequestMapping("mupdate.me")
	public String updateMember(@ModelAttribute Member m, @RequestParam("post") String post,
				 										 @RequestParam("address1") String address1,
				 										 @RequestParam("address2") String address2,
				 										 Model model) {
		
		String address = post + "/" + address1 + "/" + address2;
		m.setAddress(address);
		
		int result = mService.updateMember(m);
		
		if(result > 0) {
			model.addAttribute("loginUser", m);
			// sessionAttribute에 저장해놨기 때문에 model에 추가해줌(sessionAttribute는 model에 들어온 정보를 자동으로 불러옴)
			return "redirect:myinfo.me";
		} else {
			throw new MemberException("회원정보 수정에 실패하였습니다.");
		}
	}
	
	@RequestMapping("mpwdUpdateView.me")
	public String updatePwdFormView() {
		return "memberPwdUpdateForm";
	}
	
	@RequestMapping("mPwdUpdate.me")
	public String updatePwd(@RequestParam("pwd") String pwd, @RequestParam("newPwd1") String newPwd1,
							@RequestParam("newPwd2") String newPwd2, Model model/*, HttpServletRequest request*/) {
		
//		HttpSession session = request.getSession();
//		Member m = (Member)session.getAttribute("loginUser");
		
		Member m = (Member)model.getAttribute("loginUser");
		Member dbMember = mService.memberLogin(m);
		
		int result = 0;
		if(bcrypt.matches(pwd, dbMember.getPwd()) && newPwd1.equals(newPwd2)) { 
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("id", m.getId());
			map.put("newPwd", bcrypt.encode(newPwd1));
			
			result = mService.updatePwd(map);
			
//			// 입력한 비번과 기존 비번이 일치하면 && 새비번과 비번 확인이 일치하면
//			m.setPwd(bcrypt.encode(newPwd1)); // 암호화된 새 비번으로 비번을 설정해
//			int result = mService.updatePwd(m); // 새 비번으로 설정한 m을 넘겨
//			
//			if(result > 0) {
//				model.addAttribute("loginUser", m);
//				return "redirect:myinfo.me";
//			}
		}
		if(result <= 0) {
			throw new MemberException("비밀번호 수정에 실패하였습니다.");
		}
		
		return "redirect:home.do";
	}
	
	@RequestMapping("dupId.me")
	public void duplicateId(@RequestParam("id") String id, HttpServletResponse response) {
		String result = mService.duplicateId(id) == 0 ? "NoDup" : "Dup";
		
		try {
			response.getWriter().println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
