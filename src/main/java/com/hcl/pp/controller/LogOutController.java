package com.hcl.pp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hcl.pp.model.User;

@Controller
public class LogOutController {

	private static final Logger logger= LogManager.getLogger(LogOutController.class);
	@GetMapping("logout")
    public String logout(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		logger.info("User "+user.getUserName()+" successfully loggged out");
        request.getSession().removeAttribute("user");
        request.getSession().invalidate();
        logger.info("redirecting to login page");
        return "redirect:user/login";
    }
}
