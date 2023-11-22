package com.his.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.his.dtos.DigDto;

import java.util.List;


@Mapper
public interface DigMapper {
		
		// 당일의 진료 보여주기
		public List<DigDto> digViewList(String yyyyMM);

		// 진료 추가
		public int insertDig(DigDto dto);

		public List<DigDto> digList(String yyyyMMdd);

		public DigDto getDig(int dig_seq);

		public boolean digUpdate(DigDto dto);

}
