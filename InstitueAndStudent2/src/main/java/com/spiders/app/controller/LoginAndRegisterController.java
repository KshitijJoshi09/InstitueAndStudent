package com.spiders.app.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spiders.app.config.Constants;
import com.spiders.app.dto.LoginDetials;
import com.spiders.app.dto.UserDto;
import com.spiders.app.service.UserServiceI;

@Controller
@SessionAttributes(names ="user")
public class LoginAndRegisterController {

	Logger log = Logger.getLogger(LoginAndRegisterController.class);

	@Autowired
	UserServiceI userService;

	@RequestMapping(value = "/signIn")
	public String displaySignInPage(HttpSession session , Model model) {
		
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
		
		
		return "SignInPage";
	}

	@RequestMapping(value = "/loginInUser")
	public String getSignInDetails(LoginDetials details, Model model) {
		System.out.println(details);
		
		//1st step
		UserDto userFromDb = userService.findUser(details.getUserId());
	
		// set the role to identify is admin or not
		String role = userFromDb != null ? userFromDb.getRole() : "";
		
		System.out.println("user from db " + userFromDb);

		if (userFromDb == null) {
			// if email is wrong
			model.addAttribute("loginId", "login id is wrong");
			
			return "SignInPage";
		}
	
		if (!details.getPassword().equals(userFromDb.getPassword())) {
			// if password is wrong
			model.addAttribute("password", "password is wrong");
			return "SignInPage";
		}
		
		//using same varriable name in model will add the object to session also
	    //	model.addAttribute("user", userFromDb);
		
		if (role.equals(Constants.ADMIN_ROLE)) {
			model.addAttribute("user", userFromDb);
			model.addAttribute("userId",userFromDb.getUserId());
			model.addAttribute("userName",userFromDb.getFirstName() + " " +userFromDb.getLastName()  );
			return "AdminDashBoard";
		}

		if (role.equals(Constants.USER_ROLE)) {
			model.addAttribute("user", userFromDb);
			model.addAttribute("userId",userFromDb.getUserId());
			model.addAttribute("userName",userFromDb.getFirstName() + " " +userFromDb.getLastName()  );
			return "UserDashBoard";
		}
		
		return "SignInPage";
		
	}

	@RequestMapping(value = "/AddUserPage/{adminId}")
	String displaySignUpPage(@PathVariable(name = "adminId") long adminId , Model model) {
		System.out.println("display sign up page");
		model.addAttribute("adminId", adminId);
		return "AddUser";
	}

	@RequestMapping("logout")
	String logout(SessionStatus status) {
		status.setComplete();
		System.out.println("get display sign up page details");
		return "index";
	}

}
