package com.jt.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class IndexController {
	@RequestMapping("indexUI")
	public String indexUI(){
		System.out.println("start");
		return "starter";
	}
}
