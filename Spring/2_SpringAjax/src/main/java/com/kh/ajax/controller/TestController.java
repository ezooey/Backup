package com.kh.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.ajax.model.vo.Sample;

@Controller
public class TestController {
	
	@Autowired
	private Sample sam;
	
	@RequestMapping("test.do")
	public void test() {
		System.out.println(sam);
	}

}
