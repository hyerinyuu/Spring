package com.biz.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/html")
@Controller
public class HtmlController {

	/*
	 * resource mapping에서 개발된 폴더/파일 형태의 
	 * RequestMapping이 설정된 Controller가 있을 때
	 * 
	 * resource mapping보다 Controller에 설정된 path가 우선한다.
	 */
	@RequestMapping(value="/hello.html", method=RequestMethod.GET)
	public String hello() {
		
		return "home";
	}
	
}
