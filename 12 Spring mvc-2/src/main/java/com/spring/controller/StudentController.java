package com.spring.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.entity.Student;
import com.spring.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController{
	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "Hello User, This is an example of Spring Web MVC");
		return "index";
	}
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("student",new Student());
		return "register";
	}
	@PostMapping(value="/register",produces="application/json",consumes="application/json")
	@ResponseBody
	public Map<String, Object> addStudent(@Valid @RequestBody Student student,BindingResult result){
		Map<String,Object> map = new HashMap<>();
	//	System.out.println("-----------------> "+student);
	//	System.out.println("-----------------> "+student.getUsername());
		
		if(result.hasErrors()) {
			Map<String,String> errors = new LinkedHashMap<>();
			String fields[] = {"username","email","password","gender","hobbies","subject"};
			for(String field :  fields) {
				if(result.getFieldError(field)!=null) {
					errors.put("field",field);
					errors.put("message", result.getFieldError(field).getDefaultMessage());
					map.put("status", 403);
					map.putAll(errors);
					return map;
				}
			}
		}
		try {
			studentService.addStudent(student);
			map.put("status", 200);
			map.put("message", "Student Added Successfully");			
		}catch(Exception e) {
			map.put("status", 500);
			map.put("message", "Something went wrong");
			System.out.println("Exception : "+e.getMessage());
		}
		
		return map;
	}
	
}