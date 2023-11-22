package com.his.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.his.command.DiseasCommand;
import com.his.command.InsertDigCommand;
import com.his.command.UpdateDigCommand;
import com.his.dtos.DigDto;
import com.his.dtos.PtDto;
import com.his.mapper.DigMapper;
import com.his.mapper.PtMapper;
import com.his.util.Util;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class DigService {

	@Autowired DigMapper digMapper;
	
	@Autowired PtMapper ptMapper;
	
	public Map<String, Integer> makeDigCalendar(HttpServletRequest request){
		Map<String, Integer> map=new HashMap<>();
		
		// 달력의 날짜를 바꾸기 위해 전달된 year와 month 파라미터를 받는 코드
		String paramYear=request.getParameter("year");
		String paramMonth=request.getParameter("month");
		
		Calendar cal= Calendar.getInstance();	// 추상클래스이고, static 메서드 new(x)
		
		// 		 						기본 오늘 날짜 지정  	: 		요청된 날짜 지정					
		int year=(paramYear==null)?cal.get(Calendar.YEAR):Integer.parseInt(paramYear);
		int month=(paramMonth==null)?cal.get(Calendar.MONTH)+1:Integer.parseInt(paramMonth);
		//							calendar 객체에서 month는 0~11월
		
		if(month>12) {
			month=1;
			year++;
		}
		if(month<1) {
			month=12;
			year--;
		}
		
		// 1. 월의 1일에 대한 요일 구하기
		cal.set(year, month-1,1);	// 원하는 날짜 선택
		int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);	// 1~7중에 반환(1:월... 7:토)
		// 2. ㅇ월의 마지막 날 구하기
		int lastDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		map.put("year",year);
		map.put("month",month);
		map.put("dayOfWeek",dayOfWeek);
		map.put("lastDay",lastDay);
		
		return map;
		
	}
	
	public List<DigDto> digViewList(String yyyyMM) {
		
		return digMapper.digViewList(yyyyMM);
	}
	
	public boolean insertDig(InsertDigCommand insertDigCommand) throws Exception {
		String dig_date=insertDigCommand.getYear()+""
				+Util.isTwo(insertDigCommand.getMonth()+"")
				+Util.isTwo(insertDigCommand.getDate()+"")
				+Util.isTwo(insertDigCommand.getHour()+"")
				+Util.isTwo(insertDigCommand.getMin()+"");
		
		DigDto dto=new DigDto();
		dto.setPt_seq(insertDigCommand.getPt_seq());
		dto.setMedi_seq(insertDigCommand.getMedi_seq());
		dto.setDiseas(insertDigCommand.getDiseas());
		dto.setContent(insertDigCommand.getContent());
		dto.setDig_date(dig_date);
		
		int pt=dto.getPt_seq();
		ptMapper.diseasUpdate(insertDigCommand.getDiseas(), pt);
		
		int count=digMapper.insertDig(dto);
		
		return count>0?true:false;
	}

	public List<DigDto> digList(String yyyyMMdd){
		return digMapper.digList(yyyyMMdd);
	}

	public DigDto getDig(int dig_seq) {
		return digMapper.getDig(dig_seq);
	}
	
	public boolean digUpdate(UpdateDigCommand updateDigCommand) {
		
	    DigDto dto=new DigDto();
		dto.setDig_seq(updateDigCommand.getDig_seq());
		dto.setDiseas(updateDigCommand.getDiseas());
		dto.setContent(updateDigCommand.getContent());
		
		return digMapper.digUpdate(dto);
	}
}
