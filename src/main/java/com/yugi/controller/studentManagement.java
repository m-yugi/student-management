package com.yugi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yugi.DTO.studentDto;
import com.yugi.services.studentService;
import com.yugi.validator.countryValidator;
import com.yugi.validator.mobileValidator;
import com.yugi.validator.usernameValidator;

import jakarta.validation.Valid;

@Controller
public class studentManagement {
	@Autowired
	private studentService student_service;

	@GetMapping("/")
	public String getStudentList(Model model) {
		model.addAttribute("students", student_service.getstudentList());
		return "student_list";
	}

	@GetMapping("/addstudent")
	public String addStudent(Model model) {
		model.addAttribute("studentdata", new studentDto());
		return "add_student";
	}

	@PostMapping("/savestudent")
	public String saveStudent(@Valid Model model, @Valid studentDto studentdata, BindingResult result) {
		model.addAttribute("studentdata", studentdata);
		model.addAttribute(BindingResult.MODEL_KEY_PREFIX + "studentdata", result);
		if (result.hasErrors()) {
			return "add_student";
		}
		student_service.saveStudent(studentdata);
		System.out.println(">>> 1 row changed/added ");
		return "redirect:/";
	}

	@GetMapping("/updatestudent")
	public String updatestudent(@RequestParam int userid, Model model) {
		model.addAttribute("studentinfo", student_service.getStudentData(userid));
		model.addAttribute("userid", userid);
		return "update_student";

	}

	@PostMapping("/updateprocess")
	public String updateprocess(@RequestParam int userid, studentDto studentinfo) {
		student_service.updateStudent(userid, studentinfo);
		System.out.println(">>> 1 row updated");
		return "redirect:/";

	}

	@GetMapping("/deletestudent")
	public String deletestudent(@RequestParam int userid) {
		student_service.deleteStudent(userid);
		return "redirect:/";
	}

	@InitBinder
	public void InitBinder(WebDataBinder registry) {
		registry.addValidators(new usernameValidator());
		registry.addValidators(new mobileValidator());
		registry.addValidators(new countryValidator());
	}
}