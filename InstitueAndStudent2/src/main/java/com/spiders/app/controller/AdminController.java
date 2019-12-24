package com.spiders.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.spiders.app.config.Constants;
import com.spiders.app.dto.UserDto;
import com.spiders.app.service.UserServiceI;

@Controller
public class AdminController {

	Logger log = Logger.getLogger(AdminController.class);

	@Autowired
	UserServiceI userService;

	@GetMapping(value = "/admin/showAllUser/{adminId}")
	public String showAllUser(@PathVariable(name = "adminId") Long adminId, Model model ) {
		

		List<UserDto> allUsers = userService.findAllUserByAdminId(adminId);
		if (!allUsers.isEmpty()) {
			model.addAttribute("data", allUsers);
			model.addAttribute("adminId", adminId);
		}
		System.out.println(allUsers);
		return "showAllUser";
	}

	@GetMapping(value = "/admin/deleteUser")
	public String deleteUser(@RequestParam(name = "userId") long userId,
			@RequestParam(name = "adminId") long adminId,
			Model model) {

		System.out.println("----deleted----");
		UserDto user = new UserDto();
		 user.setUserId(userId);
		 userService.delete(user);

		List<UserDto> allUsers = userService.findAllUserByAdminId(adminId);
		if (!allUsers.isEmpty()) {
			model.addAttribute("data", allUsers);
			model.addAttribute("adminId", adminId);
		}
	//	System.out.println(allUsers);
		
		return "showAllUser";
	}
	
	
	@GetMapping(value = "/admin/updateUserPage")
	public String updateUser(@RequestParam(name = "userId") long userId, UserDto user
		,BindingResult result ,	Model model) {
		model.addAttribute("user", userService.findUser(userId));
		
		return "updateUserPage";
	}
	

}
