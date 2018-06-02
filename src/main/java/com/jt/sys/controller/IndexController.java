package com.jt.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class IndexController {
	@RequestMapping("indexUI")
	public String indexUI(){
		System.out.println("start");
		return "starter";
	}
}
