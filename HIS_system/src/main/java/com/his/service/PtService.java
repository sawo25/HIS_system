package com.his.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.his.command.LoginCommand;
import com.his.command.MediLoginCommand;
import com.his.command.PtInsertCommand;
import com.his.command.PtUpdateCommand;
import com.his.dtos.AdminDto;
import com.his.dtos.MediDto;
import com.his.dtos.PtDto;
import com.his.mapper.AdminMapper;
import com.his.mapper.PtMapper;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class PtService {
	
	@Autowired
	private PtMapper ptMapper;
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<PtDto> getPtList(){
		return ptMapper.getPtList();
	}
	
	public boolean addPt(PtInsertCommand ptInsertCommand) {
		PtDto dto=new PtDto();
		dto.setMedi_seq(ptInsertCommand.getMedi_seq());
		dto.setName(ptInsertCommand.getName());
		dto.setDept(ptInsertCommand.getDept());
		dto.setSex(ptInsertCommand.getSex());
		dto.setHeight(ptInsertCommand.getHeight());
		dto.setWeight(ptInsertCommand.getWeight());
		dto.setDiseas(ptInsertCommand.getDiseas());
		
		return ptMapper.addPt(dto);
	}
	
	public PtDto getPt(int pt_seq) {
		return ptMapper.getPt(pt_seq);
	}
	
	public boolean ptUpdate(PtUpdateCommand ptUpdateCommand) {
		PtDto dto=new PtDto();
		
		dto.setPt_seq(ptUpdateCommand.getPt_seq());
		dto.setMedi_seq(ptUpdateCommand.getMedi_seq());
		dto.setDept(ptUpdateCommand.getDept());
		dto.setHeight(ptUpdateCommand.getHeight());
		dto.setWeight(ptUpdateCommand.getWeight());
		dto.setDiseas(ptUpdateCommand.getDiseas());
		
		return ptMapper.ptUpdate(dto);
	}
	
	public void ptDel(int pt_seq) {
		ptMapper.ptDel(pt_seq);
	}
	
	public String mediLogin(MediLoginCommand mediLoginCommand
	           ,HttpServletRequest request
	           ,Model model) {
		MediDto dto = ptMapper.mediLogin(mediLoginCommand.getMedi_seq());
		String path="redirect:/patient/ptChart";
		
		if(dto!=null) {
			if(dto.getName().equals(mediLoginCommand.getName())) {
				System.out.println("의료진이 맞음");
				//session객체에 로그인 정보 저장
				request.getSession().setAttribute("dto", dto);
				return path;
			}else {
				System.out.println("의료진이 아님");
				model.addAttribute("msg", "입력한 정보를 확인하세요");
				path="patient/mediLogin";
			}
		}else {
			System.out.println("의료진이 아닙니다.");
			model.addAttribute("msg", "입력한 정보를 확인하세요--");
			path="patient/mediLogin";
		}
		
		return path;
	}
	
	
	
}
