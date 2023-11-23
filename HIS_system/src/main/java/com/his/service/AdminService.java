package com.his.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.his.command.LoginCommand;
import com.his.command.MediInsertCommand;
import com.his.command.MediUpdateCommand;
import com.his.dtos.AdminDto;
import com.his.dtos.MediDto;
import com.his.mapper.AdminMapper;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class AdminService {
	@Autowired
	private AdminMapper adminMapper;
	
	public String adminLogin(LoginCommand loginCommand
	           ,HttpServletRequest request
	           ,Model model) {
		AdminDto dto = adminMapper.adminLogin(loginCommand.getId());
		String path="admin/adminHome";
		if(dto!=null) {
			//로그인 폼에서 입력받은 패스워드값과 DB에 암호화된 패스워드 비교
			if(dto.getPassword().equals(loginCommand.getPassword())) {
				System.out.println("관리자가 맞음");
				//session객체에 로그인 정보 저장
				request.getSession().setAttribute("mdto", dto);
				return path;
			}else {
				System.out.println("패스워드 틀림");
				model.addAttribute("msg", "패스워드를 확인하세요");
				path="admin/adminLogin";
			}
		}else {
			System.out.println("회원이 아닙니다.");
			model.addAttribute("msg", "아이디를 확인하세요");
			path="admin/adminLogin";
		}
		
		return path;
	}
	
	public List<MediDto> getMediList(){
		return adminMapper.getMediList();
	}
	
	public boolean addMedi(MediInsertCommand mediInsertCommand) {
		MediDto dto=new MediDto();
		dto.setJob(mediInsertCommand.getJob());
		dto.setName(mediInsertCommand.getName());
		dto.setDept(mediInsertCommand.getDept());
		dto.setPhone(mediInsertCommand.getPhone());

		return adminMapper.addMedi(dto);
	}
	
	public MediDto getMedi(int medi_seq) {
		return adminMapper.getMedi(medi_seq);
	}
	
	public boolean mediUpdate(MediUpdateCommand mediUpdateCommand) {
		MediDto dto=new MediDto();
		
		dto.setMedi_seq(mediUpdateCommand.getMedi_seq());
		dto.setDept(mediUpdateCommand.getDept());
		dto.setPhone(mediUpdateCommand.getPhone());
		
		return adminMapper.mediUpdate(dto);
	}
	
	public void mediDel(int medi_seq) {
		adminMapper.mediDel(medi_seq);
	}
}