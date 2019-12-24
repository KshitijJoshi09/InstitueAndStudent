package com.spiders.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spiders.app.config.Constants;
import com.spiders.app.dto.UserDto;

@Controller

public class AppController {


	@RequestMapping("/")
	String displayIndex(HttpSession session , Model model){
		
		// logic fot session 
		UserDto user = (UserDto)session.getAttribute("user");
		if(user != null) {
			model.addAttribute("user", user);
			model.addAttribute("userId",user.getUserId());
			model.addAttribute("userName",user.getFirstName() + " " +user.getLastName()  );
			if(user.getRole().equals(Constants.ADMIN_ROLE)) {
				return "AdminDashBoard";
			}
			else {
				return "UserDashBoard";
			}	
		}
		System.out.println("Entry point");	
		return "index";
	}
	
	
}
