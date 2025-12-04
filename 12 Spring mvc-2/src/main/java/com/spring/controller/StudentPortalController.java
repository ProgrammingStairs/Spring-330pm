package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentPortalController{
	
	@GetMapping("/")
	public String portalHome(Model model) {
		model.addAttribute("message", "Hello User, This is an example of Spring Web MVC");
		return "studentportal";
	}
}