package com.his.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.his.dtos.DigDto;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;

@Mapper
public interface DigMapper {

	// 달력 생성시 필요한 값 구하는 메서드 
		public Map<String, Integer> makeDigCalendar(HttpServletRequest request);
		
		// 당일의 진료 보여주기
		public List<DigDto> digViewList(String yyyyMM);

}
