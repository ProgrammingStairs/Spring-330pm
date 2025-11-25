package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController{
	
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("message", "This is an example of home page in spring mvc");
		return "index";
	}
	
	@GetMapping("/about")
	public String aboutPage(Model model) {
		model.addAttribute("message", "This is an example of about page in spring mvc");
		return "about";
	}

}