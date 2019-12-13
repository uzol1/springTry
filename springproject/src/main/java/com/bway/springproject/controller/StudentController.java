package com.bway.springproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.daos.StudentDao;
import com.bway.springproject.models.Student;

@Controller
public class StudentController {
	@Autowired
	private StudentDao sdao;
	
	@RequestMapping(value="/student")
	public String getStudentForm(Model model) {
		model.addAttribute("smodel",new Student());
		return "studentForm";
	}
	
	@RequestMapping(value="/student", method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute Student s ,Model model) {
		
		sdao.addStudent(s);
		
		model.addAttribute("slist",sdao.getAllStudent());
		return"home";
	}
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") int id, Model model ,HttpSession session) {
		sdao.deleteStudent(id);
		model.addAttribute("slist", sdao.getAllStudent());
		return "home";
}
	@RequestMapping(value="/{id}/edit",method=RequestMethod.GET)
	public String editStudent(@PathVariable("id") int id, Model model) {
		model.addAttribute("smodel", sdao.getById(id));
		return "editform";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateStudent(@ModelAttribute Student stud, Model model) {
		sdao.upgradeStudent(stud);
		model.addAttribute("slist", sdao.getAllStudent());
		return "home";
	}


}

