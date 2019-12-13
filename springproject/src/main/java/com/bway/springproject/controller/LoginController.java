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
import com.bway.springproject.daos.UserDao;
import com.bway.springproject.models.User;

@Controller
public class LoginController {
	@Autowired
	private UserDao udao;
	@Autowired
	private StudentDao sdao;
	@RequestMapping(value = "/userlogin", method = RequestMethod.GET)
	public String getLoginForm() {

		return "login";
	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute User u, Model model) {
		if (udao.login(u.getUsername(),u.getPassword())) {
			model.addAttribute("user", u.getUsername());
			model.addAttribute("slist", sdao.getAllStudent());

			return "home";
		}
		model.addAttribute("error", "user does not exist!!");
		return "login";
	}

}
