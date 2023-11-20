package com.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.his.command.MediInsertCommand;
import com.his.command.PtInsertCommand;
import com.his.dtos.PtDto;
import com.his.service.PtService;

@Controller
@RequestMapping(value="/patient")
public class PtConroller {

	@Autowired
	private PtService ptService;
	
	@GetMapping(value="/ptChart")
	public String getPtList(Model model) {
		System.out.println("환자 목록");
		
		List<PtDto> list=ptService.getPtList();
		model.addAttribute("list",list);
		return "patient/ptChart";
	}
	
	@GetMapping(value="/ptInsert")
	public String ptInsert(Model model) {
		model.addAttribute("ptInsertCommand", new PtInsertCommand());
		System.out.println("환자 등록 폼 이동");
		return "patient/ptInsert";
	}
	
	@PostMapping(value="/ptInsert")
	public String addPt(@Validated PtInsertCommand ptInsertCommand,
							BindingResult result, Model model) {
		
		System.out.println("환자 추가");
		
		if(result.hasErrors()) {
			System.out.println("유효값 오류");
			return "patient/ptInsert";
		}
		
		try {
			ptService.addPt(ptInsertCommand);
			System.out.println("환자 등록 성공");
			
			return "redirect:ptChart";
		} catch (Exception e) {
			System.out.println("환자 등록 실패");
			e.printStackTrace();
			
			return "redirect:ptInsert";
		}
	}
	
}
