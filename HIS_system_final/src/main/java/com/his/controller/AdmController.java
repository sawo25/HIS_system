package com.his.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.his.command.AdmInsertCommand;
import com.his.command.AdmUpdateCommand;
import com.his.command.DelDigCommand;
import com.his.command.LoginCommand;
import com.his.command.MediInsertCommand;
import com.his.command.MediLoginCommand;
import com.his.command.MediUpdateCommand;
import com.his.command.PtDelCommand;
import com.his.command.PtInsertCommand;
import com.his.command.PtUpdateCommand;
import com.his.command.UpdateDigCommand;
import com.his.dtos.AdmDto;
import com.his.dtos.DigDto;
import com.his.dtos.MediDto;
import com.his.dtos.PtDto;
import com.his.service.AdmService;
import com.his.service.AdminService;
import com.his.service.DigService;
import com.his.service.PtService;
import com.his.util.Util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;

@Controller
@RequestMapping(value="/adm")
public class AdmController {

	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AdmService admService;
	@Autowired
	private PtService ptService;
	
	@GetMapping(value="/admList")
	public String admList(int adm_pt, Model model,HttpServletRequest request) {
		System.out.println("환자 처치 목록");
		
		HttpSession session=request.getSession();
		session.setAttribute("pt_seq", adm_pt);
		
		List<AdmDto> list=admService.admList(adm_pt);
		model.addAttribute("list",list);

		String pName=ptService.ptName(adm_pt);
		model.addAttribute("pname",pName);
		
		
		return "adm/admList";
	}
	
	@GetMapping(value="/admInsertForm")
	public String admInsert(Model model, AdmInsertCommand admInsertCommand 
							,HttpServletRequest request) {
		logger.info("처치기록 추가 폼");
		
		System.out.println("admInsertCommand");
		
		HttpSession session=request.getSession();
		int adm_pt=(int)session.getAttribute("pt_seq");
		
		model.addAttribute("pt_seq",adm_pt);
		model.addAttribute("admInsertCommand", admInsertCommand);
		
		return "adm/admInsert";
	}
	
	@PostMapping(value="/admInsert")
	public String admInsert(@Validated AdmInsertCommand admInsertCommand,
							BindingResult result, Model model, HttpServletRequest request) {
		logger.info("진료 기록 추가");
		
		if(result.hasErrors()) {
			System.out.println("기록을 모두 입력하세요");
			return "adm/admInsertForm";
		}
		
		admService.admAdd(admInsertCommand);
		
		HttpSession session=request.getSession();
		int adm_pt=(int)session.getAttribute("pt_seq");

		return "redirect:/adm/admList?adm_pt="+adm_pt;
	}
	
	@GetMapping(value="/admDetail")
	public String getDig(int adm_seq, Model model, HttpServletRequest request) {
		logger.info("처치기록 상세 보기");
		
		AdmDto dto=admService.getAdm(adm_seq);
		
		model.addAttribute("admUpdateCommand", new AdmUpdateCommand());
		model.addAttribute("dto",dto);
		System.out.println(dto);
		
		HttpSession session=request.getSession();
		int adm_pt=(int)session.getAttribute("pt_seq");
		String pName=ptService.ptName(adm_pt);
		model.addAttribute("pname",pName);
		model.addAttribute("pt_seq",adm_pt);
		
		return "adm/admDetail";
	}
	
	@PostMapping(value="/admUpdate")
	public String admUpdate(@Validated AdmUpdateCommand admUpdateCommand,
							BindingResult result) {
		logger.info("처치 기록 수정하기");
		
		if(result.hasErrors()) {
			System.out.println("수정할 목록을 확인하세요");
			return "adm/admDetail";
		}
		
		admService.admUpdate(admUpdateCommand);
		return "redirect:/adm/admDetail?adm_seq="+admUpdateCommand.getAdm_seq();
	}
	
	@GetMapping(value="/admDel")
	public String admDel(int adm_seq, HttpServletRequest request) {
		admService.admDel(adm_seq);
		
		HttpSession session=request.getSession();
		int adm_pt=(int)session.getAttribute("pt_seq");

		return "redirect:/adm/admList?adm_pt="+adm_pt;
	}
	
}
