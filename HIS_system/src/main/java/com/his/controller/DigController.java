package com.his.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.his.command.DelDigCommand;
import com.his.command.DiseasCommand;
import com.his.command.InsertDigCommand;
import com.his.command.UpdateDigCommand;
import com.his.dtos.DigDto;
import com.his.dtos.MediDto;
import com.his.dtos.PtDto;
import com.his.service.AdminService;
import com.his.service.DigService;
import com.his.service.PtService;
import com.his.util.Util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(value="/digCal")
public class DigController {
	
	Logger logger=LoggerFactory.getLogger(DigController.class);

	@Autowired
	DigService digService;
	@Autowired
	AdminService adminService;
	@Autowired
	PtService ptService;
	
	@GetMapping(value="/insertDigForm")
	public String insertDigForm(@RequestParam Map<String, String>map,
								Model model, InsertDigCommand insertDigCommand,
								HttpServletRequest request) {
		logger.info("진료기록 추가 폼");
		
		System.out.println("insertDigCommand");
		
		HttpSession session=request.getSession();

		List<PtDto> plist=ptService.getPtList();
		model.addAttribute("plist",plist);
		
		PtDto pdto=new PtDto();
		pdto.getPt_seq();
		model.addAttribute("pdto",pdto);
		
		List<MediDto> mlist=adminService.getMediList();
		model.addAttribute("mlist",mlist);
		
		MediDto mdto=new MediDto();
		mdto.getMedi_seq();
		mdto.getJob();
		model.addAttribute("mdto",mdto);
		
		if(map.get("year")==null) {
			map=(Map<String, String>)session.getAttribute("ymdMap");
		}else {
			session.setAttribute("ymdMap", map);
		}
		
		model.addAttribute("insertDigCommand",insertDigCommand);
		
		return "digCal/insertDigForm";
	}
	
	@PostMapping(value="/insertDig")
	public String insertDig(@Validated DiseasCommand diseasCommand,@Validated InsertDigCommand insertDigCommand
							,BindingResult result) throws Exception {
		logger.info("진료 기록 추가");
		
		System.out.println("insertDigCommand");
		
		if(result.hasErrors()) {
			System.out.println("기록을 모두 입력하세요");
			return "digCal/insertDigForm";
		}
		
		digService.insertDig(insertDigCommand);
		return "redirect:/?year="+insertDigCommand.getYear()
								+"&month="+insertDigCommand.getMonth();
	}
	
	@GetMapping(value = "/digList")
	public String calBoardList(@RequestParam Map<String, String>map
							, HttpServletRequest request
							, Model model) {
		logger.info("일정목록보기");
		
		//command 유효값 처리를 위해 기본 생성해서 보내줌
		model.addAttribute("delDigCommand", new DelDigCommand());
		
		HttpSession session=request.getSession();
		
		if(map.get("year")==null) {
			//조회한 상태이기때문에 ymd가 저장되어 있어서 값을 가져옴
			map=(Map<String, String>)session.getAttribute("ymdMap");
		}else {
			//일정을 처음 조회했을때 ymd를 저장함
			session.setAttribute("ymdMap", map);
		}
		
		//달력에서 전달받은 파라미터 year, month, date를 8자리로 만든다.
		String yyyyMMdd=map.get("year")
				       +Util.isTwo(map.get("month"))
				       +Util.isTwo(map.get("date"));
		List<DigDto> list= digService.digList(yyyyMMdd);
		model.addAttribute("list", list);
	
		int[] seqlist=new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			seqlist[i]=list.get(i).getPt_seq();
		}
		
		List<String> pname=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			pname.add(ptService.ptName(seqlist[i]));
		}
		model.addAttribute("pname",pname);
		
		return "digCal/digList";
	}
	
	@GetMapping(value = "/digDetail")
	public String digDetail(int dig_seq, Model model) {
		logger.info("진료 기록 상세보기");
		
		DigDto dto=digService.getDig(dig_seq);
		int pseq=dto.getPt_seq();
		String pname=ptService.ptName(pseq);
		
		model.addAttribute("updateDigCommand", new UpdateDigCommand());
		
		model.addAttribute("dto",dto);
		model.addAttribute("pname",pname);
		System.out.println(dto);
		return "digCal/digDetail";
	}
	
	@PostMapping(value = "/digUpdate")
	public String digUpdate(@Validated UpdateDigCommand updateDigCommand
								,BindingResult result) {
		
		logger.info("일정수정하기");
		
		if(result.hasErrors()) {
			System.out.println("수정할 목록을 확인하세요.");
			return "digCal/digDetail";
		}
		
		digService.digUpdate(updateDigCommand);
		return "redirect:/digCal/digDetail?dig_seq="+updateDigCommand.getDig_seq();
	}
	
	@PostMapping(value = "/digMulDel")
	public String digMulDel(@Validated DelDigCommand delDigCommand,
							BindingResult result,
							HttpServletRequest request,
							Model model) {
		
		if(result.hasErrors()) {
			System.out.println("최소 하나 이상 체크하기");
			
			HttpSession session=request.getSession();
			
			//session에 저장된 ymd 값은 목록 조회할때 추가되는 코드임
			Map<String, String>map=(Map<String, String>)session.getAttribute("ymdMap");
			
			//달력에서 전달받은 파라미터 year, month, date를 8자리로 만든다.
			String yyyyMMdd=map.get("year")
					       +Util.isTwo(map.get("month"))
					       +Util.isTwo(map.get("date"));
			List<DigDto> list= digService.digList(yyyyMMdd);
			model.addAttribute("list", list);
			return "digCal/digList";
		}
		Map<String,String[]>map=new HashMap<>();
		map.put("dig_seqs", delDigCommand.getDig_seq());
		digService.digMulDel(map);
		
		return "redirect:/digCal/digList";
	}
	
	@GetMapping("/digMulDel")
	public String dig_Del(String[] dig_seq) {
		logger.info("일정삭제하기");
		System.out.println(dig_seq[0]);
		Map<String,String[]>map=new HashMap<>();
		map.put("dig_seqs", dig_seq); 
		digService.digMulDel(map);
		return "redirect:/digCal/digList";
	}
	
	

}
