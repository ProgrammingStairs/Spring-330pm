package com.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController{
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "Welcome to Spring MVC Example");
		return "index";
	}

	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("message", "Welcome to Spring MVC Example");
		return "addStudent";
	}

	@GetMapping("/viewStudent")
	public String viewStudent(Model model) {
		model.addAttribute("message", "Welcome to Spring MVC Example");
		return "viewStudents";
	}
}