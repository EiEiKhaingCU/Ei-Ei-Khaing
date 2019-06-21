package com.trustcore.intern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trustcore.intern.dta.StudentInfo;
import com.trustcore.intern.model.Student;

@Controller
public class StudentController {
	@Autowired
	StudentInfo studentDao;
	@RequestMapping(value="/index.htm")
	public String welcome(Model model){
		model.addAttribute("msg","Hello World");
		model.addAttribute("student", new Student());
		return "index";
	}
	@RequestMapping(value="/postInfo.htm",method=RequestMethod.POST)
	public String submitData(Model model,@ModelAttribute(value="student") Student stu){
	studentDao.saveStudent(stu);
	model.addAttribute("student", studentDao.getStudent());
	return "student";
	}
	@RequestMapping(value="/student.htm")
	public String student(Model model){
		model.addAttribute("student",studentDao.getStudent());
		return "student";
	}
	
	@RequestMapping(value="/deleteStudent/{id}")
	public String delteStudent(Model model,@PathVariable(value="id")int id){
	studentDao.deleteStudent(id);
	return "redirect:/student.htm";
}

	
	
}
