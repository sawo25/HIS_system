package com.his.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.his.command.PtInsertCommand;
import com.his.dtos.PtDto;
import com.his.mapper.PtMapper;

@Service
public class PtService {
	
	@Autowired
	private PtMapper ptMapper;
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
}
