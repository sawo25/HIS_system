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
import com.his.command.MediLoginCommand;
import com.his.command.MediUpdateCommand;
import com.his.command.PtInsertCommand;
import com.his.command.PtUpdateCommand;
import com.his.dtos.MediDto;
import com.his.dtos.PtDto;
import com.his.service.AdminService;
import com.his.service.PtService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/patient")
public class PtConroller {

	@Autowired
	private PtService ptService;

	@Autowired
	private AdminService adminService;
	
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

		List<MediDto> mlist=adminService.getMediList();
		model.addAttribute("mlist",mlist);
		
		MediDto dto=new MediDto();
		dto.getMedi_seq();
		model.addAttribute("dto",dto);
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
	
	@GetMapping(value="/ptDetail")
	public String ptDetail(int pt_seq, Model model) {
		PtDto dto=ptService.getPt(pt_seq);
		//
		List<MediDto> mlist=adminService.getMediList();
		model.addAttribute("mlist",mlist);
		
		MediDto mdto=new MediDto();
		mdto.getMedi_seq();
		model.addAttribute("mdto",mdto);
		//
		model.addAttribute("ptUpdateCommand",new PtUpdateCommand());
		
		model.addAttribute("dto",dto);
		System.out.println(dto);
		return "patient/ptDetail";
	}
	
	@PostMapping(value="/ptUpdate")
	public String ptUpdate(@Validated PtUpdateCommand ptUpdateCommand
							,BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("수정 내용을 모두 입력하세요");
			return "patient/ptDetail";
		}
		
		ptService.ptUpdate(ptUpdateCommand);
		
		return "redirect:/patient/ptDetail?pt_seq="
				+ptUpdateCommand.getPt_seq();
	}
	
	@GetMapping(value="/ptDel")
	public String ptDel(int pt_seq){
		ptService.ptDel(pt_seq);
				
		return "redirect:/patient/ptChart";
	}
	
	@GetMapping(value="/mediLogin")
	public String mediLoginForm(Model model) {
		model.addAttribute("mediLoginCommand", new MediLoginCommand());
		System.out.println("관리자 로그인 폼 이동");
		return "patient/mediLogin";
	}
	
	@PostMapping(value="/mediLogin")
	public String adminLogin(@Validated MediLoginCommand mediLoginCommand
	           ,BindingResult result
	           ,Model model
	           ,HttpServletRequest request) {
		if(result.hasErrors()) {
			System.out.println("로그인 유효값 오류");
			return "patient/mediLogin";
		}
		
		String path=ptService.mediLogin(mediLoginCommand, request, model);
		
		return path;
	}
	
}
