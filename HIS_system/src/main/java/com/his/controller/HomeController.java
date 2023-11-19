package com.his.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.his.command.LoginCommand;
import com.his.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	Logger logger=LoggerFactory.getLogger(getClass());
	
	@GetMapping(value="/")
	public String digCal() {
		logger.info("digCal페이지 이동");
		return "digCal/digCal";
	}
	
	
}
