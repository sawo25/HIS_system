package com.his.controller;

import java.util.Calendar;
import java.util.List;

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
import com.his.dtos.DigDto;
import com.his.service.AdminService;
import com.his.service.DigService;
import com.his.util.Util;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DigService digService;
	
	@GetMapping(value="/")
	public String digCal(Model model, HttpServletRequest request) {
		logger.info("digCal페이지 이동");
		
		String year=request.getParameter("year");
		String month=request.getParameter("month");
		
		if(year==null||month==null) {
			Calendar cal=Calendar.getInstance();
			year=cal.get(Calendar.YEAR)+"";
			month=(cal.get(Calendar.MONTH)+1)+"";
		}
		
		String yyyyMM=year+Util.isTwo(month);
		
		
		
		return "digCal/digCal";
	}
	
	
}
