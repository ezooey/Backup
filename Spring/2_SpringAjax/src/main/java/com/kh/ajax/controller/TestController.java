package com.kh.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.model.vo.Sample;
import com.kh.ajax.model.vo.User;

@Controller
public class TestController {
	
	@Autowired
	private Sample sam;
	
	@RequestMapping("test.do")
	public void test() {
		System.out.println(sam);
	}

	// 1. ServletOutputStream을 이용하여 전송
	@RequestMapping("test1.do")
	public void test1(@RequestParam("name") String name, @RequestParam("age") int age, HttpServletResponse response) {
		System.out.println(name);
		System.out.println(age);
		
		try {
			PrintWriter out = response.getWriter();
			
			if(name.equals("강건강") && age == 20) {
				out.println("ok");
			} else {
				out.println("fail");
			}
			
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public String test2() {
//		JSONObject job = new JSONObject();
//		job.put("no", 123);
//		job.put("title", "return json object test");
//		
//		try {
//			job.put("writer", URLEncoder.encode("남나눔", "UTF-8"));
//			job.put("content", URLEncoder.encode("JSON 객체를 뷰로 리턴합니다.", "UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		return job.toJSONString();
		// 반환형을 JSONObject로 두면 404에러 발생
	
//	@RequestMapping("test2.do")
//	public void test2(HttpServletResponse response) {
//		JSONObject job = new JSONObject();
//		job.put("no", 123);
//		job.put("title", "return json object test");
//		job.put("writer", "남나눔");
//		job.put("content", "JSON 객체를 뷰로 리턴합니다.");
//		
//		try {
//			response.setContentType("application/json; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println(job);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	@RequestMapping(value="test2.do", produces="application/json; charset=UTF-8")
	@ResponseBody // String값을 반환해야 할 때 쓰는 어노테이션
	public String test2() {
		JSONObject job = new JSONObject();
		
		job.put("no", 123);
		job.put("title", "return json object test");
		job.put("writer", "남나눔");
		job.put("content", "JSON 객체를 뷰로 리턴합니다.");
	
		return job.toJSONString();

	}
	
	@RequestMapping(value="test3.do", produces="application/json; charset=UTF-8")
	@ResponseBody
	public /*void*/String test3(HttpServletResponse response) {
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("u111", "p111", "강건강", 20, "k111@kh.or.kr", "01011112222"));
		list.add(new User("u222", "p222", "남나눔", 33, "u222@kh.or.kr", "01022223333"));
		list.add(new User("u333", "p333", "도대담", 17, "d333@kh.or.kr", "01033334444"));
		list.add(new User("u444", "p444", "류라라", 23, "r444@kh.or.kr", "01044445555"));
		list.add(new User("u555", "p555", "문미미", 29, "m555@kh.or.kr", "01055556666"));
		
		JSONArray jArr = new JSONArray();
		
		for(int i = 0; i < list.size(); i++) {
			User user = list.get(i);
			
			JSONObject job = new JSONObject();
			job.put("userId", user.getUserId());
			job.put("userPwd", user.getUserPwd());
			job.put("userName", user.getUserName());
			job.put("age", user.getAge());
			job.put("email", user.getEmail());
			job.put("phone", user.getPhone());
			
			jArr.add(job);
			
//			try {
//				response.setContentType("application/json; charset=UTF-8");
//				PrintWriter out = response.getWriter();
//				out.println(jArr);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
		
		return jArr.toJSONString();
	}
}
