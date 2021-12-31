package com.greatlearning.collegefest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.collegefest.entity.Student;
import com.greatlearning.collegefest.service.StudentService;

@Controller
@RequestMapping("/")
public class StudentController {

	@Autowired
	private StudentService studentService;

	public StudentController() {
		System.out.println("The controller class");
	}

	@GetMapping("/list")
	public String getStudents(Model theModel) {

		List<Student> theStudent = studentService.findAll();
		theModel.addAttribute("Student", theStudent);
		return "studentlist";
	}

	@GetMapping("/add")
	public String showFormForAdd(Model theModel) {

		Student theStudent = new Student();

		theModel.addAttribute("Student", theStudent);

		return "studentform";
	}

	@RequestMapping("/save")
	public String saveStudent(Student theStudent) {

		studentService.save(theStudent);
		return "redirect:list";
	}

	@RequestMapping("/update")
	public String showFormForUpdate(@RequestParam("studentId") int studentid, Model theModel) {
		Optional<com.greatlearning.collegefest.entity.Student> student = studentService.FindById(studentid);
		theModel.addAttribute("Student", student.get());
		return "studentform";
	}

	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int id) {
		studentService.DeleteById(id);
		return "redirect:list";
	}

}