package com.his.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.his.command.AdmInsertCommand;
import com.his.command.AdmUpdateCommand;
import com.his.command.LoginCommand;
import com.his.command.MediLoginCommand;
import com.his.command.PtInsertCommand;
import com.his.command.PtUpdateCommand;
import com.his.dtos.AdmDto;
import com.his.dtos.AdminDto;
import com.his.dtos.DigDto;
import com.his.dtos.MediDto;
import com.his.dtos.PtDto;
import com.his.mapper.AdmMapper;
import com.his.mapper.AdminMapper;
import com.his.mapper.DigMapper;
import com.his.mapper.PtMapper;
import com.his.util.Util;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class AdmService {
	
	@Autowired
	AdmMapper admMapper;
	
	public List<AdmDto> admList(int adm_pt){
		return admMapper.admList(adm_pt);
	}
	
	public boolean admAdd(AdmInsertCommand admInsertCommand) {
		String adm_date=admInsertCommand.getYear()+""
				+Util.isTwo(admInsertCommand.getMonth()+"")
				+Util.isTwo(admInsertCommand.getDate()+"")
				+Util.isTwo(admInsertCommand.getHour()+"")
				+Util.isTwo(admInsertCommand.getMin()+"");
		
		AdmDto dto=new AdmDto();
		dto.setAdm_seq(admInsertCommand.getAdm_seq());
		dto.setAdm_pt(admInsertCommand.getAdm_pt());
		dto.setAdm_rn(admInsertCommand.getAdm_rn());
		dto.setAdm_date(adm_date);
		dto.setAdm_content(admInsertCommand.getAdm_content());
		dto.setAdm_fill(admInsertCommand.getAdm_fill());
		
		int count=admMapper.admAdd(dto);
		
		return count>0?true:false;
	}
	
	public AdmDto getAdm(int adm_seq) {
		return admMapper.getAdm(adm_seq);
	}
	
	public boolean admUpdate(AdmUpdateCommand admUpdateCommand) {
		AdmDto dto=new AdmDto();
		
		dto.setAdm_seq(admUpdateCommand.getAdm_seq());
		dto.setAdm_content(admUpdateCommand.getAdm_content());
		dto.setAdm_fill(admUpdateCommand.getAdm_fill());
		
		return admMapper.admUpdate(dto);
	}
	
	public void admDel(int adm_seq) {
		admMapper.admDel(adm_seq);
	}
	
}
