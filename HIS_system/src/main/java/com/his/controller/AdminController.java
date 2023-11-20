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

import com.his.command.LoginCommand;
import com.his.command.MediInsertCommand;
import com.his.command.MediUpdateCommand;
import com.his.dtos.MediDto;
import com.his.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping(value="/adminLogin")
	public String adminLoginForm(Model model) {
		model.addAttribute("loginCommand", new LoginCommand());
		System.out.println("관리자 로그인 폼 이동");
		return "admin/adminLogin";
	}
	
	@PostMapping(value="/adminLogin")
	public String adminLogin(@Validated LoginCommand loginCommand
	           ,BindingResult result
	           ,Model model
	           ,HttpServletRequest request) {
		if(result.hasErrors()) {
			System.out.println("로그인 유효값 오류");
			return "admin/adminLogin";
		}
		
		String path=adminService.adminLogin(loginCommand, request, model);
		
		return path;
	}
	
	@GetMapping(value="/mediList")
	public String getMediList(Model model) {
		System.out.println("의료진 목록");
		
		List<MediDto> list=adminService.getMediList();
		model.addAttribute("list",list);
		return "admin/mediList";
	}
	
	@GetMapping(value="/mediInsert")
	public String mediInsert(Model model) {
		model.addAttribute("mediInsertCommand", new MediInsertCommand());
		System.out.println("의료진 등록 폼 이동");
		return "admin/mediInsert";
	}
	
	@PostMapping(value="/mediInsert")
	public String addMedi(@Validated MediInsertCommand mediInsertCommand,
							BindingResult result, Model model) {
		
		System.out.println("의료진 추가");
		
		if(result.hasErrors()) {
			System.out.println("유효값 오류");
			return "admin/mediInsert";
		}
		
		try {
			adminService.addMedi(mediInsertCommand);
			System.out.println("의료진 등록 성공");
			
			return "redirect:mediList";
		} catch (Exception e) {
			System.out.println("의료진 등록 실패");
			e.printStackTrace();
			
			return "redirect:mediInsert";
		}
	}
	
	@GetMapping(value="/mediDetail")
	public String mediDetail(int medi_seq, Model model) {
		MediDto dto=adminService.getMedi(medi_seq);
		
		model.addAttribute("mediUpdateCommand",new MediUpdateCommand());
		
		model.addAttribute("dto",dto);
		System.out.println(dto);
		return "admin/mediDetail";
	}
	 
	@PostMapping(value="/mediUpdate")
	public String mediUpdate(@Validated MediUpdateCommand mediUpdateCommand
							,BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("수정 내용을 모두 입력하세요");
			return "admin/mediDetail";
		}
		
		adminService.mediUpdate(mediUpdateCommand);
		
		return "redirect:/admin/mediDetail?medi_seq="
				+mediUpdateCommand.getMedi_seq();
	}
	
}